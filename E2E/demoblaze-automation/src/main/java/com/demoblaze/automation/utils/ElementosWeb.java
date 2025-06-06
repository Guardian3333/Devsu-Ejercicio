package com.demoblaze.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementosWeb {

    private WebDriver driver;

    public ElementosWeb(WebDriver driver) {
        this.driver = driver;
    }

    public void hacerClic(By localizador) {
        driver.findElement(localizador).click();
    }

    public void escribirTexto(By localizador, String texto) {
        WebElement campo = driver.findElement(localizador);
        campo.clear();
        campo.sendKeys(texto);
    }

    public void esperarElementoVisible(By localizador, int segundos) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(segundos));
        wait.until(ExpectedConditions.visibilityOfElementLocated(localizador));
        // Forzar scroll hacia el elemento (opcional)
        try {
            WebElement element = driver.findElement(localizador);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception ignored) {}
    }


    public void esperarElementoClickable(By localizador, int segundos) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(segundos));
        wait.until(ExpectedConditions.elementToBeClickable(localizador));
    }
    
    public boolean validarTextoIgual(By localizador, String textoEsperado) {
        String textoObtenido = driver.findElement(localizador).getText();
        System.out.println("Texto encontrado: " + textoObtenido);
        return textoObtenido.equalsIgnoreCase(textoEsperado);
    }
    public boolean validarTextosVisibles(String[] textosEsperados) {
        boolean todosVisibles = true;
        for (String texto : textosEsperados) {
            try {
                By localizador = By.xpath("//*[contains(text(),'" + texto + "')]");
                esperarElementoVisible(localizador, 5);
                System.out.println("Texto encontrado: " + texto);
            } catch (Exception e) {
                System.out.println("Texto no encontrado: " + texto);
                todosVisibles = false;
            }
        }
        return todosVisibles;
    }
    
    public void imprimirResultadoValidacion(boolean resultado, String[] valoresEsperados, String entidad) {
        String lista = String.join(", ", valoresEsperados);
        if (resultado) {
            System.out.println(entidad + " validados correctamente: [" + lista + "]");
        } else {
            System.out.println("Falló la validación de " + entidad + ": [" + lista + "]");
        }
    }

}
