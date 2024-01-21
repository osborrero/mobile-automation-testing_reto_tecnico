package co.com.booking.models;


public enum UserInformation {
    OSWALDO("osborrero@test.com", "Calle 131a #51-31", "111999", "Bogota", "Colombia", "3105947896");

    private final String email;
    private final String address;
    private final String postalCode;
    private final String city;
    private final String country;
    private final String phone;


    UserInformation(String email, String address, String postalCode, String city, String country, String phone) {
        this.email = email;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }
}
