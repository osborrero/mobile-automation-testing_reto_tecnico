package co.com.booking.steps.booking;

import co.com.booking.interactions.Pause;
import co.com.booking.questions.IsEnabled;
import co.com.booking.tasks.booking.*;
import co.com.booking.tasks.common.LoadDataTask;
import co.com.booking.tasks.common.NavigateTo;
import co.com.booking.tasks.common.scroll.Scroll;
import co.com.booking.utils.data.BookingData;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actions.Click;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.com.booking.models.UserInfoModel.userInformation;
import static co.com.booking.steps.conf.Hooks.USUARIO_BOOKING;
import static co.com.booking.userinterface.accommodation_search.ViewBookingPage.RESULT_BOOKING;
import static co.com.booking.userinterface.info_booking.InfoBookingPages.BTN_FINAL_STEP;
import static co.com.booking.userinterface.payment_method.FinishBookingPage.BTN_BOOK_NOW;
import static co.com.booking.userinterface.stays.HomePage.SEARCH_FIELDS;
import static co.com.booking.userinterface.user_data.UserDataPage.INPUT_FIRST_NAME;
import static co.com.booking.utils.data.Constants.*;
import static co.com.booking.utils.data.Constants.AGE_CHILDREN;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class ReservarAlojamientoSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReservarAlojamientoSteps.class.getSimpleName());

    @Dado("que el usuario ingresa a la app de booking registrando los datos de alojamiento {string}, {string}, {string} y {string}")
    public void que_el_usuario_ingresa_a_la_app_de_booking_registrando_los_datos_de_alojamiento (String city, String dateStart, String dateEnd, String ageChildren) {
            USUARIO_BOOKING.attemptsTo(
                    NavigateTo.theStaysTab());
            USUARIO_BOOKING.wasAbleTo(LoadDataTask.informationBooking(userInformation()));
            LOGGER.info("Data User is: {}", userInformation().values());
            USUARIO_BOOKING.attemptsTo(SelectAccommodationDestination.withCustomerData(
                    BookingData.getData().get(CITY_DESTINATION).toString(),
                    BookingData.getData().get(START_DATE).toString(),
                    BookingData.getData().get(END_DATE).toString(),
                    BookingData.getData().get(AGE_CHILDREN).toString()));
            USUARIO_BOOKING.should(seeThat(IsEnabled.theTarget(RESULT_BOOKING), equalTo(true)));
        }


    @Y("selecciona el segundo ítem del resultado de alojamiento para elegir la habitación a reservar")
    public void selecciona_el_segundo_ítem_del_resultado_de_alojamiento_para_elegir_la_habitación_a_reservar() {
            USUARIO_BOOKING.attemptsTo(SelectRooms.chooseRoom());
    }
    @Cuando("completa los datos de la persona que realizará la reserva confirma los datos del costo {string}, fecha de inicio {string} y fecha fin {string}")
    public void completa_los_datos_de_la_persona_que_realizará_la_reserva(String price, String checkIn, String checkOut) {
        USUARIO_BOOKING.should(seeThat(IsEnabled.theTarget(INPUT_FIRST_NAME), equalTo(true)));
        USUARIO_BOOKING.attemptsTo(FillInUserInformation.withTheFollowingFields());
        USUARIO_BOOKING.attemptsTo(ValidateBookingInformation.inTheResume(), Click.on(BTN_FINAL_STEP), Pause.withDuration(5));
    }
    @Y("elegi la forma de pago tarjeta de crédito registrando su numero con la fecha de expedición {string}, {string}")
    public void elegi_la_forma_de_pago_tarjeta_de_crédito_registrando_su_numero_con_la_fecha_de_expedición(String cardNumber, String expirationDate) {
        USUARIO_BOOKING.attemptsTo(ChoosePaymentMethod.withTheFollowingFields(cardNumber, expirationDate));
    }
    @Entonces("valida que el valor de la reserva es el correcto")
    public void valida_que_el_valor_de_la_reserva_es_el_correcto() {
        USUARIO_BOOKING.attemptsTo(Click.on(BTN_BOOK_NOW), Pause.withDuration(20));
    }

}
