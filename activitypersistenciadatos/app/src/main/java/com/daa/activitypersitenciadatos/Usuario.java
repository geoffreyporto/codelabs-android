package com.daa.activitypersitenciadatos;

import java.io.Serializable;

/*
La clase  "Usuario" necesita ser Serializable de tipo objeto a bytes para transforrmarlo
en una estructura de datos (.xml, json, etc..) en memoria o archivo persistido en disco.
*/
public class Usuario implements Serializable {
    private String nombre;
    private String email;
    private Integer Edad;

    public Usuario(String nombre, String email, Integer edad) {
        this.nombre = nombre;
        this.email = email;
        Edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEdad() {
        return Edad;
    }

    public void setEdad(Integer edad) {
        Edad = edad;
    }
}
