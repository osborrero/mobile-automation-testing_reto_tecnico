package co.com.booking.steps.exceptions;

import co.com.booking.questions.IsEnabled;
import co.com.booking.questions.ObtainText;
import co.com.booking.tasks.common.NavigateTo;
import ensure.Ensure;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static co.com.booking.steps.conf.Hooks.USUARIO_BOOKING;
import static co.com.booking.userinterface.stays.HomePage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class BuscarAlojamientoSinDestinoSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger(BuscarAlojamientoSinDestinoSteps.class.getSimpleName());

    @Dado("que el usuario seleccione la opción de buscar sin colocar la cuidad de destino")
    public void queElUsuarioSeleccioneLaOpciónDeBuscarSinColocarLaCuidadDeDestino() {
        USUARIO_BOOKING.attemptsTo(
                NavigateTo.theStaysTab());
        USUARIO_BOOKING.should(seeThat(IsEnabled.theTarget(SEARCH_FIELDS), equalTo(true)));

    }

    @Cuando("le da click a buscar")
    public void LeDaClickABuscar(){
        USUARIO_BOOKING.attemptsTo(Click.on(SEARCH_BOX_ACCOMMODATION));
    }

    @Entonces("vera el mensaje de {string}")
    public void veraElMensajeDe(String message) {
        USUARIO_BOOKING.should(seeThat(ObtainText.element(ALERT_MESSAGE_ERROR), containsString(message)));
    }

}
