package com.example.asignacin_amigo_secreto;// RegistroActivity.java

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RegistroActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextName;
    private EditText editTextLastName;
    private EditText editTextDescripcionRegalo;
    private EditText editTextPrecioRegalo;
    private Button buttonRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextName = findViewById(R.id.editTextName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextDescripcionRegalo = findViewById(R.id.editTextDescripcionRegalo);
        editTextPrecioRegalo = findViewById(R.id.editTextPrecioRegalo);
        buttonRegistrar = findViewById(R.id.buttonRegistrar);

        buttonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los valores ingresados por el usuario
                String username = editTextUsername.getText().toString().trim();
                String name = editTextName.getText().toString().trim();
                String lastName = editTextLastName.getText().toString().trim();
                String descripcionRegalo = editTextDescripcionRegalo.getText().toString().trim();
                int precioRegalo = Integer.parseInt(editTextPrecioRegalo.getText().toString().trim());

                // Realizar las validaciones pertinentes
                if (username.isEmpty() || name.isEmpty() || lastName.isEmpty() || descripcionRegalo.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Crear el objeto JSON con los datos ingresados
                JSONObject registroObject = new JSONObject();
                try {
                    registroObject.put("username", username);
                    registroObject.put("name", name);
                    registroObject.put("lastName", lastName);

                    JSONArray giftsArray = new JSONArray();
                    JSONObject giftObject = new JSONObject();
                    giftObject.put("description", descripcionRegalo);
                    giftObject.put("price", precioRegalo);
                    giftsArray.put(giftObject);

                    registroObject.put("gifts", giftsArray);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                // Enviar la solicitud POST a la URL utilizando Volley
                String url = "http://20.253.245.188:8080/api/user";

                Volley.newRequestQueue(getApplicationContext()).add(new JsonObjectRequest(Request.Method.POST, url, registroObject,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Error en el registro: " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }));

            }
        });
    }
}




