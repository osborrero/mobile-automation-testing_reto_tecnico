# language: es

Característica: Creación de un servicio completo de alojamiento
  Como usuario, quiero utilizar el servicio de reservas, para buscar mi mejor opción de alojamiento

  @Regression
  Esquema del escenario: Reservar alojamiento en CUSCO desde Booking
      Dado que el usuario ingresa a la app de booking registrando los datos de alojamiento "city", "dateStart", "dateEnd" y "ageChildren"
      Y selecciona el segundo ítem del resultado de alojamiento para elegir la habitación a reservar
      Cuando completa los datos de la persona que realizará la reserva confirma los datos del costo "<Price>", fecha de inicio "<Check-in>" y fecha fin "<Check-Out>"
      Y elegi la forma de pago tarjeta de crédito registrando su numero con la fecha de expedición "<cardNumber>", "<expirationDate>"
      Entonces valida que el valor de la reserva es el correcto
      Ejemplos:
        | Price    | Check-in     | Check-Out      | cardNumber       | expirationDate |
        | US$7.036 | 14 feb. 2024 | 28 feb. 2024   | 4093550009809819 | 04/30          |