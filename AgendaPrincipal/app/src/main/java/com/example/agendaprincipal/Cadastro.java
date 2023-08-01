package com.example.agendaprincipal;

import android.app.Service;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class   Cadastro extends AppCompatActivity {
    EditText cCodigo;
    EditText cNome;
    EditText cTelefone;
    EditText cEmail;
    EditText cEndereco;
    EditText cCor;
    Button btSalvar;
    Button btExcluir;
    Button btLimpar;
    ListView viewPessoa;

    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;

    InputMethodManager imm;
    Banco_dados db = new Banco_dados(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        imm = (InputMethodManager) this.getSystemService ( Service.INPUT_METHOD_SERVICE );
        cCodigo = findViewById(R.id.txtCodigo);
        cNome = findViewById(R.id.edt_nome);
        cTelefone = findViewById(R.id.edt_celular);
        cEmail = findViewById(R.id.edt_email);
        cEndereco = findViewById(R.id.edt_endereco);
        cCor = findViewById(R.id.edt_cor);
        btSalvar = findViewById(R.id.btnSalvar);
        btExcluir = findViewById(R.id.btnExcluir);
        btLimpar = findViewById(R.id.btnLimpar);
        viewPessoa = findViewById(R.id.listViewPessoa);


        db = new Banco_dados(this);

        cNome.requestFocus();

        viewPessoa.setOnItemClickListener ( new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick (AdapterView<?> adapterView, View view, int position, long id) {
                String conteudo = (String)
                        viewPessoa.getItemAtPosition (position);

                String codigo = conteudo.substring(0, conteudo.indexOf("-"));

                Pessoa pessoa = db.selecionarPessoa (Integer.parseInt(codigo));
                cCodigo.setText(String.valueOf (pessoa.getCodigo()) );
                cNome.setText(pessoa.getNome ());
                cTelefone.setText(pessoa.getTelefone());
                cEmail.setText(pessoa.getEmail());
                cEndereco.setText(pessoa.getEndereco());
                cCor.setText(pessoa.getCor());

            }


        });

    btLimpar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            limpaCampos();
        }
    });

    btSalvar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String codigo = cCodigo.getText().toString();
            String nome = cNome.getText().toString();
            String telefone = cTelefone.getText().toString();
            String email = cEmail.getText().toString();
            String endereco =  cEndereco.getText().toString();
            String cor =  cCor.getText().toString();

            // Dentro do método onClick do botão salvar

            if (nome.isEmpty()) {
                cNome.setError("Este campo é obrigatório");
            } else if (codigo.isEmpty()) {
                // Se o código estiver vazio, significa que é uma nova pessoa a ser inserida

                db.addPessoa(new Pessoa(nome, telefone, email, endereco, cor));
                Toast.makeText(Cadastro.this, "Cadastro salvo com sucesso", Toast.LENGTH_SHORT).show();
                listarPessoas();
                limpaCampos();
                escondeTeclado();
            } else {
                // Caso contrário, significa que é uma pessoa existente a ser atualizada

                int idPessoa = Integer.parseInt(codigo); // Converter o código para um inteiro

                // Criar uma instância de Pessoa com os valores atualizados
                Pessoa pessoaAtualizada = new Pessoa(idPessoa, nome, telefone, email, endereco, cor);

                db.atualizarPessoa(pessoaAtualizada); // Atualizar a pessoa no banco de dados
                Toast.makeText(Cadastro.this, "Cadastro atualizado com sucesso", Toast.LENGTH_SHORT).show();
                listarPessoas();
                limpaCampos();
                escondeTeclado();
            }

        }
    });

    btExcluir.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String codigo = cCodigo.getText().toString();
            if (codigo.isEmpty()){
                Toast.makeText(Cadastro.this, "Nenhuma pessoa" +
                        " está selecionada", Toast.LENGTH_SHORT).show();

            }else{

                Pessoa pessoa = new Pessoa();
                pessoa.setCodigo(Integer.parseInt(codigo));
                db.apagarPessoa(pessoa);
                Toast.makeText(Cadastro.this, "Registro da pessoa apagada " +
                        "com sucesso", Toast.LENGTH_SHORT).show();
                cCodigo.setText("");
                listarPessoas();
                limpaCampos();

            }
        }
    });
    }
    void escondeTeclado(){
        imm.hideSoftInputFromWindow( cNome.getWindowToken(),0);
    }
    public void limpaCampos() {
        cCodigo.setText("");
        cNome.setText("");
        cTelefone.setText("");
        cEmail.setText("");
        cEndereco.setText("");
        cCor.setText("");
    }

    public void listarPessoas(){

        List<Pessoa> pessoas = db.listaPessoa();

        arrayList = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(Cadastro.this, android.R.layout.simple_list_item_1, arrayList);


        viewPessoa.setAdapter(adapter);

        for(Pessoa c : pessoas){
            //Log.d( "Lista", "\nID: " + c.getCodigo() + "Nome: " + c.getNome(  ));            //arrayList. add( c.getCodigo() + "-" + c.getCodigo());
            arrayList.add(c.getCodigo() + "-" + c.getNome());
            adapter.notifyDataSetChanged();
        }
    }
}