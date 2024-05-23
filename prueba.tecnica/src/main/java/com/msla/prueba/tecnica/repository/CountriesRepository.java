package com.msla.prueba.tecnica.repository;

import com.msla.prueba.tecnica.entity.CountriesBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountriesRepository extends JpaRepository<CountriesBO, Long> {

    CountriesBO findByCountryName(String country);
}
