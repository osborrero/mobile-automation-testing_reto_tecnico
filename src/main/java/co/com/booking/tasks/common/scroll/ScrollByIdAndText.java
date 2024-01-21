package co.com.booking.tasks.common.scroll;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ScrollByIdAndText implements Task, IsHidden {
    private final String resourceId;
    private final String text;


    public ScrollByIdAndText(String resourceId, String text) {
        this.resourceId = resourceId;
        this.text = text;
    }

    public static ScrollByIdAndText toFindTheParameters(String resourceId, String text) {
        return instrumented(ScrollByIdAndText.class, resourceId, text);
    }

    @Override
    @Step("Searching for the #text parameter in the list")
    public <T extends Actor> void performAs(T actor) {
        try {
            WebDriver driver = BrowseTheWeb.as(actor).getDriver();

            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()" +
                            ".scrollIntoView(new UiSelector().resourceId(\"" + resourceId + "\").textContains(\"" + text + "\"));"));
        } catch (InvalidSelectorException e) {
            // ignore
        }

    }
}
