package co.com.booking.tasks.booking;

import co.com.booking.interactions.Pause;
import co.com.booking.questions.ObtainText;
import co.com.booking.tasks.common.scroll.ScrollById;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static co.com.booking.userinterface.accommodation_search.ViewBookingPage.*;
import static co.com.booking.userinterface.accommodation_search.SelectRoomPage.*;
import static co.com.booking.utils.data.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static org.hamcrest.Matchers.containsString;

public class SelectRooms implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(SelectRooms.class.getSimpleName());

    public SelectRooms() {
        //Task
    }

    public static SelectRooms chooseRoom() {
        return instrumented(SelectRooms.class);

    }

    @Override
    @Step("{0} select-reserve the room")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SELECCION_HOTEL, isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(SELECCION_HOTEL));


        String priceBooking = LBL_PRICE_ROOM.resolveFor(actor).getText();
        actor.remember(PRICE_BOOKING, priceBooking);
        LOGGER.info("Price booking is: {}", priceBooking);

        actor.attemptsTo(
                WaitUntil.the(BTN_SELECT_ROOMS, isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(BTN_SELECT_ROOMS));
        actor.attemptsTo(
                WaitUntil.the(LBL_INFO_PRICE_TOTAL, isEnabled()).forNoMoreThan(5).seconds());

        String reserve_price = LBL_INFO_PRICE_TOTAL.resolveFor(actor).getText();
        actor.remember(PRICE_TOTAL, priceBooking);
        LOGGER.info("Price booking total is: {}", reserve_price);
        actor.should(seeThat(ObtainText.element(LBL_INFO_PRICE_TOTAL), containsString(actor.recall(PRICE_BOOKING))));

        actor.attemptsTo(
                Click.on(BTN_RESERVE_THESE_OPTION),
                Pause.withDuration(2));
    }
}