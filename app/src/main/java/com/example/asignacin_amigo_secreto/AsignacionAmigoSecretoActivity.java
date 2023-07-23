package com.example.asignacin_amigo_secreto;// AssignationAmigoSecretoActivity.java

// AsignacionAmigoSecretoActivity.java

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AsignacionAmigoSecretoActivity extends AppCompatActivity {

    private TextView textViewAmigoSecreto;
    private Button buttonVerInformacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignacion_amigo_secreto);

        textViewAmigoSecreto = findViewById(R.id.textViewAmigoSecreto);
        buttonVerInformacion = findViewById(R.id.buttonVerInformacion);

        // Aquí asumimos que se ha obtenido el nombre del amigo secreto asignado mediante un servicio web REST
        String amigoSecreto = "Nombre del Amigo Secreto"; // Reemplazar por el nombre obtenido

        textViewAmigoSecreto.setText(amigoSecreto);

        buttonVerInformacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la pantalla de Información del amigo secreto asignado
                Intent intent = new Intent(AsignacionAmigoSecretoActivity.this, InformacionActivity.class);
                startActivity(intent);
            }
        });
    }
}

