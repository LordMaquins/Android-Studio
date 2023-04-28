package com.example.agendaprincipal;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

    public class Banco_dados extends SQLiteOpenHelper {
    public static final int VERSAO_BANCO = 1;
    public static final String BancoAgenda= "DB_age";
    public Banco_dados(Context context){
        super(content,BancoAgenda, null, VERSAO_BANCO);
    }
    public static final String TABELA_PESSOA= "tb_pessoa";
    public static final String COLUNA_CODIGO= "codigo";
    public static final String COLUNA_NOME= "nome";
    public static final String COLUNA_EMAIL= "email";
    public static final String COLUNA_TELEFONE= "telefone";
    public static final String COLUNA_ENDERECO= "endereço";
}
