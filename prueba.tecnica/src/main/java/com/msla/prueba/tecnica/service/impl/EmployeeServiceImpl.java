package com.msla.prueba.tecnica.service.impl;

import com.msla.prueba.tecnica.entity.CountriesBO;
import com.msla.prueba.tecnica.entity.DepartamentsBO;
import com.msla.prueba.tecnica.entity.EmployeesBO;
import com.msla.prueba.tecnica.entity.LocationsBO;
import com.msla.prueba.tecnica.repository.CountriesRepository;
import com.msla.prueba.tecnica.repository.DepartamentsRepository;
import com.msla.prueba.tecnica.repository.EmployeeRepository;
import com.msla.prueba.tecnica.repository.LocationsRepository;
import com.msla.prueba.tecnica.service.generic.IEployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl  implements IEployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CountriesRepository countriesRepository;

    @Autowired
    private DepartamentsRepository departamentsRepository;

    @Autowired
    private LocationsRepository locationsRepository;

    @Override
    public List<EmployeesBO>  getEmployeesByCountryAndSalaryRange(String country, Double minSalary, Double maxSalary) throws Exception {

        List<EmployeesBO> employees = new ArrayList<>();
        try {

            CountriesBO coutrie = countriesRepository.findByCountryName(country);

            List<LocationsBO> locations = locationsRepository.findByCountries(coutrie);

            List<DepartamentsBO> departaments = departamentsRepository.findByLocationIdIn(locations);


            List<LocationsBO> locationsBOS = departaments.stream()
                    .map(DepartamentsBO::getLocationId)
                    .collect(Collectors.toList());

            List<Long> managerIds = locationsBOS.stream()
                    .map(LocationsBO::getLocationId)
                    .collect(Collectors.toList());


            employees = employeeRepository.findByManagerIdInAndSalaryBetween(managerIds, minSalary, maxSalary);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return employees;
    }

    @Override
    public List<EmployeesBO>  getEmployeesByCountryAndHireDateRange(String country, LocalDateTime startDate, LocalDateTime endDate) throws Exception {

        List<EmployeesBO> employees = new ArrayList<>();
        try {

            CountriesBO coutrie = countriesRepository.findByCountryName(country);

            List<LocationsBO> locations = locationsRepository.findByCountries(coutrie);

            List<DepartamentsBO> departaments = departamentsRepository.findByLocationIdIn(locations);


            List<LocationsBO> locationsBOS = departaments.stream()
                    .map(DepartamentsBO::getLocationId)
                    .collect(Collectors.toList());

            List<Long> managerIds = locationsBOS.stream()
                    .map(LocationsBO::getLocationId)
                    .collect(Collectors.toList());


            employees = employeeRepository.findByManagerIdInAndHireDateBetween(managerIds, startDate, endDate);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return employees;
    }
}
