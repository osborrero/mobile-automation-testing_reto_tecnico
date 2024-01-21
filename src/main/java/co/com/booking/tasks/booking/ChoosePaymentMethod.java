package co.com.booking.tasks.booking;

import co.com.booking.exceptions.NotFoundText;
import co.com.booking.interactions.Pause;
import co.com.booking.questions.ObtainText;
import co.com.booking.tasks.common.scroll.Scroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static co.com.booking.userinterface.info_booking.InfoBookingPages.*;
import static co.com.booking.userinterface.payment_method.FinishBookingPage.INPUT_CREDIT_CARD;
import static co.com.booking.userinterface.payment_method.FinishBookingPage.INPUT_EXPIRATION_DATE;
import static co.com.booking.utils.data.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.Matchers.containsString;

public class ChoosePaymentMethod implements Task {
    private final String cardNumber;
    private final String expirationDate;

    public ChoosePaymentMethod(String cardNumber, String expirationDate) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }

    public static ChoosePaymentMethod withTheFollowingFields(String cardNumber, String expirationDate) {
        return instrumented(ChoosePaymentMethod.class, cardNumber, expirationDate);
    }


    @Override
    @Step("{0} chooses a credit card as payment method")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(INPUT_CREDIT_CARD),
                Enter.theValue(cardNumber).into(INPUT_CREDIT_CARD),
                Click.on(INPUT_EXPIRATION_DATE),
                Enter.theValue(expirationDate).into(INPUT_EXPIRATION_DATE),
                Scroll.toElement()
        );

        actor.attemptsTo(Scroll.toElement(), Pause.withDuration(1));
        actor.should(seeThat(ObtainText.element(LBL_INFO_CHECK_IN_DATE), containsString(actor.recall(CHECK_IN_BOOKING))).orComplainWith(NotFoundText.class, NotFoundText.THE_VALUE_IS_NOT_EXPECT));
        actor.should(seeThat(ObtainText.element(LBL_INFO_CHECK_OUT_DATE), containsString(actor.recall(CHECK_OUT_BOOKING))).orComplainWith(NotFoundText.class, NotFoundText.THE_VALUE_IS_NOT_EXPECT));

        actor.attemptsTo(Scroll.toElement(), Pause.withDuration(1));
        actor.should(seeThat(ObtainText.element(LBL_PRICE_SUMMARY_TOTAL_VALUE), containsString(actor.recall(PRICE_BOOKING))).orComplainWith(NotFoundText.class, NotFoundText.THE_VALUE_IS_NOT_EXPECT));
    }
}
