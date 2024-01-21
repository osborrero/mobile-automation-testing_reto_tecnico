# language: es

Característica: Creación de un servicio completo de alojamiento
  Como usuario, quiero utilizar el servicio de reservas, para buscar mi mejor opción de alojamiento

  @Regression @TestException
  Escenario: Validar que no se permita buscar un alojamiento sin ingresar una ciudad de destino
    Dado que el usuario seleccione la opción de buscar sin colocar la cuidad de destino
    Cuando le da click a buscar
    Entonces vera el mensaje de "Por favor, introduce tu destino"


  @Regression @TestException
  Escenario: Validar que no permita continuar el proceso de reserva si no coloca nombre del comprador
    Dado que el usuario ingresa a la app de booking registrando los datos de alojamiento "city", "dateStart", "dateEnd" y "ageChildren"
    Cuando selecciona el segundo ítem del resultado de alojamiento para elegir la habitación a reservar
    Y no ingresa datos de registros
    Entonces vera la alerta de "Introduce tu nombre." valor requerido