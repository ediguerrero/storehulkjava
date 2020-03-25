package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private JList lista;

    public Window(Tienda tienda) {
        JButton boton1 = new JButton("hola");

        this.setSize(600, 400);
        lista = new JList(tienda.darnombres());
        lista.setSize(200,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.getContentPane().add(lista, BorderLayout.WEST);

        JLabel nombre1 = new JLabel("Nombre del producto");
        JTextField nombre = new JTextField("hola");
        JLabel contidad1 = new JLabel("cantidad en stock");
        JTextField cantidad = new JTextField("hola");
        JLabel precio1 = new JLabel("precio");
        JTextField precio = new JTextField("hola");
        JLabel tipo1 = new JLabel("tipo");
        JComboBox tipo = new JComboBox();

        tipo.addItem("CAMISETA");
        tipo.addItem("VASO");
        tipo.addItem("JUGUETE");
        tipo.addItem("ACCESORIO");

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


        JDialog insertarproducto=new JDialog();
        insertarproducto.setTitle("agrega un producto");
        insertarproducto.setSize(400,400);
        insertarproducto.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        insertarproducto.setLayout(new BorderLayout());
JPanel panel3=new JPanel();
panel3.setLayout(new GridLayout(8, 2));

        JLabel nombre2 = new JLabel("Nombre del producto");
        JTextField nombre3 = new JTextField("hola");
        JLabel contidad12 = new JLabel("cantidad en stock");
        JTextField cantidad3 = new JTextField("3");
        JLabel precio12 = new JLabel("precio");
        JTextField precio3 = new JTextField("3");
        JLabel tipo12 = new JLabel("tipo");
        JComboBox tipo3 = new JComboBox();

        tipo3.addItem("CAMISETA");
        tipo3.addItem("VASO");
        tipo3.addItem("JUGUETE");
        tipo3.addItem("ACCESORIO");

        panel3.add(nombre2);

        panel3.add(nombre3);

        panel3.add(contidad12);
        panel3.add(cantidad3);
        panel3.add(precio12);
        panel3.add(precio3);
        panel3.add(tipo12);
        panel3.add(tipo3);
        insertarproducto.add(panel3,BorderLayout.CENTER);
        JButton add =new JButton("agregar producto");
        insertarproducto.add(add,BorderLayout.SOUTH);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    tienda.crearproducto(nombre3.getText(), Integer.parseInt(cantidad3.getText()), Double.parseDouble(precio3.getText()), tipo3.getSelectedItem().toString());
                    insertarproducto.setVisible(false);
                    System.out.println(tienda.getProductos().size());

                    lista.setListData(tienda.darnombres());

                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(insertarproducto, "la cantidad y el precio deben ser de tipo numerico","Cuidado" ,JOptionPane.WARNING_MESSAGE);
                }
                }
        });

        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                insertarproducto.setVisible(true);            }
        });

        lista.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                nombre.setText(lista.getSelectedValue().toString());
            }
        });
    }



}
