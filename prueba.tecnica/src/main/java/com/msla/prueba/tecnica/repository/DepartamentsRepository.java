package com.msla.prueba.tecnica.repository;

import com.msla.prueba.tecnica.entity.DepartamentsBO;
import com.msla.prueba.tecnica.entity.LocationsBO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartamentsRepository extends JpaRepository<DepartamentsBO, Long> {

    List<DepartamentsBO> findByLocationIdIn(List<LocationsBO> locationId);
}
