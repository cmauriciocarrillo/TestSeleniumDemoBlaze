Este proyecto contiene un conjunto de pruebas automatizadas utilizando Selenium WebDriver para los navegadores Chrome y Firefox. Las pruebas están parametrizadas para ejecutarse en ambos navegadores.

Repositorio: https://github.com/cmauriciocarrillo/TestSeleniumDemoBlaze

Contenido del archivo search.java
Descripción
La clase search realiza una serie de acciones en la página web https://www.demoblaze.com/, incluyendo la selección de productos, la adición de productos al carrito, la simulación de compras y la validación del mensaje de confirmación de compra.

Pre-requisitos
Tener instalado Java JDK.
Tener instalado Maven.
Tener instalados los drivers de los navegadores Chrome y Firefox.
Añadir los drivers de los navegadores en la carpeta Drivers del proyecto.
Estructura del Código
Imports y Configuración Inicial:

Importa las clases necesarias.
Configura la clase para ejecutar pruebas parametrizadas con JUnit.
Definición de Parámetros:

Define los navegadores a utilizar como parámetros (Chrome y Firefox).
Método setUpDriver():

Configura los drivers de los navegadores antes de ejecutar las pruebas.
Método Search():

Abre la página web.
Realiza una serie de acciones (selección de productos, adición al carrito, llenado de formularios).
Valida la aparición del mensaje de confirmación de compra.
Manejo de Excepciones:

Captura excepciones durante la ejecución de las pruebas y muestra mensajes de error detallados.
Método tearDown():

Cierra el navegador al finalizar la prueba.