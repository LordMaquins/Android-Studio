package com.example.compras;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.*;
import android.view.*;

public class TrocarTela extends Activity {

    Button btnFim, btnVoltar;

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        CarregarTelaPrincipal();
    }
    public void CarregarTelaPrincipal()
    {
        setContentView(R.layout.activity_main);
        btnVoltar= (Button) findViewById(R.id.btnFim);
        btnVoltar.setOnClickListener(new
        View.OnClickListener() {

            @Override
            public void onClick(View v) {

                TrocarTela();

            }

        });
        public class TrocarTela extends Activity {
        public void ComprasActivity()
        {
            setContentView(R.layout.ComprasActivity);
            btnFim = (Button) findViewById
                    (R.id.btbVoltar);
            btnFim.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ComprasActivity();
                }

            });

        }
    }

}


