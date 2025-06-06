
README - Instrucciones de ejecución

Requisitos previos:
- Tener Java instalado (versión 11 o superior).
- Descargar el archivo karate-1.5.1.jar desde GitHub (ya incluido).

Archivos incluidos:
- karate-1.5.1.jar= Motor de pruebas Karate.
- DemoblazeTest.feature= Contiene los 4 escenarios del ejercicio.
- conclusiones.txt= Hallazgos y reflexiones del ejercicio.

Cómo ejecutar la prueba:
1. Abrir una terminal o consola en la carpeta donde están los archivos.
2. Ejecutar el siguiente comando:
   java -jar karate-1.5.1.jar DemoblazeTest.feature
3. Esperar unos segundos y verás los resultados en consola.
4. Puedes revisar también el reporte HTML que se genera en la carpeta: target/karate-reports

Escenarios implementados:
1. Crear un nuevo usuario en signup
2. Intentar crear un usuario ya existente
3. Usuario y password correcto en login
4. Usuario y password incorrecto en login

Qué valida cada prueba:
- Que se pueda registrar un usuario nuevo.
- Que el sistema avise si el usuario ya está registrado.
- Que se pueda hacer login correctamente.
- Que muestre error si la contraseña no es válida.