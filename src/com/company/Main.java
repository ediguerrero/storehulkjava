package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Tienda x = new Tienda();

        x.crearproducto("revista", 5, 200, Tienda.CAMISETA);
        x.crearproducto("batman", 5, 200, Tienda.CAMISETA);

        System.out.println(x.getProductos().get(0).getNombre() + " " + x.getProductos().get(0).getCantidad() + "" + x.getProductos().get(0).getTipo() + "" + x.getProductos().get(0).getPrecio());
        System.out.println(x.getProductos().get(1).getNombre() + " " + x.getProductos().get(1).getCantidad() + "" + x.getProductos().get(1).getTipo() + "" + x.getProductos().get(1).getPrecio());

        System.out.println(x.getProductos().size());

        // x.borrarproducto("javon");
        //System.out.println(x.getProductos().size());

        Window p = new Window(x);
        p.setVisible(true);
    }


}
