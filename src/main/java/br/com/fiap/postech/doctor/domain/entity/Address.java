package br.com.fiap.postech.doctor.domain.entity;

public class Address {
    private String street;

    private String city;

    private String state;

    private String zipCode;

    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void updateInformation(Address address) {
        if (!address.getStreet().isEmpty()) {
            this.street = address.getStreet();
        }
        if (!address.getCity().isEmpty()) {
            this.city = address.getCity();
        }
        if (!address.getState().isEmpty()) {
            this.state = address.getState();
        }
        if (!address.getZipCode().isEmpty()) {
            this.zipCode = address.getZipCode();
        }
    }
}
