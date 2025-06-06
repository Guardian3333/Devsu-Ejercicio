package com.demoblaze.automation.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatosProperties {

    private static Properties propiedades;

    static {
        propiedades = new Properties();
        try (InputStream input = DatosProperties.class.getClassLoader()
                .getResourceAsStream("datos.properties")) {
            if (input != null) {
                propiedades.load(input);
            } else {
                System.out.println("Archivo datos.properties no encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String obtenerDato(String clave) {
        return propiedades.getProperty(clave);
    }

    public static String[] obtenerProductos() {
        int i = 1;
        java.util.List<String> lista = new java.util.ArrayList<>();

        while (true) {
            String clave = "producto" + i;
            String valor = propiedades.getProperty(clave);
            if (valor == null || valor.isBlank()) break;
            lista.add(valor);
            i++;
        }

        return lista.toArray(new String[0]);
    }
}
