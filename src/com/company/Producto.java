package com.company;

public class Producto {


    public int cantidad;



    public double precio;

    public String nombre;
    public String tipo;


    public Producto (String Nombre,int cantidad , double precio,String tipo){
        this.cantidad=cantidad;
        this.nombre=Nombre;
        this.tipo=tipo;
        this.precio=precio;
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
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
