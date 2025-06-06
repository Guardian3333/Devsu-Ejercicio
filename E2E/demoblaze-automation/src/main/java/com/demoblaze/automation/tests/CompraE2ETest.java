package com.demoblaze.automation.tests;

import com.demoblaze.automation.base.BaseTest;
import com.demoblaze.automation.pages.CartPage;
import com.demoblaze.automation.pages.HomePage;
import com.demoblaze.automation.pages.ProductPage;
import com.demoblaze.automation.utils.DatosProperties;
import com.demoblaze.automation.utils.ElementosWeb;
public class CompraE2ETest extends BaseTest {

    public static void main(String[] args) {

        CompraE2ETest test = new CompraE2ETest();
        test.setup();
        String[] productosEsperados = DatosProperties.obtenerProductos();

        try {
            HomePage home = new HomePage(test.driver);
            ProductPage producto = new ProductPage(test.driver);
            CartPage carrito = new CartPage(test.driver);

            for (String productoNombre : productosEsperados) {
                home.seleccionarProductoPorNombre(productoNombre);
                producto.agregarProductoAlCarrito();
                producto.aceptarAlerta();
                home.irAlHome();
            }


            carrito.irAlCarrito();
            boolean productosCorrectos = carrito.validarProductosEnCarrito(productosEsperados);
            ElementosWeb elementos = new ElementosWeb(test.driver);
            elementos.imprimirResultadoValidacion(productosCorrectos, productosEsperados, "Productos en carrito");



            carrito.hacerClickEnPlaceOrder();
            carrito.completarFormularioCompra(
            	    DatosProperties.obtenerDato("nombre"),
            	    DatosProperties.obtenerDato("pais"),
            	    DatosProperties.obtenerDato("ciudad"),
            	    DatosProperties.obtenerDato("tarjeta"),
            	    DatosProperties.obtenerDato("mes"),
            	    DatosProperties.obtenerDato("anio")
            	);

            boolean compraExitosa = carrito.validarCompraExitosa("Thank you for your purchase!");
            if (compraExitosa) {
                System.out.println(" Compra realizada exitosamente.");
            } else {
                System.out.println("Falló la validación del mensaje de compra.");
            }

            carrito.cerrarMensajeConfirmacion();
            Thread.sleep(3000); // Espera visual final

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            test.tearDown();
        }
    }
}


