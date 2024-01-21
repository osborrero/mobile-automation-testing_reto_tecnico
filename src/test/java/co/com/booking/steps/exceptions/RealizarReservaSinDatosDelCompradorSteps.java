package co.com.booking.steps.exceptions;

import co.com.booking.questions.ObtainText;
import co.com.booking.tasks.booking.ValidateValuesRequired;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static co.com.booking.steps.conf.Hooks.USUARIO_BOOKING;
import static co.com.booking.userinterface.user_data.UserDataPage.TXT_FIRST_NAME_REQUIRED;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;


public class RealizarReservaSinDatosDelCompradorSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger(RealizarReservaSinDatosDelCompradorSteps.class.getSimpleName());

    @Y("no ingresa datos de registros")
        public void no_ingresa_datos_de_registros() {
            USUARIO_BOOKING.attemptsTo(ValidateValuesRequired.noRecords());

    }

    @Entonces("vera la alerta de {string} valor requerido")
        public void vera_la_alerta_de_valor_requerido(String message){
        USUARIO_BOOKING.should(seeThat(ObtainText.element(TXT_FIRST_NAME_REQUIRED), containsString(message)));
    }
}
