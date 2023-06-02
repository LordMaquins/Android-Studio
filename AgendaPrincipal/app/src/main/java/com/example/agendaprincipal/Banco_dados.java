package com.example.agendaprincipal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


    public class Banco_dados extends SQLiteOpenHelper {
    public static final int VERSAO_BANCO = 1;
    public static final String BancoAgenda= "DB_age";
    public Banco_dados(Context context){
        super(context,BancoAgenda, null, VERSAO_BANCO);
    }
    public static final String TABELA_PESSOA= "tb_pessoa";
    public static final String COLUNA_CODIGO= "codigo";
    public static final String COLUNA_NOME= "nome";
    public static final String COLUNA_EMAIL= "email";
    public static final String COLUNA_TELEFONE= "telefone";
    public static final String COLUNA_ENDERECO= "endereço";
}
        @Override
        public void onCreate(SQLiteDatabase db) { //Método para criar a tabela

            String CRIAR_TABELA = "CREATE TABLE " + TABELA_PESSOA + "(" + COLUNA_CODIGO + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    +COLUNA_NOME + "TEXT," +  COLUNA_EMAIL + "TEXT," +  COLUNA_TELEFONE + "TEXT," + COLUNA_ENDERECO + "TEXT)"; // Criando uma variavel com o código que será executado no SQL

            db.execSQL(CRIAR_TABELA); // Um método do SQLiteDatabase é utilizado dentro do objeto db para criar a tabela
        }

        @Override

        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }

        void addPessoa(Pessoa pessoa){ // Criando o método addPessoa vai inserir os valores digitados no aplicativo para dentro do banco de dados

            SQLiteDatabase db = this.getWritableDatabase(); // foi criado uma variável local com as propriedades do SQLiteDatabase possuindo acesso ao metodo getWritableDatabase

            ContentValues valor = new ContentValues(); // Instanciamos as proriedades de ContentValues na variavel valor, assim ela tem acesso aos métodos e atributos da classe

            valor.put(COLUNA_NOME, pessoa.getNome()); // objeto valor usando um método do ContentValues para pegar dados do front-end
            valor.put(COLUNA_EMAIL, pessoa.getEmail()); // objeto valor usando um método do ContentValues para pegar dados do front-end
            valor.put(COLUNA_TELEFONE, pessoa.getTelefone()); // objeto valor usando um método do ContentValues para pegar dados do front-end
            valor.put(COLUNA_ENDERECO, pessoa.getEndereco());  // objeto valor usando um método do ContentValues para pegar dados do front-end

            db.insert(TABELA_PESSOA, null, valor); // objeto db usando um método  SQLiteDatabase para inserir no banco de dados
            db.close(); // objeto db usando um metodo do SQLiteDatabase para fechar o banco de dados

        }

        void apagarPessoa(Pessoa pessoa) { // Criação do método apagarPessoa, que vai deletar os dados da pessoa do banco de dados, utilizando uma busca pelo ID
            SQLiteDatabase db = this.getWritableDatabase(); // Criamos uma variavel local com as propriedades do SQLiteDatabase e que tem acesso ao método getWritableDatabase
            db.delete(TABELA_PESSOA, COLUNA_CODIGO + " =?", new String[]{ // objeto db usando um metodo do SQLiteDatabase
                    String.valueOf(pessoa.getCodigo()) // objeto String usando um método e objeto pessoa usando outro método
            });

            db.close(); // objeto db usando o metodo para fechar o banco de dados
        }

        Pessoa selecionarPessoa(int codigo) { // Criação do método selecionarPessoa, que irá retornar os dados da pessoa selecionada

            SQLiteDatabase db = this.getReadableDatabase(); // Criamos uma variavel local com as propriedades do SQLiteDatabase e que tem acesso ao metodo getReadableDatabase
            Cursor cursor = db.query(TABELA_PESSOA, new String[]{COLUNA_CODIGO, COLUNA_NOME, COLUNA_EMAIL, COLUNA_TELEFONE, COLUNA_ENDERECO}, // instanciamos o cursor em uma variavel de mesmo nome, usamo um metodo dentro do objeto db que faz uma busca no banco de dados onde ele vai precisar apenas do id da pessoa para mostrar os outros valores
                    COLUNA_CODIGO + " =?", new String[]{String.valueOf(codigo)}, null, null, null, null);

            if(cursor != null) {
                cursor.moveToFirst(); // se o cursor ja tiver algum valor ele retornará para o inicio para estará pronto para uma nova busca.
            }

            Pessoa pessoa = new Pessoa(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4)); // instanciamos a classe pessoa no o objeto pessoa, que terá os textos de todas as células, o cursor irá passar. o objeto cursor pega os textos das células com o método getString que ele ganhou da classe Cursor

            return pessoa; // retorna o valor de pessoa

        }

        void atualizarPessoa(Pessoa pessoa){ // Criação do método atualizarPessoa, que vai atualizar os dados da pessoa pelo front-end e depois atualizará no banco de dados

            SQLiteDatabase db = this.getWritableDatabase(); // Criamos uma variavel local com as propriedades do SQLiteDatabase e que tem acesso ao metodo getWritableDatabase

            ContentValues valor = new ContentValues(); //Instanciamos as proriedades de ContentValues na variavel valor, assim ela tem acesso aos metodos e atributos da classe

            valor.put(COLUNA_CODIGO, pessoa.getCodigo()); // objeto valor usando um metodo do ContentValues para utilizar dados do front-end
            valor.put(COLUNA_NOME, pessoa.getNome()); // objeto valor usando um metodo do ContentValues para utilizar dados do front-end
            valor.put(COLUNA_EMAIL, pessoa.getEmail()); // objeto valor usando um metodo do ContentValues para utilizar dados do front-end
            valor.put(COLUNA_TELEFONE, pessoa.getTelefone()); // objeto valor usando um metodo do ContentValues para utilizar dados do front-end
            valor.put(COLUNA_ENDERECO, pessoa.getEndereco()); // objeto valor usando um metodo do ContentValues para utilizar dados do front-end


            db.update(TABELA_PESSOA, valor,COLUNA_CODIGO + " =?", new String[]{String.valueOf(pessoa.getCodigo())}); // objeto db utilizando um método do SQLitedatabase para atualizar a tabela, e a classe String usando um método para atribuir o valor do objeto pessoa que está utilizando um método para recuperar os dados inseridos pelo front end.
            db.close(); // objeto db usando método para encerrar o banco de dados.
        }
        public List<Pessoa> listaPessoa() {

            List<Pessoa> pessoaLista = new ArrayList<Pessoa>();

            String query = "SELECT * FROM " + TABELA_PESSOA;

            SQLiteDatabase db = this.getWritableDatabase();

            Cursor cursor = db.rawQuery(query, null);

            if (cursor.moveToFirst()) {
                do {

                    Pessoa pessoa = new Pessoa();

                    pessoa.setCodigo(Integer.parseInt(cursor.getString(0)!=null?cursor.getString( 0 ):"0"));
                    pessoa.setNome(cursor.getString(1));
                    pessoa.setTelefone(cursor.getString(2));
                    pessoa.setEmail(cursor.getString(3));
                    pessoa.setEndereco(cursor.getString(4));

                    pessoaLista.add(pessoa);

                } while (cursor.moveToNext());
            }

            return pessoaLista;

        }

    }


    }
