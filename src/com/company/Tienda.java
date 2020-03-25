package com.company;

import java.util.ArrayList;

public class Tienda {
    public final static String CAMISETA = "CAMISETA";
    public final static String VASO = "VASO";
    public final static String JUGUETE = "JUGUETE";
    public final static String ACCESORIO = "ACCESORIO";

    public ArrayList<Producto> productos;

    public Tienda() {
        productos = new ArrayList<Producto>();

    }

    public void crearproducto(String nombreproducto, int cantidadproducto, double precio, String tipoproducto) {
        Producto x = new Producto(nombreproducto, cantidadproducto, precio, tipoproducto);
        productos.add(x);


    }

    public void vender(String nombreproducto) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre().equals(nombreproducto)) {
                int cant = productos.get(i).getCantidad();
                productos.get(i).setCantidad(cant - 1);
            }
            System.out.println("vendido");
        }


    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }


    public String[] darnombres() {
        String[] x = new String[productos.size()];
        for (int i = 0; i < productos.size(); i++) {
            x[i] = productos.get(i).getNombre();
        }
        return x;
    }

    public Producto buscarpornombre(String nombre) {
        Producto x = null;
        boolean otro = false;

        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre().equals(nombre)) {
                x = productos.get(i);
                otro = true;
            }
            System.out.println("encontrado");
        }
        return x;
    }

    public Producto actualizarproducto(String nombreproducto, int cantidadproducto, double precio, String tipoproducto) {
        Producto x = null;

        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre().equals(nombreproducto)) {

                productos.get(i).setPrecio(precio);
                productos.get(i).setTipo(tipoproducto);
                productos.get(i).setCantidad(cantidadproducto);
                productos.get(i).setNombre(nombreproducto);
                x = productos.get(i);

                System.out.println("encontrado2");

            }

        }
        return x;
    }
}