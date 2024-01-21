package co.com.booking.tasks.booking;

import co.com.booking.interactions.Pause;
import co.com.booking.questions.ObtainText;
import co.com.booking.tasks.common.scroll.Scroll;
import co.com.booking.utils.data.BookingData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.booking.interactions.HideKeyboard.theActorHidesKeyboard;
import static co.com.booking.userinterface.user_data.UserDataPage.*;
import static co.com.booking.utils.data.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static org.hamcrest.Matchers.containsString;

public class FillInUserInformation implements Task {


    public FillInUserInformation() {
        //Nothing
    }

    public static FillInUserInformation withTheFollowingFields() {
        return instrumented(FillInUserInformation.class);
    }

    @Override
    @Step("{0} fill in your info")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(INPUT_FIRST_NAME, isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(INPUT_FIRST_NAME),
                Enter.theValue(BookingData.getData().get(FIRST_NAME).toString()).into(INPUT_FIRST_NAME),

                Click.on(INPUT_LAST_NAME),
                Enter.theValue(BookingData.getData().get(LAST_NAME).toString()).into(INPUT_LAST_NAME),

                Click.on(INPUT_EMAIL_ADDRESS),
                Enter.theValue(BookingData.getData().get(EMAIL).toString()).into(INPUT_EMAIL_ADDRESS),
                theActorHidesKeyboard(),

                Click.on(INPUT_ADDRESS),
                Enter.theValue(BookingData.getData().get(ADDRESS).toString()).into(INPUT_ADDRESS),
                theActorHidesKeyboard(),

                Scroll.toElement(),
                Pause.withDuration(1),

                Click.on(INPUT_ZIP_CODE),
                Enter.theValue(BookingData.getData().get(POSTAL_CODE).toString()).into(INPUT_ZIP_CODE),
                theActorHidesKeyboard(),

                Click.on(INPUT_CITY),
                Enter.theValue(BookingData.getData().get(CITY).toString()).into(INPUT_CITY),
                theActorHidesKeyboard(),

                Click.on(INPUT_COUNTRY),
                Clear.field(INPUT_COUNTRY),
                Enter.theValue(BookingData.getData().get(COUNTRY).toString()).into(INPUT_COUNTRY),
                theActorHidesKeyboard(),

                Click.on(INPUT_MOBILE_PHONE),
                Clear.field(INPUT_MOBILE_PHONE),
                Enter.theValue(BookingData.getData().get(PHONE).toString()).into(INPUT_MOBILE_PHONE),
                theActorHidesKeyboard(),

                Scroll.toElement(),
                Click.on(RADIO_BTN_LEISURE)
        );

        actor.should(seeThat(ObtainText.element(LBL_PRICE), containsString(actor.recall(PRICE_BOOKING))));

        actor.attemptsTo(Click.on(BTN_NEXT_STEP), Pause.withDuration(5), Scroll.toElement());
    }
}