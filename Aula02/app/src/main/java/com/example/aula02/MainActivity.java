package com.example.aula02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    double vnum1,vnum2,vresul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         //Codigo Calculadora
        {
            Button btn_somar = (Button) findViewById(R.id.btn_somar);
            Button btn_subtrair= (Button) findViewById(R.id.btn_subtrair);
            Button btn_dividir= (Button) findViewById(R.id.btn_dividir);
            Button btn_multiplicar= (Button) findViewById(R.id.btn_multiplicar);
                EditText et_valor1=(EditText) findViewById(R.id.ed_valor1);
                EditText et_valor2= (EditText) findViewById(R.id.ed_valor2);
            TextView tv_resultado=(TextView) findViewById(R.id.tv_resultado);

            //Rotina soma
            btn_somar.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    vnum1=Double.parseDouble(et_valor1.getText().toString());
                    vnum2=Double.parseDouble(et_valor2.getText().toString());
                    vresul=vnum1 + vnum2;
                    tv_resultado.setText(String.valueOf(vresul));
            }
        });

            // Rotina Multiplicar
            btn_multiplicar.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    vnum1=Double.parseDouble(et_valor1.getText().toString());
                    vnum2=Double.parseDouble(et_valor2.getText().toString());
                    vresul = vnum1 * vnum2;
                    tv_resultado.setText(String.valueOf(vresul));
                }
            });
                //Rotina Dividir
            btn_dividir.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    vnum1=Double.parseDouble(et_valor1.getText().toString());
                    vnum2=Double.parseDouble(et_valor2.getText().toString());
                    vresul = vnum1 / vnum2;
                    tv_resultado.setText(String.valueOf(vresul));
                }
            });
            //Rotina Subtrair
            btn_subtrair.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    vnum1=Double.parseDouble(et_valor1.getText().toString());
                    vnum2=Double.parseDouble(et_valor2.getText().toString());
                    vresul = vnum1 - vnum2;
                    tv_resultado.setText(String.valueOf(vresul));
                }
            });
            Button btn_Limpar = findViewById(R.id.btn_Limpar);
            btn_Limpar.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    tv_resultado.setText(""); // Limpa o conteúdo do EditText
                    et_valor1.setText("");
                    et_valor2.setText("");
                }
            });


        };












        }
        }
