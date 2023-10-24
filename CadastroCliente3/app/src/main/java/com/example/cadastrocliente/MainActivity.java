package com.example.cadastrocliente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference minhaReferencia = FirebaseDatabase.getInstance().getReference("CadastroCliente2");

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        minhaReferencia.child("001").child("nome").setValue("Pelé");
        minhaReferencia.child("001").child("E_mail").setValue("peledasilvajr@gmail.com");
        minhaReferencia.child("001").child("Celular").setValue("(14)991583294");
        minhaReferencia.child("001").child("Telefone").setValue("(99)9999999");
        minhaReferencia.child("001").child("Endereço").setValue("Rua ALameda dos Santos");
        minhaReferencia.child("001").child("Complemento").setValue("Apto 73 bloc c");
        minhaReferencia.child("001").child("Estado").setValue("Solteiro");
        minhaReferencia.child("001").child("Cidade").setValue("São Paulo");
        minhaReferencia.child("001").child("CEP").setValue("03164200");
        minhaReferencia.child("001").child("Status ").setValue("Ativo");

        minhaReferencia.child("002").child("nome").setValue("Larissa da Crazy JR");
        minhaReferencia.child("002").child("E_mail").setValue("lariflorzinhathebest@gmail.com");
        minhaReferencia.child("002").child("Celular").setValue("(14)9915432135");
        minhaReferencia.child("002").child("Telefone").setValue("(99)9999999");
        minhaReferencia.child("002").child("Endereço").setValue("Rua Springfield dos Santos");
        minhaReferencia.child("002").child("Complemento").setValue("Apto 74 bloc c");
        minhaReferencia.child("002").child("Estado").setValue("SP");
        minhaReferencia.child("002").child("Cidade").setValue("São Paulo");
        minhaReferencia.child("002").child("CEP").setValue("03564200");
        minhaReferencia.child("002").child("Status ").setValue("Ativo");

        minhaReferencia.child("003").child("nome").setValue("Lucas Cancelado");
        minhaReferencia.child("003").child("E_mail").setValue("lulugamer@gmail.com");
        minhaReferencia.child("003").child("Celular").setValue("(14)994213294");
        minhaReferencia.child("003").child("Telefone").setValue("(99)9999999");
        minhaReferencia.child("003").child("Endereço").setValue("Rua Nyemaier dos Arquitetos");
        minhaReferencia.child("003").child("Complemento").setValue("Apto 63 bloc b");
        minhaReferencia.child("003").child("Estado").setValue("SP");
        minhaReferencia.child("003").child("Cidade").setValue("São Paulo");
        minhaReferencia.child("003").child("CEP").setValue("0205200");
        minhaReferencia.child("003").child("Status ").setValue("Ativo");

        minhaReferencia.child("004").child("nome").setValue("Elizabeth III");
        minhaReferencia.child("004").child("E_mail").setValue("rainhadetudomo@gmail.com");
        minhaReferencia.child("004").child("Celular").setValue("362 6526 2651");
        minhaReferencia.child("004").child("Telefone").setValue("999 999 999 999");
        minhaReferencia.child("004").child("Endereço").setValue("Rua Patronos of England");
        minhaReferencia.child("004").child("Complemento").setValue("Castle");
        minhaReferencia.child("004").child("Estado").setValue("London");
        minhaReferencia.child("004").child("Cidade").setValue("London");
        minhaReferencia.child("004").child("CEP").setValue("012234200");
        minhaReferencia.child("004").child("Status ").setValue("Inativo");

        minhaReferencia.child("005").child("nome").setValue("Juarez");
        minhaReferencia.child("005").child("E_mail").setValue("jujudot.i@gmail.com");
        minhaReferencia.child("005").child("Celular").setValue("(14)991582456");
        minhaReferencia.child("005").child("Telefone").setValue("(99)9999999");
        minhaReferencia.child("005").child("Endereço").setValue("Rua Jacarés selvagens");
        minhaReferencia.child("005").child("Complemento").setValue("Apto 66 bloc c");
        minhaReferencia.child("005").child("Estado").setValue("SP");
        minhaReferencia.child("005").child("Cidade").setValue("São Paulo");
        minhaReferencia.child("005").child("CEP").setValue("06164200");
        minhaReferencia.child("005").child("Status ").setValue("Ativo");

        minhaReferencia.child("006").child("nome").setValue("Allan");
        minhaReferencia.child("006").child("E_mail").setValue("allanlaravel.i@gmail.com");
        minhaReferencia.child("006").child("Celular").setValue("(14)991582456");
        minhaReferencia.child("006").child("Telefone").setValue("(99)9999999");
        minhaReferencia.child("006").child("Endereço").setValue("Rua Tilapia selvagens");
        minhaReferencia.child("006").child("Complemento").setValue("Apto 66 bloc c");
        minhaReferencia.child("006").child("Estado").setValue("SP");
        minhaReferencia.child("006").child("Cidade").setValue("São Paulo");
        minhaReferencia.child("006").child("CEP").setValue("06164200");
        minhaReferencia.child("006").child("Status ").setValue("Ativo");











    }

}