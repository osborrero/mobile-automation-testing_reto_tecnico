package co.com.booking.tasks.booking;

import co.com.booking.exceptions.NotFoundText;
import co.com.booking.interactions.Pause;
import co.com.booking.questions.ObtainText;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.com.booking.userinterface.info_booking.InfoBookingPages.*;
import static co.com.booking.utils.data.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.Matchers.containsString;

public class ValidateBookingInformation implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateBookingInformation.class.getSimpleName());

    public ValidateBookingInformation() {
        //Task
    }

    public static ValidateBookingInformation inTheResume() {
        return instrumented(ValidateBookingInformation.class);

    }

    @Override
    @Step("{0} validates your reservation information")
    public <T extends Actor> void performAs(T actor) {
        String infoCheckInDate = LBL_INFO_CHECK_IN_DATE.resolveFor(actor).getText();
        actor.remember(CHECK_IN_BOOKING, infoCheckInDate);
        LOGGER.info("The check-in date is: {}", infoCheckInDate);

        String infoCheckOutDate = LBL_INFO_CHECK_OUT_DATE.resolveFor(actor).getText();
        actor.remember(CHECK_OUT_BOOKING, infoCheckOutDate);
        LOGGER.info("The check-out date is: {}", infoCheckOutDate);

        actor.should(seeThat(ObtainText.element(LBL_PRICE_SUMMARY_TOTAL_VALUE), containsString(actor.recall(PRICE_BOOKING))).orComplainWith(NotFoundText.class, NotFoundText.THE_VALUE_IS_NOT_EXPECT));
        actor.should(seeThat(ObtainText.element(LBL_INFO_CHECK_IN_DATE), containsString(infoCheckInDate)).orComplainWith(NotFoundText.class, NotFoundText.THE_VALUE_IS_NOT_EXPECT));
        actor.should(seeThat(ObtainText.element(LBL_INFO_CHECK_OUT_DATE), containsString(infoCheckOutDate)).orComplainWith(NotFoundText.class, NotFoundText.THE_VALUE_IS_NOT_EXPECT));

        actor.attemptsTo(Click.on(BTN_FINAL_STEP), Pause.withDuration(2));
    }
}