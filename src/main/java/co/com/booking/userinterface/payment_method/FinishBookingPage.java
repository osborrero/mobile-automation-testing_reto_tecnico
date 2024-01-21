package co.com.booking.userinterface.payment_method;

import net.serenitybdd.screenplay.targets.Target;

public class FinishBookingPage {

    public static final Target INPUT_CREDIT_CARD = Target.the("input credit card number")
            .locatedBy("//android.widget.EditText[@resource-id='com.booking:id/new_credit_card_number_edit']");
    public static final Target INPUT_EXPIRATION_DATE = Target.the("input credit card number")
            .locatedBy("//android.widget.EditText[@resource-id='com.booking:id/new_credit_card_expiry_date_edit']");
    public static final Target BTN_BOOK_NOW = Target.the("button book now")
            .locatedBy("//android.widget.Button[@resource-id='com.booking:id/action_button']");

    private FinishBookingPage() {
        //Nothing
    }
}

