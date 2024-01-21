package co.com.booking.userinterface.accommodation_search;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ViewBookingPage {
    public static final Target RESULT_BOOKING = Target.the("result booking: list of available hotels")
            .located(AppiumBy.id("com.booking:id/results_list_facet"));

    public static final Target SELECCION_HOTEL = Target.the("selection items two of list")
            .located(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]"));

    private ViewBookingPage() {
    }
}
