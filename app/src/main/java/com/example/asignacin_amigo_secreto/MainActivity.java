package com.example.asignacin_amigo_secreto;

// MainActivity.java
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnRegistro;
    private Button btnAsignacionAmigoSecreto;
    private Button btnInformacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtener referencias a los botones
        btnRegistro = findViewById(R.id.buttonRegistro);
        btnAsignacionAmigoSecreto = findViewById(R.id.buttonAsignacionAmigoSecreto);
        btnInformacion = findViewById(R.id.buttonInformacion);

        // Establecer listeners para los botones
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });

        btnAsignacionAmigoSecreto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AsignacionAmigoSecretoActivity.class);
                startActivity(intent);
            }
        });

        btnInformacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InformacionActivity.class);
                startActivity(intent);
            }
        });
    }
}
