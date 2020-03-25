package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Window extends JFrame {
    private JList lista;

    public Window(Tienda tienda) {

        //este metodo devuelve el tamaño de la pantalla
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
//obtenemos el tamaño de la ventana
        Dimension ventana = this.getSize();
//para centrar la ventana lo hacemos con el siguiente calculo

        this.setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
        ;


        this.setSize(600, 400);
        lista = new JList(tienda.darnombres());
        lista.setSize(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.getContentPane().add(lista, BorderLayout.WEST);

        JLabel nombre1 = new JLabel("Nombre del producto");
        JTextField nombre = new JTextField("");
        nombre.setEditable(false);
        JLabel contidad1 = new JLabel("cantidad en stock");
        JTextField cantidad = new JTextField("");
        JLabel precio1 = new JLabel("precio");
        JTextField precio = new JTextField("");
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
        vender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tienda.vender(nombre.getText());

                Producto x = tienda.buscarpornombre(lista.getSelectedValue().toString());
                if (x != null) {

                    cantidad.setText("" + x.getCantidad());
                }
            }

        });
        JButton agregar = new JButton("agregar producto");
        JButton actualizar = new JButton("actualizar producto");

        panel2.add(vender);
        panel2.add(agregar);
        panel2.add(actualizar);
        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (nombre.getText().equals("")) {
                    JOptionPane.showMessageDialog(actualizar, "agrega un producto primero ", "Cuidado", JOptionPane.WARNING_MESSAGE);

                } else {


                    try {

                        int can1 = Integer.parseInt(cantidad.getText().split(" ")[0]);
                        double pre1 = Double.parseDouble(precio.getText().split(" ")[0]);


                        Producto x = tienda.actualizarproducto(nombre.getText(), can1, pre1, tipo.getSelectedItem().toString());

                        if (x != null) {
                            cantidad.setText("" + x.getCantidad());
                            precio.setText("" + x.getPrecio());
                            tipo.setSelectedItem(x.getTipo());
                        }

                        JOptionPane.showMessageDialog(actualizar, "producto actualizado de manera correcta", "excelente", JOptionPane.INFORMATION_MESSAGE);


                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(actualizar, "la cantidad y el precio deben ser de tipo numerico ", "Cuidado", JOptionPane.WARNING_MESSAGE);


                    } catch (NullPointerException e) {
                        JOptionPane.showMessageDialog(actualizar, "el producto no existe, so se puede actualizar", "Cuidado", JOptionPane.WARNING_MESSAGE);

                    }
                }
            }
        });
        this.add(panel2, BorderLayout.SOUTH);


        JDialog insertarproducto = new JDialog();
        insertarproducto.setLocationRelativeTo(this);
        insertarproducto.setTitle("agrega un producto");
        insertarproducto.setSize(400, 400);
        insertarproducto.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        insertarproducto.setLayout(new BorderLayout());
        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(8, 2));

        JLabel nombre2 = new JLabel("Nombre del producto");
        JTextField nombre3 = new JTextField("");
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
        insertarproducto.add(panel3, BorderLayout.CENTER);
        JButton add = new JButton("agregar producto");
        insertarproducto.add(add, BorderLayout.SOUTH);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int can = Integer.parseInt(cantidad3.getText().split(" ")[0]);
                    double pre = Double.parseDouble(precio3.getText().split(" ")[0]);
                    if (tienda.buscarpornombre(nombre3.getText()) == null) {
                        tienda.crearproducto(nombre3.getText(), can, pre, tipo3.getSelectedItem().toString());
                        insertarproducto.setVisible(false);
                        System.out.println(tienda.getProductos().size());

                        lista.setListData(tienda.darnombres());

                    } else
                        JOptionPane.showMessageDialog(insertarproducto, "ya existe un producto con ese nombre", "Cuidado", JOptionPane.WARNING_MESSAGE);

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(insertarproducto, "la cantidad y el precio deben ser de tipo numerico", "Cuidado", JOptionPane.WARNING_MESSAGE);
                } catch (NullPointerException e) {

                }
            }
        });

        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                insertarproducto.setVisible(true);
            }
        });

        lista.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                nombre.setText(lista.getSelectedValue().toString());
                Producto x = tienda.buscarpornombre(lista.getSelectedValue().toString());
                if (x != null) {

                    cantidad.setText("" + x.getCantidad());
                    precio.setText("" + x.getPrecio());
                    tipo.setSelectedItem(x.getTipo());


                } else
                    JOptionPane.showMessageDialog(insertarproducto, "el producto no existe", "Cuidado", JOptionPane.WARNING_MESSAGE);

            }
        });
    }


}
