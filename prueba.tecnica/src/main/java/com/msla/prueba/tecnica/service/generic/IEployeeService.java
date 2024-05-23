package com.msla.prueba.tecnica.service.generic;

import com.msla.prueba.tecnica.entity.EmployeesBO;

import java.time.LocalDateTime;
import java.util.List;

public interface IEployeeService {

    List<EmployeesBO> getEmployeesByCountryAndSalaryRange(String country, Double minSalary, Double maxSalary) throws Exception;

    List<EmployeesBO>  getEmployeesByCountryAndHireDateRange(String country, LocalDateTime startDate, LocalDateTime endDate) throws Exception;

}
