package co.com.booking.userinterface.info_booking;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InfoBookingPages {

    public static final Target LBL_PRICE_SUMMARY_TOTAL_VALUE = Target.the("label with the summary total price value")
            .located(By.xpath("//android.widget.TextView[@resource-id='com.booking:id/bp_price_summary_total_price_value']"));
    public static final Target LBL_INFO_CHECK_IN_DATE = Target.the("label with the check-in date select")
            .located(By.xpath("//android.widget.TextView[@resource-id='com.booking:id/checkin_date']"));
    public static final Target LBL_INFO_CHECK_OUT_DATE = Target.the("label with the check-out date select")
            .located(By.xpath("//android.widget.TextView[@resource-id='com.booking:id/checkout_date']"));
    public static final Target BTN_FINAL_STEP = Target.the("button final step")
            .located(By.xpath("//android.widget.Button[@resource-id='com.booking:id/action_button']"));

    private InfoBookingPages() {
        //Nothing
    }
}
