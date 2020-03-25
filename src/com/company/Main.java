package com.company;

import javax.swing.*;
import java.awt.Toolkit.*;
public class Main {

    public static void main(String[] args) {
	// write your code here
Tienda x =new Tienda();

x.crearproducto("javon",5, 200,Tienda.CAMISETA);

System.out.println(x.getProductos().get(0).nombre+" "+ x.getProductos().get(0).cantidad+""+x.getProductos().get(0).tipo+ ""+x.getProductos().get(0).precio);
        System.out.println(x.getProductos().size());

   // x.borrarproducto("javon");
    //System.out.println(x.getProductos().size());

    Window p=new Window(x);
    p.setVisible(true);
    }


}
