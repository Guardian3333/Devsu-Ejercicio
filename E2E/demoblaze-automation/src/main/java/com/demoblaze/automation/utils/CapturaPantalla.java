package com.demoblaze.automation.utils;

import org.openqa.selenium.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CapturaPantalla {

    public static String tomarCaptura(WebDriver driver, String nombreBase) {
        try {
            // 1. Verifica si hay una alerta abierta
            try {
                Alert alerta = driver.switchTo().alert();
                alerta.accept();
                Thread.sleep(500);
            } catch (NoAlertPresentException ignored) {}

            // 2. Toma la captura
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            // 3. Ruta relativa para el reporte
            String relativePath = "capturas/" + nombreBase + "_" + timestamp + ".png";
            String outputPath = "test-output/" + relativePath;

            // 4. Crear carpeta si no existe
            Files.createDirectories(Paths.get("test-output/capturas"));
            Files.copy(srcFile.toPath(), Paths.get(outputPath));

            return relativePath;  // ✅ Ruta relativa para que se muestre correctamente en el HTML

        } catch (Exception e) {
            System.out.println("❌ Error al capturar pantalla: " + e.getMessage());
            return null;
        }
    }
}
