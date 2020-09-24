package com.daa.activitypersitenciadatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private Button btnEnviarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEnviarDatos = findViewById(R.id.btnEnviarDatos);

        btnEnviarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*
                Creando una intención para envio de datos.
                */

                //Enviando Datos del Usuario con variables a MainActivity2
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("nombre","Geoffrey Porto");
                intent.putExtra("edad",28);

                //Enviando Datos del Usuario con objetos a MainActivity2
                Usuario usuario = new Usuario("Geoffrey","geoffrey@gmail.com",24);
                intent.putExtra("usuario",usuario);

                //Cargar la MainActivity2
                iniciarAct(intent);
                //startActivity(intent);
            }
        });
    }

    //Método para cambiar a Activity
    public void iniciarAct (Intent intent) {
        startActivity(intent);
    }

}