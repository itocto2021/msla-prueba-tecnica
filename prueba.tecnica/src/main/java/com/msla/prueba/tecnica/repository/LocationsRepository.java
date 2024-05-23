package com.msla.prueba.tecnica.repository;

import com.msla.prueba.tecnica.entity.CountriesBO;
import com.msla.prueba.tecnica.entity.LocationsBO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationsRepository extends JpaRepository<LocationsBO, Long> {

    List<LocationsBO> findByCountries(CountriesBO country);
}
