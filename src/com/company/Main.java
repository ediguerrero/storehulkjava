package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
Tienda x =new Tienda();

x.crearproducto("javon",5,Tienda.CAMISETA);

System.out.println(x.getProductos().get(0).nombre+" "+ x.getProductos().get(0).cantidad+""+x.getProductos().get(0).tipo);
    }
}
