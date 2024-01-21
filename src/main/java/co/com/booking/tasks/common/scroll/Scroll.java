package co.com.booking.tasks.common.scroll;

import co.com.booking.exceptions.NotFoundUserAbility;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.InvalidSelectorException;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@SuppressWarnings({"deprecation"})
public class Scroll implements Task, IsHidden {

    public Scroll() {
        // Nothing
    }

    public static Scroll toElement() {
        return instrumented(Scroll.class);
    }

    @Override
    @Step("{0} scrolls the screen")
    public <T extends Actor> void performAs(T actor) {
        try {
            AndroidDriver driver = (AndroidDriver) BrowseTheWeb.as(actor).getDriver();
            new AndroidTouchAction(driver)
                    .press(PointOption.point(600, 600))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                    .moveTo(PointOption.point(600, -100))
                    .release()
                    .perform();

        } catch (InvalidSelectorException e) {
            throw new NotFoundUserAbility();
        }
    }
}
