package co.com.booking.userinterface.user_data;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UserDataPage {
    public static final Target INPUT_FIRST_NAME = Target.the("text box for first name")
            .located(By.xpath("//javaClass[@resource-id='com.booking:id/bstage1_contact_firstname_value']/android.widget.EditText"));
    public static final Target INPUT_LAST_NAME = Target.the("text box for last name")
            .located(By.xpath("//javaClass[@resource-id='com.booking:id/bstage1_contact_lastname_value']/android.widget.EditText"));
    public static final Target INPUT_EMAIL_ADDRESS = Target.the("text box for email address")
            .located(By.xpath("//javaClass[@resource-id='com.booking:id/bstage1_contact_email_value']/android.widget.EditText"));
    public static final Target INPUT_ADDRESS = Target.the("text box for address")
            .located(By.xpath("//javaClass[@resource-id='com.booking:id/bstage1_contact_address_value']/android.widget.EditText"));
    public static final Target INPUT_ZIP_CODE = Target.the("text box for zip code")
            .located(By.xpath("//javaClass[@resource-id='com.booking:id/bstage1_contact_zipcode_value']/android.widget.EditText"));
    public static final Target INPUT_CITY = Target.the("text box for city")
            .located(By.xpath("//javaClass[@resource-id='com.booking:id/bstage1_contact_city_value']/android.widget.EditText"));
    public static final Target INPUT_COUNTRY = Target.the("text box for country/region")
            .located(By.xpath("//javaClass[@resource-id='com.booking:id/bstage1_contact_country_value']/android.widget.EditText"));
    public static final Target INPUT_MOBILE_PHONE = Target.the("text box for mobile phone")
            .located(By.xpath("//javaClass[@resource-id='com.booking:id/bstage1_contact_telephone_value']/android.widget.EditText"));
    public static final Target RADIO_BTN_LEISURE = Target.the("radio button leisure")
            .located(By.xpath("//android.widget.RadioButton[@resource-id='com.booking:id/business_purpose_leisure']"));
    public static final Target LBL_PRICE = Target.the("label with the price total")
            .located(By.xpath("//android.widget.TextView[@resource-id='com.booking:id/title']"));
    public static final Target BTN_NEXT_STEP = Target.the("button next step")
            .located(By.xpath("//android.widget.Button[@resource-id='com.booking:id/action_button']"));
    public static final Target TXT_FIRST_NAME_REQUIRED = Target.the("txt name required")
            .located(AppiumBy.id("com.booking:id/bui_input_container_helper_label"));


    private UserDataPage() {
        //Nothing
    }
}
