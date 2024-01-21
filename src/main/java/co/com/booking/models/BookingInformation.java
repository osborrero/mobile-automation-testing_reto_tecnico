package co.com.booking.models;


public enum BookingInformation {
    OSWALDO("Oswaldo", "Borrero", "Cusco", "14 febrero 2024", "28 febrero 2024", "5 años");

    private final String firstName;
    private final String lastName;
    private final String cityDestination;
    private final String dateStart;
    private final String dateEnd;
    private final String ageChildren;


    BookingInformation(String firstName, String lastName, String cityDestination, String dateStart, String dateEnd, String ageChildren) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cityDestination = cityDestination;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.ageChildren = ageChildren;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCityDestination() {
        return cityDestination;
    }

    public String getDateStart() {
        return dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public String getAgeChildren() {
        return ageChildren;
    }
}
