package com.daa.fragment.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.daa.fragment.R;
import com.daa.fragment.fragment.ChatsFragment;
import com.daa.fragment.fragment.ContactosFragment;

import com.daa.fragment.utils.Fragmento;

/*
Aplicar las 5 principios de buen diseño en OOP utilizando los S.O.L.I.D
        [S]ingle Responsibility Principle
        [O]pen/Closed Principle
        [L]iskov Substitution Principle
        [I]nterface Segregation Principle
        [D]ependency Inversion Principle

Caso a aplicar: [S]ingle Responsibility Principle
Referencia: https://medium.com/@mari_azevedo/s-o-l-i-d-principles-what-are-they-and-why-projects-should-use-them-50b85e4aa8b6
*/

//public class MainActivity extends AppCompatActivity {
public class MainActivity extends FragmentActivity {
    private Button btnChat, btnContacto;
    private ChatsFragment chatsFragment;
    private ContactosFragment contactosFragment;
    private Fragment fragment;

    private Fragmento fragmento;
    private FragmentActivity fragmentActivity;
    private FragmentManager fragmentManager;

    private String TITLE_FRM;
    private String TYPE_FRM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Cargando los botones
        btnChat = findViewById(R.id.btnChat);
        btnContacto = findViewById(R.id.btnContacto);

        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Usando una funcion genérica
                fragment = new ChatsFragment();
                fragmentManager = getSupportFragmentManager();
                Fragmento fragmento = new Fragmento(fragment,fragmentManager);
                fragmento.cargarFragmento();

            }
        });

        btnContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new ContactosFragment();

                /*
                Refatoring 3
                Crear una clase excluisava para cargar fragmenttos, para que cumple totalmente con la (S) del principio de SOLID de buenas prácticas de desarrollo a nivel clases
                */
                fragmentManager = getSupportFragmentManager();
                Fragmento fragmento = new Fragmento(fragment,fragmentManager);
                fragmento.cargarFragmento();
            }
        });

    }

}