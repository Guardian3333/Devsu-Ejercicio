package com.demoblaze.automation.pages;

import com.demoblaze.automation.utils.DatosProperties;
import com.demoblaze.automation.utils.ElementosWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private ElementosWeb elementos;
 
    
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.elementos = new ElementosWeb(driver);
    }

    public void irAlHome() {
        String url = DatosProperties.obtenerDato("url.base");
        driver.get(url);
    }


    public void seleccionarProductoPorNombre(String nombreProducto) {
        By producto = By.xpath("//a[contains(@class,'hrefch') and text()='" + nombreProducto + "']");
        elementos.esperarElementoClickable(producto, 10);
        elementos.hacerClic(producto);
    }

}
