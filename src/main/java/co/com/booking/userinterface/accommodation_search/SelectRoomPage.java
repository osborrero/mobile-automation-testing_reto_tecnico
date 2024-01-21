package co.com.booking.userinterface.accommodation_search;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class SelectRoomPage {
    public static final Target LBL_PRICE_ROOM = Target.the("price of the room")
            .located(AppiumBy.id("com.booking:id/price_view_price"));

    public static final Target BTN_SELECT_ROOMS = Target.the("button select rooms")
            .located(AppiumBy.id("com.booking:id/select_room_cta"));

    public static final Target BTN_RESERVE_THESE_OPTION = Target.the("button reserve this option")
            .located(AppiumBy.id("com.booking:id/recommended_block_reserve_button"));

    public static final Target LBL_INFO_PRICE_TOTAL = Target.the("price total information")
            .located(AppiumBy.id("com.booking:id/recommended_block_subtotal_price_view"));

    private SelectRoomPage() {
        //Nothing
    }
}
