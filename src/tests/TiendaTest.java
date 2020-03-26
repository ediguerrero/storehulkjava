package tests;

import com.company.Tienda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TiendaTest {
    Tienda x;
public void escenario(){

       x=new Tienda();
        x.crearproducto("revista", 5, 200, Tienda.CAMISETA);
    }


    @org.junit.jupiter.api.Test
    void crearproducto() {
      escenario();
        assertNotNull(x.getProductos().get(0));
    }

    @org.junit.jupiter.api.Test
    void vender() {
escenario();
x.vender(x.getProductos().get(0).getNombre());
assertEquals(4,x.getProductos().get(0).getCantidad());

    }

    @org.junit.jupiter.api.Test
    void getProductos() {
    escenario();
        assertNotNull(x.getProductos());

    }



    @org.junit.jupiter.api.Test
    void darnombres() {
    escenario();
    String esperado=x.darnombres()[0];
    assertEquals("revista",esperado);
    }

    @org.junit.jupiter.api.Test
    void buscarpornombre() {
    escenario();
        assertNotNull(x.buscarpornombre("revista"));

    }


}