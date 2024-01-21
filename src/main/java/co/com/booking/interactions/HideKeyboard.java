package co.com.booking.interactions;

import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class HideKeyboard implements Interaction, IsHidden {
    public HideKeyboard() {
        // Nothing
    }

    public static HideKeyboard theActorHidesKeyboard() {
        return Tasks.instrumented(HideKeyboard.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        AndroidDriver driver = (AndroidDriver) BrowseTheWeb.as(actor).getDriver();
        driver.hideKeyboard();
    }
}