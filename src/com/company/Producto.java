package com.company;

public class Producto {


    public int cantidad;
    public String nombre;
    public String tipo;


    public Producto (String Nombre,int cantidad , String tipo){
        this.cantidad=cantidad;
        this.nombre=Nombre;
        this.tipo=tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
