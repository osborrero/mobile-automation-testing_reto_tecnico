package co.com.booking.models;

import java.util.HashMap;
import java.util.Map;

import static co.com.booking.utils.data.Constants.*;

public class UserInfoModel {

    private static final Map<String, String> infoUser = new HashMap<>();

    private UserInfoModel() {
    }

    public static Map<String, String> userInformation() {
        infoUser.put(CITY_DESTINATION, BookingInformation.OSWALDO.getCityDestination());
        infoUser.put(FIRST_NAME, BookingInformation.OSWALDO.getFirstName());
        infoUser.put(LAST_NAME, BookingInformation.OSWALDO.getLastName());
        infoUser.put(START_DATE, BookingInformation.OSWALDO.getDateStart());
        infoUser.put(END_DATE, BookingInformation.OSWALDO.getDateEnd());
        infoUser.put(AGE_CHILDREN, BookingInformation.OSWALDO.getAgeChildren());

        infoUser.put(EMAIL, UserInformation.OSWALDO.getEmail());
        infoUser.put(ADDRESS, UserInformation.OSWALDO.getAddress());
        infoUser.put(POSTAL_CODE, UserInformation.OSWALDO.getPostalCode());
        infoUser.put(CITY, UserInformation.OSWALDO.getCity());
        infoUser.put(COUNTRY, UserInformation.OSWALDO.getCountry());
        infoUser.put(PHONE, UserInformation.OSWALDO.getPhone());
        return infoUser;
    }
}
