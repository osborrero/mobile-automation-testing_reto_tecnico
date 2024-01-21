package co.com.booking.tasks.booking;

import co.com.booking.interactions.Pause;
import co.com.booking.questions.ObtainText;
import co.com.booking.tasks.common.scroll.Scroll;
import co.com.booking.utils.data.BookingData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
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

public class ValidateValuesRequired implements Task {


    public ValidateValuesRequired() {
        //Nothing
    }

    public static ValidateValuesRequired noRecords() {
        return instrumented(ValidateValuesRequired.class);
    }

    @Override
    @Step("{0} No logger data")
    public <T extends Actor> void performAs(T actor) {
//        actor.attemptsTo(
//                WaitUntil.the(INPUT_FIRST_NAME, isEnabled()).forNoMoreThan(5).seconds(),
//                Click.on(INPUT_FIRST_NAME));
        actor.attemptsTo(Click.on(BTN_NEXT_STEP), Pause.withDuration(5));
    }

}
