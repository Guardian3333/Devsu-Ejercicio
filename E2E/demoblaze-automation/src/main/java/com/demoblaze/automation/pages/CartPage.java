package com.demoblaze.automation.pages;

import com.demoblaze.automation.utils.ElementosWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;
    private ElementosWeb elementos;
    private By botonPlaceOrder = By.xpath("//button[text()='Place Order']");
    private By campoNombre = By.id("name");
    private By campoPais = By.id("country");
    private By campoCiudad = By.id("city");
    private By campoTarjeta = By.id("card");
    private By campoMes = By.id("month");
    private By campoAnio = By.id("year");
    private By botonComprar = By.xpath("//button[text()='Purchase']");
    private By mensajeConfirmacion = By.cssSelector(".sweet-alert h2");
    private By botonOk = By.xpath("//button[text()='OK']");
    private By menuCart = By.id("cartur");
    private By nombreProductoEnTabla = By.xpath("//tbody/tr/td[2]"); 

    
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.elementos = new ElementosWeb(driver);
    }

   
    public void irAlCarrito() {
        elementos.hacerClic(menuCart);
        elementos.esperarElementoVisible(nombreProductoEnTabla, 10);
    }

    public boolean validarProductoAgregado(String nombreEsperado) {
        return elementos.validarTextoIgual(nombreProductoEnTabla, nombreEsperado);
    }
    
    public boolean validarProductosEnCarrito(String[] nombresEsperados) {
        return elementos.validarTextosVisibles(nombresEsperados);
    }

    public void hacerClickEnPlaceOrder() {
        elementos.hacerClic(botonPlaceOrder);
    }

    public void completarFormularioCompra(
            String nombre, String pais, String ciudad, String tarjeta, String mes, String anio
    ) {
        elementos.esperarElementoVisible(campoNombre, 10);
        elementos.escribirTexto(campoNombre, nombre);
        elementos.escribirTexto(campoPais, pais);
        elementos.escribirTexto(campoCiudad, ciudad);
        elementos.escribirTexto(campoTarjeta, tarjeta);
        elementos.escribirTexto(campoMes, mes);
        elementos.escribirTexto(campoAnio, anio);

       
    }

    public void hacerClickEnComprar() {
    	 elementos.hacerClic(botonComprar);
    }
    public boolean validarCompraExitosa(String textoEsperado) {
        elementos.esperarElementoVisible(mensajeConfirmacion, 10);
        return elementos.validarTextoIgual(mensajeConfirmacion, textoEsperado);
    }

    public void cerrarMensajeConfirmacion() {
        elementos.hacerClic(botonOk);
    } 
    
}
