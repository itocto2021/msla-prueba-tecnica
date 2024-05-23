package com.msla.prueba.tecnica.repository;

import com.msla.prueba.tecnica.entity.EmployeesBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeesBO, Long> {

    List<EmployeesBO> findByManagerIdInAndSalaryBetween(List<Long> employees, Double minSalary, Double maxSalary);
    List<EmployeesBO>  findByManagerIdInAndHireDateBetween(List<Long> employees, LocalDateTime startDate, LocalDateTime endDate);
}
