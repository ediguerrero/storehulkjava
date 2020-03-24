package com.company;

import java.util.ArrayList;

public class Tienda {
    public final static String CAMISETA = "CAMISETA";
    public final static String VASO="VASO";
    public final static String JUGUETE = "JUGUETE";
    public final static String ACCESORIO = "ACCESORIO";

    public ArrayList <Producto> productos;

    public void crearproducto(String nombreproducto,int cantidadproducto, String tipoproducto){
        productos =new ArrayList<Producto>();
Producto x=new Producto(nombreproducto,cantidadproducto,tipoproducto);
productos.add(x);


    }
public void borrarproducto (String nombreproducto){
        for (int i=0;i<productos.size();i++){
            if(productos.get(i).getNombre().contains(nombreproducto)){
                productos.remove(i);
            }
            System.out.println("borrado");
        }


}

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }




}
