package com.msla.prueba.tecnica.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "countries")
public class CountriesBO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "country_id")
    private int countryId;

    @Column(name = "name")
    private String countryName;


    @ManyToOne()
    @JoinColumn(name = "region_id")
    private RegionsBO regions;

    public CountriesBO() {
    }

    public CountriesBO(int countryId, String countryName, RegionsBO regions) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.regions = regions;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public RegionsBO getRegions() {
        return regions;
    }

    public void setRegions(RegionsBO regions) {
        this.regions = regions;
    }

    @Override
    public String toString() {
        return "CountriesBO{" +
                "countryId=" + countryId +
                ", countryName='" + countryName + '\'' +
                ", regions=" + regions +
                '}';
    }
}
