package com.msla.prueba.tecnica.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "locations")
public class LocationsBO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "location_id")
    private Long locationId;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "city")
    private String city;

    @Column(name = "satate_province")
    private String stateProvince;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountriesBO countries;

    public LocationsBO() {
    }

    public LocationsBO(Long locationId, String streetAddress, String postalCode, String city, String stateProvince, CountriesBO countries) {
        this.locationId = locationId;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.stateProvince = stateProvince;
        this.countries = countries;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public CountriesBO getCountries() {
        return countries;
    }

    public void setCountries(CountriesBO countries) {
        this.countries = countries;
    }

    @Override
    public String toString() {
        return "LocationsBO{" +
                "locationId=" + locationId +
                ", streetAddress='" + streetAddress + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                ", countries=" + countries +
                '}';
    }
}
