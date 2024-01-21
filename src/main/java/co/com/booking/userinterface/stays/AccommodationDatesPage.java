package co.com.booking.userinterface.stays;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class AccommodationDatesPage {
    public static final Target CALENDAR_MONTH_LIST = Target.the("calendar month list")
            .located(AppiumBy.id("com.booking:id/calendar_month_list"));
    public static final Target SELECT_START_DATE = Target.the("start date of stay")
            .locatedBy("//android.view.View[@content-desc='{0}']");
    public static final Target SELECT_END_DATE = Target.the("end date of stay ")
            .locatedBy("//android.view.View[@content-desc='{0}']");
    public static final Target BTN_CONFIRM_DATES = Target.the("button confirm dates of stays")
            .located(AppiumBy.id("com.booking:id/facet_date_picker_confirm"));

    private AccommodationDatesPage() {
        //Nothing
    }
}
