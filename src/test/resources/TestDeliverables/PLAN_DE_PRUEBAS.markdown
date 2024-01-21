# AUTOMATIZACIÓN DE PRUEBAS FUNCIONALES BOOKING.COM /MOBILE

### 📄 Contexto:

Booking.com es un agregador de tarifas de viaje y un metabuscador de viajes para reservas de
alojamiento. Booking.com forma parte de Booking Holdings Inc., y cuenta con más de 17.000 trabajadores
en 198 oficinas de 70 países de todo el mundo. Booking.com tiene su sede en Ámsterdam, Países Bajos.

### ☠ Problemática:

Cada vez que se hacen cambios en la aplicación móvil de Booking.com se deben efectuar todo un conjunto
de pruebas manuales de los casos de prueba ya diseñados en sus Test Suite, con el objetivo de verificar
que ninguna funcionalidad disponible para los usuarios haya sido alterada o impactada por los nuevos
cambios implementados y desplegados en producción.

### 💡 Solución:

Con el objetivo de mejorar la eficiencia y garantizar el correcto desempeño de la aplicación móvil 
tras la implementación de cambios, se proponen conjuntos de pruebas automatizadas orientadas al front-end. 
Esto facilita la realización de pruebas de manera regular y ágil, agilizando la identificación de posibles 
errores durante la fase de desarrollo. Este enfoque contribuye a incrementar la velocidad del proceso de prueba, 
asegurando una evaluación exhaustiva de las funcionalidades proporcionadas por la aplicación.

***

# 🤖 PLAN DE PRUEBAS FUNCIONAL




### 🎯 OBJETIVO

Verificar que el proceso de reserva de alojamiento en la aplicación de Booking funcione correctamente y que 
los datos proporcionados sean consistentes con la reserva realizada.

### SUPUESTOS

* La app se encuentra siempre en funcionamiento.
* Acceso a la apk de la aplicación.
* Herramientas de pruebas como AndroidStudio, Appium Server y Appium Desktop correctamente instalados y configurados.
* Conocimientos en Mobile Testing.

### ALCANCE

* El plan de pruebas se centrará en la funcionalidad de reservar alojamiento en 
Cusco utilizando la aplicación de Booking.
* Contemplar mínimo un **_HAPPY PATH_** y **_UNHAPPY PATH_**.


### Pruebas de Regresión:
La característica se marcará con la etiqueta @Regression para indicar que 
estas pruebas deben ejecutarse regularmente para garantizar que los cambios 
futuros no afecten la funcionalidad existente.
### RIESGOS

| Riesgo                                                    | Mitigación                                                                                                             |
|:----------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------|
| No tener acceso a la apk del aplicativo                   | Solicitar al dev el envío de la apk.                                                                                   |
| No se tiene un dispositivo mobile real para pruebas       | Utilizar un emulador para la conexión.                                                                                 |
| No se puede realizar la conexión con el dispositivo       | Utilizar una plataforma de testeo móvil como (BrowserStack, Lambda Test, etc                                           |
| No se puede inspeccionar el dispositivo por 'secure' flag | Imprimir el Código Fuente de la pantalla con el comando **driver.getPageSource()** y realice la inspección con este código |

***

### 👨‍💻 Herramientas

* **Android Studio**: como herramienta de apoyo para emular un dispositivo mobile.
* **Appium Server**: como herramienta para crear una sesión que permita interactuar con los dispositivos finales de las aplicaciones móviles.
* **Appium Inspector**: como herramienta de apoyo para mapear los elementos de la app. 

* **Serenity BDD en integración con Appium**: Frameworks principales para realizar la automatización de los
  scripts de pruebas.
* **Plan de pruebas**: Documento para la planificación de las pruebas.
* **APK**: Link de descarga del apk de [Booking.com](https://drive.google.com/file/d/1ruY_5qcqWlsE3-W3rgXpFyyMiO59wFUc/view?usp=sharing)

### CONFIGURACIÓN DEL AMBIENTE

* Las pruebas serán ejecutadas en un dispositivo **Android**.
* El dispositivo móvil será emulado desde **Android Studio**


### PASOS DE PRUEBA:

    1. Ingresar a la aplicación de Booking.
    2. Registrar los datos de alojamiento, incluyendo la ciudad (Cusco), fechas de inicio y fin, y la edad de los niños.
    3. Seleccionar el segundo ítem del resultado de alojamiento.
    4. Completar los datos de la persona que realizará la reserva.
    5. Confirmar los datos del costo, fecha de inicio y fecha fin de la reserva.
    6. Elegir la forma de pago como tarjeta de crédito y registrar el número de tarjeta y fecha de expedición.
    7. Validar que el valor de la reserva sea el esperado (US$7.036 en este ejemplo).

***Criterios de Éxito:***

    No se producen errores durante el proceso de reserva.
    Los datos registrados coinciden con los datos visualizados en la confirmación de la reserva.
    El valor de la reserva es el esperado.

Ambiente de Pruebas:

Dispositivo móvil o emulador compatible con la aplicación de Booking.
Datos válidos para realizar la reserva (ciudad, fechas, etc.).
Conexión a Internet para la realización de la reserva.

### FLUJOS A PROBAR (dentro de alcance)

Test diseñados para validar los escenarios **Happy Paths** 😃

***Característica:*** Creación de un servicio completo de alojamiento
Como usuario, quiero utilizar el servicio de reservas, para buscar mi mejor opción de alojamiento

> **✨ FEATURE**: Booking | Reservar alojamiento en CUSCO desde Booking
- [x] [Dado] que el usuario ingresa a la app de booking registrando los datos de alojamiento

- [x] [Y] - selecciona el segundo ítem del resultado de alojamiento para elegir la habitación a reservar

- [x] [Cuando] - completa los datos de la persona que realizará la reserva confirma los datos del costo

- [x] [Y] - elegi la forma de pago tarjeta de crédito registrando su numero con la fecha de expedición
- [x] [Entonces] - valida que el valor de la reserva es el correcto
***

Test diseñados para validar los escenarios **UNHappy Paths** 🤡

> **✨ FEATURE**: UnHappy Paths | Validar que no se permita buscar un alojamiento sin ingresar una ciudad de destino
- [x] [Dado] que el usuario seleccione la opción de buscar sin colocar la cuidad de destino
- [x] [Cuando] - selecciona el segundo ítem del resultado de alojamiento para elegir la habitación a reservar
- [x] [Y] - no ingresa datos de registros
- [x] [Entonces] - vera la alerta de "Introduce tu nombre." valor requerido
***


### ENTEGRABLES DE PRUEBAS

> ☑️ El plan de pruebas actual, la ruta de su ubicación es: `resources/TestDeliverables/PLAN_DE_PRUEBAS.markdown`  
> ☑️ El informe del resultado de pruebas, la ruta de su ubicación es: `target/site/serenity/serenity-summary.html`   
> ☑️ El repositorio en GitHub con los scripts
> desarrollados: [booking-mobile-automation-testing](https://github.com/osborrero/reto_tecnico_mobile.git)
***

### ❗ INFORMACIÓN ADICIONAL

> *Toda la información relacionada a la estructura del proyecto se especifica en el archivo README.md*
> *Las validaciones del precio se realizan correctamente*
***