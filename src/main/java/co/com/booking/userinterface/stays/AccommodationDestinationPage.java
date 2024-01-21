package co.com.booking.userinterface.stays;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class AccommodationDestinationPage {

    public static final Target INPUT_SEARCH_BOX_ACCOMMODATION_DESTINATION = Target.the("input search box for the accommodation destination")
            .located(AppiumBy.id("com.booking:id/facet_with_bui_free_search_booking_header_toolbar_content"));
    public static final Target SELECT_ACCOMMODATION_DESTINATION = Target.the("city of available accommodation")
            .locatedBy("//android.widget.TextView[1][@resource-id='com.booking:id/view_disambiguation_destination_title']");

    private AccommodationDestinationPage() {
        //Nothing
    }
}
