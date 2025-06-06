package com.demoblaze.automation.tests;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.demoblaze.automation.pages.*;
import com.demoblaze.automation.utils.*;
import com.demoblaze.automation.base.BaseTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class CompraE2ETestNG extends BaseTest {

    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeClass
    public void setUp() {
        setup();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("Compra E2E - Demoblaze", "Flujo completo de compra con evidencias");
        
        
    }

    @Test
    public void testCompraE2E() throws IOException{
       
    	HomePage home = new HomePage(driver);
        ProductPage producto = new ProductPage(driver);
        CartPage carrito = new CartPage(driver);
        ElementosWeb elementos = new ElementosWeb(driver);
        String[] productosEsperados = DatosProperties.obtenerProductos();
        
       
        try {
            for (String productoNombre : productosEsperados) {
            	
            	 Thread.sleep(1000);
            	 test.pass("Abre Navegador ingresando www.demoblaze.com", MediaEntityBuilder.createScreenCaptureFromPath(CapturaPantalla.tomarCaptura(driver, "Abre Navegador ingresando a www.demoblaze.com")).build());

                home.seleccionarProductoPorNombre(productoNombre);
                Thread.sleep(1000);
                test.pass("Producto seleccionado: " + productoNombre, MediaEntityBuilder.createScreenCaptureFromPath(CapturaPantalla.tomarCaptura(driver, "ProductoSeleccionado_" + productoNombre)).build());

                producto.agregarProductoAlCarrito();
                Thread.sleep(1000);
                test.pass("Producto agregado al carrito: " + productoNombre, MediaEntityBuilder.createScreenCaptureFromPath(CapturaPantalla.tomarCaptura(driver, "ProductoAgregado_" + productoNombre)).build());

                producto.aceptarAlerta();
                Thread.sleep(500);
                home.irAlHome();
            }

            carrito.irAlCarrito();
            Thread.sleep(1000);
            test.pass("Vista del carrito", MediaEntityBuilder.createScreenCaptureFromPath(CapturaPantalla.tomarCaptura(driver, "VistaCarrito")).build());

            boolean productosCorrectos = carrito.validarProductosEnCarrito(productosEsperados);
            elementos.imprimirResultadoValidacion(productosCorrectos, productosEsperados, "Productos en carrito");
            test.pass("Validación de productos en carrito", MediaEntityBuilder.createScreenCaptureFromPath(CapturaPantalla.tomarCaptura(driver, "ValidacionCarrito")).build());

            carrito.hacerClickEnPlaceOrder();
            Thread.sleep(1000);
            test.pass("Formulario de compra visible", MediaEntityBuilder.createScreenCaptureFromPath(CapturaPantalla.tomarCaptura(driver, "FormularioCompraVisible")).build());

            carrito.completarFormularioCompra(
                DatosProperties.obtenerDato("nombre"),
                DatosProperties.obtenerDato("pais"),
                DatosProperties.obtenerDato("ciudad"),
                DatosProperties.obtenerDato("tarjeta"),
                DatosProperties.obtenerDato("mes"),
                DatosProperties.obtenerDato("anio")
            );
            
            Thread.sleep(1000);
            test.pass("Formulario Lleno", MediaEntityBuilder.createScreenCaptureFromPath(CapturaPantalla.tomarCaptura(driver, "Formulario Lleno")).build());

            carrito.hacerClickEnComprar();

            Thread.sleep(1000);
            test.pass("Formulario enviado", MediaEntityBuilder.createScreenCaptureFromPath(CapturaPantalla.tomarCaptura(driver, "Formulario Enviado")).build());

            boolean compraExitosa = carrito.validarCompraExitosa("Thank you for your purchase!");
            if (compraExitosa) {
                test.pass("Compra realizada exitosamente", MediaEntityBuilder.createScreenCaptureFromPath(CapturaPantalla.tomarCaptura(driver, "CompraExitosa")).build());
            } else {
                test.fail("Falló la validación del mensaje de compra", MediaEntityBuilder.createScreenCaptureFromPath(CapturaPantalla.tomarCaptura(driver, "CompraFallida")).build());
            }

            carrito.cerrarMensajeConfirmacion();
            Thread.sleep(3000);

        } catch (Exception e) {
            String path = CapturaPantalla.tomarCaptura(driver, "Error_E2E");
            test.fail("Error capturado: " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        extent.flush();
    }
}
