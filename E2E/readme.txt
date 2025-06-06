
README - Instrucciones de Ejecución


Requisitos:

- Java JDK 17 o superior
- Apache Maven 3.x
- Eclipse IDE (con soporte para Maven)
- Navegador Google Chrome (versión estable)
- Conexión a Internet para descarga de dependencias Maven

Estructura del Proyecto:
----------------------------

src/
├── main/
│   └── java/
│       └── com.demoblaze.automation
│           ├── base/          → Configuración del WebDriver
│           ├── pages/         → Page Objects para cada vista (Home, Producto, Carrito)
│           ├── utils/         → Funciones reutilizables (esperas, clics, validaciones) y  DatosProperties
│           └── tests/         → Clase de prueba E2E principal
└── resources/
    └── datos.properties       → Archivo externo con data de prueba


Instrucciones de Ejecución:
-------------------------------
1. Abrir Eclipse y seleccionar "Import > Existing Maven Project"
2. Seleccionar la carpeta raíz del proyecto y finalizar
3. Esperar que se descarguen las dependencias automáticamente desde Maven
4. Abrir la clase: com.demoblaze.automation.tests.CompraE2ETest
5. Clic derecho > Run As > Java Application

Flujo Automatizado:
------------------------
1. Ingreso a https://www.demoblaze.com
2. Selección y adición de dos productos al carrito (Samsung Galaxy S6 y Nokia Lumia 1520)
3. Validación de productos en carrito
4. Diligenciamiento del formulario de compra con datos externos
5. Validación del mensaje de compra "Thank you for your purchase!"
6. Cierre del flujo


Manejo de Datos Externos
------------------------
Se utiliza el archivo datos.properties para evitar "Quemar" información dentro del código. Esto mejora la mantenibilidad y escalabilidad.

Ejemplo del archivo datos.properties:

properties
Copiar
Editar
# Productos a agregar
producto1=Samsung galaxy s6
producto2=Nokia lumia 1520

# Datos del formulario
nombre=Prueba
pais=Colombia
ciudad=Bogotá
tarjeta=1234567890123456
mes=06
anio=2025

# URL base del sitio
url=https://www.demoblaze.com


Resultado Esperado:
------------------------
La consola mostrará confirmaciones paso a paso, incluyendo los productos encontrados y la compra exitosa.


Durante la ejecución, la consola debe mostrar mensajes como:

Mensaje de alerta: Product added
- Producto validado correctamente en el carrito.
-Productos en carrito validados
-Compra realizada exitosamente

Al final se confirmará que todos los pasos fueron ejecutados de manera correcta.