package com.example.arciniega.proyecto12_sqlitedb;

/**
 * Created by arciniega on 08/07/16.
 */
public class Contacto {
    private String nombre;
    private int id;
    private String telefono;

    public Contacto(){
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
