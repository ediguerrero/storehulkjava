package com.company;

public interface TiendaInterface {
    public void crearproducto(String nombreproducto, int cantidadproducto, double precio, String tipoproducto) ;
    public void vender(String nombreproducto) ;
    public String[] darnombres() ;
    public Producto buscarpornombre(String nombre) ;

    public Producto actualizarproducto(String nombreproducto, int cantidadproducto, double precio, String tipoproducto) ;


    }