package com.example.PowerRangers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class validação {
    public class MainActivity extends AppCompatActivity {

        Button btnVal;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            btnVal = findViewById(R.id.validar);

            btnVal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    abreTerceiraTela();

                }

            });
        }
        private void abreTerceiraTela() {
            Intent it = new Intent(this, jogo.class);
            startActivityForResult(it, 1);
        }

    }
}
