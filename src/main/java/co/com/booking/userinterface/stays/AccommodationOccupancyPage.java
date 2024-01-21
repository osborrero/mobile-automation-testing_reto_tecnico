package co.com.booking.userinterface.stays;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class AccommodationOccupancyPage {
    public static final Target BTN_SELECT_CHILDREN_OPTION = Target.the("button select option children")
            .locatedBy("//android.view.ViewGroup[@resource-id='com.booking:id/group_config_children_count']/android.widget.LinearLayout/android.widget.Button[2]");
    public static final Target BTN_OK = Target.the("button OK")
            .located(AppiumBy.id("android:id/button1"));
    public static final Target BTN_CONFIRM_SELECT_ROOMS_AND_GUESTS = Target.the("button confirm select rooms and guests")
            .located(AppiumBy.id("com.booking:id/group_config_apply_button"));
    public static final Target BTN_SEARCH = Target.the("Botton search")
            .located(AppiumBy.id("com.booking:id/facet_search_box_legacy_theme_cta_border_bottom"));

    private AccommodationOccupancyPage() {
        //Nothing
    }
}
