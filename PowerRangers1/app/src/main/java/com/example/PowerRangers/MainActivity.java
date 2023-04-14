package com.example.PowerRangers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btInicio = findViewById(R.id.jogar);

        btInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                abreSegundaTela();

            }

        });
    }
    private void abreSegundaTela() {
        Intent it = new Intent(this, jogo.class);
        startActivityForResult(it, 1);
    }

}