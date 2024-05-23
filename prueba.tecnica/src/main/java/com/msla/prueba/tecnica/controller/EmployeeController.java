package com.msla.prueba.tecnica.controller;

import com.msla.prueba.tecnica.entity.EmployeesBO;
import com.msla.prueba.tecnica.service.generic.IEployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEployeeService employeeService;
    @GetMapping("/search")
    public List<EmployeesBO> searchEmployees(
            @RequestParam String country,
            @RequestParam(required = false) Double minSalary,
            @RequestParam(required = false) Double maxSalary,
            @RequestParam(value = "startDate", required = false)  String startDate,
            @RequestParam(value = "endDate", required = false)  String endDate)  throws Exception {
        if (minSalary != null && maxSalary != null) {
            // Consulta por país y rango de salario

            return employeeService.getEmployeesByCountryAndSalaryRange(country, minSalary, maxSalary);

        } else if (startDate != null && endDate != null) {
            // Consulta por país y rango de fecha de contratación
            return employeeService.getEmployeesByCountryAndHireDateRange(country, convertToLocalDateTime(startDate), convertToLocalDateTime(endDate));
        } else {
            // Si no se proporcionan parámetros válidos, retornar una lista vacía o un mensaje de error
            return List.of(); // Lista vacía
            // También puedes lanzar una excepción indicando que los parámetros son inválidos o faltan
        }
    }

    public static LocalDateTime convertToLocalDateTime(String dateToConvert) {
        LocalDate date = LocalDate.parse(dateToConvert);
        LocalDateTime dateTime = date.atStartOfDay();

        return dateTime;
    }
}
