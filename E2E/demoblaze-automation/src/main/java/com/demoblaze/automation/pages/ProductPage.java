package com.demoblaze.automation.pages;

import com.demoblaze.automation.utils.ElementosWeb;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    private WebDriver driver;
    private ElementosWeb elementos;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.elementos = new ElementosWeb(driver);
    }

    // Localizador del botón "Add to cart"
    private By botonAgregarCarrito = By.xpath("//a[text()='Add to cart']");

    // Clic en botón para agregar al carrito
    public void agregarProductoAlCarrito() {
        elementos.esperarElementoClickable(botonAgregarCarrito, 10);
        elementos.hacerClic(botonAgregarCarrito);
    }

    // Aceptar la alerta emergente luego de agregar al carrito
    public void aceptarAlerta() {
        try {
            Thread.sleep(2000); // Esperar brevemente a que aparezca la alerta
            Alert alert = driver.switchTo().alert();
            String mensaje = alert.getText();
            System.out.println("Mensaje de alerta: " + mensaje);
            alert.accept();
        } catch (Exception e) {
            System.out.println("No se detectó alerta: " + e.getMessage());
        }
    }
}
