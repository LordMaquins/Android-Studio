package com.example.compras;

import android.os.Bundle;
import android.app.Activity;
import android.widget.*;
import android.view.*;
import android.app.*;

public class CompActivity extends Activity{

    CheckBox chkarroz, chkleite, chkcarne, chkfeijao;

    Button bttotal;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkarroz = (CheckBox) findViewById(R.id.Chkarroz);

        chkleite = (CheckBox) findViewById(R.id.Chkleite);

        chkcarne = (CheckBox) findViewById(R.id.Chkcarne);

        chkfeijao = (CheckBox) findViewById(R.id.Chkfeijao);

        Button bttotal = (Button) findViewById(R.id.bttotal);

        bttotal.setOnClickListener(new View.OnClickListener(){

            public void onClick(View arg0){

                double total = 0;

                if(chkarroz.isChecked())
                    total += 2.69;

                if (chkleite.isChecked())
                    total += 5.00;

                if(chkcarne.isChecked())
                    total += 9.70;

                if(chkfeijao.isChecked())
                    total += 2.30;

                AlertDialog.Builder dialogo = new AlertDialog.Builder(CompActivity.this);

                dialogo.setTitle("Aviso");
                dialogo.setMessage("Valor total da compra :"
                + String.valueOf(total));

                dialogo.setNeutralButton("OK", null);
                dialogo.show();

            }
        });

    }

}
