# Demoblaze - Automatización E2E + Pruebas de API

Este repositorio contiene la solución completa del ejercicio solicitado, que incluye:

- Automatización del flujo de compra E2E en [Demoblaze.com](https://www.demoblaze.com)
- Pruebas de servicios REST para `signup` y `login` usando Karate DSL
- 
---

## Estructura del Proyecto

```
E2E, APIS/
├── E2E/                        # Proyecto Selenium Java con POM
│   ├── demoblaze-automation/
│   ├── pom.xml
│   ├── src/
│   └── datos.properties        # Datos de prueba externos
│
├── APIS/                       # Proyecto de pruebas API con Karate
│   ├── demoblaze-karate/
│   ├── karate-1.5.1.jar
│   └── DemoblazeTest.feature
│
├── readme.txt
└── conclusiones.txt
```

---

## Tecnologías Utilizadas

- Java 17
- Selenium WebDriver
- Apache Maven
- Karate DSL
- Git + GitHub
- Page Object Model (POM)
- Archivos ".properties" para manejo externo de datos

---

## Flujo Automatizado E2E

1. Navegar a [Demoblaze](https://www.demoblaze.com)
2. Agregar productos al carrito
3. Validar productos añadidos
4. Llenar el formulario de compra
5. Confirmar el mensaje final: "Thank you for your purchase!"

---

##  Pruebas de API

Las pruebas en `DemoblazeTest.feature` cubren los siguientes escenarios:

- Crear un usuario nuevo (`/signup`)
- Intentar crear un usuario existente
- Login exitoso con credenciales válidas (`/login`)
- Login con credenciales incorrectas

---

##  Requisitos

- Java JDK 17 o superior
- Apache Maven
- Git Bash o CMD
- Navegador Google Chrome (estable)

---

## 👤 Autor

**Alexander Castro Echeverri**  
GitHub: [Guardian3333](https://github.com/Guardian3333/Devsu-Ejercicio)

---