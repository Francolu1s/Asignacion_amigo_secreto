package com.example.asignacin_amigo_secreto;

// InformacionActivity.java //

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InformacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        // Obtener datos del intent (puedes obtener estos datos según tus necesidades)
        String amigoSecreto = getIntent().getStringExtra("amigoSecreto");
        String descripcionRegalo = getIntent().getStringExtra("descripcionRegalo");
        String precioRegalo = getIntent().getStringExtra("precioRegalo");

        // Mostrar los datos en la interfaz
        TextView textViewAmigoSecreto = findViewById(R.id.textViewAmigoSecreto);
        TextView textViewDescripcionRegalo = findViewById(R.id.textViewDescripcionRegalo);
        TextView textViewPrecioRegalo = findViewById(R.id.textViewPrecioRegalo);

        textViewAmigoSecreto.setText("Amigo Secreto: " + amigoSecreto);
        textViewDescripcionRegalo.setText("Descripción del Regalo: " + descripcionRegalo);
        textViewPrecioRegalo.setText("Precio del Regalo: " + precioRegalo);
    }
}
