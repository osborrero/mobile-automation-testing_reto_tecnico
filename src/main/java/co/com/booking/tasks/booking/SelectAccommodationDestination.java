package co.com.booking.tasks.booking;

import co.com.booking.interactions.Pause;
import co.com.booking.tasks.common.scroll.Scroll;
import co.com.booking.tasks.common.scroll.ScrollByIdAndText;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.booking.interactions.HideKeyboard.theActorHidesKeyboard;
import static co.com.booking.userinterface.stays.AccommodationDatesPage.*;
import static co.com.booking.userinterface.stays.AccommodationDestinationPage.INPUT_SEARCH_BOX_ACCOMMODATION_DESTINATION;
import static co.com.booking.userinterface.stays.AccommodationDestinationPage.SELECT_ACCOMMODATION_DESTINATION;
import static co.com.booking.userinterface.stays.AccommodationOccupancyPage.*;
import static co.com.booking.userinterface.stays.HomePage.SEARCH_BOX_ACCOMMODATION_DESTINATION;
import static co.com.booking.userinterface.stays.HomePage.SEARCH_BOX_ACCOMODATION_OCCUPANCY;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;


public class SelectAccommodationDestination implements Task {

    private final String cityDestination;
    private final String startDate;
    private final String endDate;
    private final String ageChildren;

    public SelectAccommodationDestination(String cityDestination, String startDate, String endDate, String ageChildren) {
        this.cityDestination = cityDestination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ageChildren = ageChildren;
    }

    public static SelectAccommodationDestination withCustomerData(String cityDestination, String startDate, String endDate, String ageChildren) {
        return instrumented(SelectAccommodationDestination.class, cityDestination, startDate, endDate, ageChildren);
    }

    @Override
    @Step("{0} enters-select search information")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SEARCH_BOX_ACCOMMODATION_DESTINATION, isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(SEARCH_BOX_ACCOMMODATION_DESTINATION),

                WaitUntil.the(INPUT_SEARCH_BOX_ACCOMMODATION_DESTINATION, isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(INPUT_SEARCH_BOX_ACCOMMODATION_DESTINATION),
                SendKeys.of(cityDestination).into(INPUT_SEARCH_BOX_ACCOMMODATION_DESTINATION),
                Pause.withDuration(1),
                theActorHidesKeyboard(),

                WaitUntil.the(SELECT_ACCOMMODATION_DESTINATION, isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(SELECT_ACCOMMODATION_DESTINATION)
        );

        actor.attemptsTo(
                Click.on(CALENDAR_MONTH_LIST),
                Scroll.toElement(),
                Click.on(SELECT_START_DATE.of(startDate)),
                Click.on(SELECT_END_DATE.of(endDate)),

                Pause.withDuration(2),
                Click.on(BTN_CONFIRM_DATES)
        );

        actor.attemptsTo(
                WaitUntil.the(SEARCH_BOX_ACCOMODATION_OCCUPANCY, isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(SEARCH_BOX_ACCOMODATION_OCCUPANCY),

                WaitUntil.the(BTN_SELECT_CHILDREN_OPTION, isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(BTN_SELECT_CHILDREN_OPTION),

                ScrollByIdAndText.toFindTheParameters("android:id/numberpicker_input", ageChildren),
                Click.on(BTN_OK),

                WaitUntil.the(BTN_CONFIRM_SELECT_ROOMS_AND_GUESTS, isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(BTN_CONFIRM_SELECT_ROOMS_AND_GUESTS),

                Click.on(BTN_SEARCH),
                Pause.withDuration(2)
        );
    }
}