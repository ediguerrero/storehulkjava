package com.company;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private JList lista;

    public Window(Tienda tienda) {
        JButton boton1 = new JButton("hola");

        this.setSize(600, 400);
        lista = new JList(tienda.getProductos().toArray());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.getContentPane().add(lista, BorderLayout.WEST);

        JLabel nombre1 = new JLabel("Nombre del producto");
        JTextField nombre = new JTextField("hola");
        JLabel contidad1 = new JLabel("cantidad en stock");
        JTextField cantidad = new JTextField("hola");
        JLabel precio1 = new JLabel("precio");
        JTextField precio = new JTextField("hola");
        JLabel tipo1 = new JLabel("tipo");
        JTextField tipo = new JTextField("hola");

        JPanel contenido = new JPanel();
        contenido.setLayout(new BorderLayout());
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(8, 2));

        panel1.add(nombre1);

        panel1.add(nombre);

        panel1.add(contidad1);
        panel1.add(cantidad);
        panel1.add(precio1);
        panel1.add(precio);
        panel1.add(tipo1);
        panel1.add(tipo);

        this.add(panel1, BorderLayout.CENTER);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());

        JButton vender = new JButton("vender producto");
        JButton agregar = new JButton("agregar producto");
        JButton actualizar = new JButton("actualizar producto");
        panel2.add(vender);
        panel2.add(agregar);
        panel2.add(actualizar);

        this.add(panel2, BorderLayout.SOUTH);
        this.add(contenido, BorderLayout.EAST);
    }

}
