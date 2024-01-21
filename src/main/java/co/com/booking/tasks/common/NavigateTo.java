package co.com.booking.tasks.common;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.booking.userinterface.SingInPage.BTN_CLOSE_WINDOW;
import static co.com.booking.userinterface.stays.HomePage.SEARCH_FIELDS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class NavigateTo {
    private NavigateTo() {
        //Nothing
    }

    public static Performable theStaysTab() {
        return Task.where("{0} opens the Booking app",
                Click.on(BTN_CLOSE_WINDOW),
                WaitUntil.the(SEARCH_FIELDS, isEnabled()).forNoMoreThan(5).seconds());
    }

}
