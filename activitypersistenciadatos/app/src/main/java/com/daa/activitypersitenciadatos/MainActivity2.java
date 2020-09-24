package com.daa.activitypersitenciadatos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private TextView txtNombre, txtEdad, txtEmail;
    private Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Recibiendo datos de la MainActivity
        Bundle datos = getIntent().getExtras();
        txtNombre = findViewById(R.id.txtNombre);
        txtNombre.setText(datos.getString("nombre"));
        
        txtEdad = findViewById(R.id.txtEdad);
        txtEdad.setText(String.valueOf(datos.getInt("edad"))+" años");

        Usuario usuario = (Usuario) datos.getSerializable("usuario");
        txtEmail = findViewById(R.id.txtEmail);
        txtEmail.setText(usuario.getEmail());

        btnRegresar = findViewById(R.id.btnRegresar);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}