package com.msla.prueba.tecnica.service.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void initialize() {

        // Insert data into regions
        if(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM regions", Integer.class) == 0) {
            jdbcTemplate.update("INSERT INTO regions (region_id, name) VALUES\n" +
                    "(1, 'North America'),\n" +
                    "(2, 'Europe'),\n" +
                    "(3, 'Asia'),\n" +
                    "(4, 'Australia'),\n" +
                    "(5, 'Sur America');");
        }


        // Insert data into countries
        if(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM countries", Integer.class) == 0) {
            jdbcTemplate.update("INSERT INTO countries (country_id, name, region_id) VALUES\n" +
                    "(1, 'United States', 1),\n" +
                    "(2, 'Canada', 1),\n" +
                    "(3, 'Mexico', 1),\n" +
                    "(4, 'United Kingdom', 2),\n" +
                    "(5, 'France', 2),\n" +
                    "(6, 'Germany', 2),\n" +
                    "(7, 'China', 3),\n" +
                    "(8, 'Japan', 3),\n" +
                    "(9, 'South Korea', 3),\n" +
                    "(10, 'Australia', 4),\n" +
                    "(11, 'Peru', 5),\n" +
                    "(12, 'Argentina', 5),\n" +
                    "(13, 'Colombia', 5);");
        }


        // Insert data into locations
        if(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM locations", Integer.class) == 0) {
            jdbcTemplate.update("INSERT INTO locations (location_id, city, postal_code, satate_province, street_address, country_id) VALUES\n" +
                    "(1, 'New York', '10001', 'New York', '123 Main St', 1),\n" +
                    "(2, 'Toronto', 'M5B 2K3', 'Ontario', '456 Queen St', 2),\n" +
                    "(3, 'Mexico City', '06000', 'CDMX', '789 Reforma Ave', 3),\n" +
                    "(4, 'London', 'SW1A 1AA', 'England', '101 Downing St', 4),\n" +
                    "(5, 'Paris', '75001', 'Ile-de-France', '202 Champs-Elysees', 5),\n" +
                    "(6, 'Berlin', '10115', 'Berlin', '303 Unter den Linden', 6),\n" +
                    "(7, 'Beijing', '100000', 'Beijing', '404 Tiananmen Sq', 7),\n" +
                    "(8, 'Tokyo', '100-0001', 'Tokyo', '505 Ginza', 8),\n" +
                    "(9, 'Seoul', '03033', 'Seoul', '606 Myeong-dong', 9),\n" +
                    "(10, 'Sydney', '2000', 'New South Wales', '707 George St', 10),\n" +
                    "(11, 'Lima', '15001', 'Lima', '808 Miraflores Ave', 11),\n" +
                    "(12, 'Buenos Aires', 'C1000', 'Buenos Aires', '909 Avenida 9 de Julio', 12),\n" +
                    "(13, 'Bogota', '110111', 'Bogota', '1010 Carrera 7', 13);");
        }


        // Insert data into departments
        if(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM departaments", Integer.class) == 0) {
            jdbcTemplate.update("INSERT INTO departaments (departament_id, manager_id, name, location_id) VALUES\n" +
                    "(1, 100, 'Executive', 1),\n" +
                    "(2, 101, 'Human Resources', 2),\n" +
                    "(3, 102, 'Finance', 3),\n" +
                    "(4, 103, 'Sales', 4),\n" +
                    "(5, 104, 'Marketing', 5),\n" +
                    "(6, 105, 'IT', 6),\n" +
                    "(7, 106, 'Customer Service', 7),\n" +
                    "(8, 107, 'Research and Development', 8),\n" +
                    "(9, 108, 'Operations', 9),\n" +
                    "(10, 109, 'Legal', 10),\n" +
                    "(11, 110, 'Public Relations', 11),\n" +
                    "(12, 111, 'Procurement', 12),\n" +
                    "(13, 112, 'Administration', 13);");
        }


        // Insert data into jobs
        if(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM jobs", Integer.class) == 0) {
            jdbcTemplate.update("INSERT INTO public.jobs (job_id, job_title, min_salary, max_salary) VALUES\n" +
                    "('J001', 'CEO', 200000, 300000),\n" +
                    "('J002', 'CFO', 150000, 250000),\n" +
                    "('J003', 'CTO', 150000, 250000),\n" +
                    "('J004', 'Marketing Director', 120000, 180000),\n" +
                    "('J005', 'Sales Director', 120000, 180000),\n" +
                    "('J006', 'IT Manager', 100000, 150000),\n" +
                    "('J007', 'HR Manager', 100000, 150000),\n" +
                    "('J008', 'Operations Manager', 100000, 150000),\n" +
                    "('J009', 'Finance Manager', 100000, 150000),\n" +
                    "('J010', 'Customer Service Manager', 80000, 120000),\n" +
                    "('J011', 'Software Developer', 60000, 120000),\n" +
                    "('J012', 'Front-End Developer', 60000, 120000),\n" +
                    "('J013', 'Back-End Developer', 60000, 120000),\n" +
                    "('J014', 'Database Administrator', 70000, 130000),\n" +
                    "('J015', 'Data Scientist', 70000, 130000),\n" +
                    "('J016', 'System Administrator', 60000, 120000),\n" +
                    "('J017', 'Network Engineer', 70000, 130000),\n" +
                    "('J018', 'Security Analyst', 70000, 130000);");
        }


        // Insert data into employees
        if(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM employees", Integer.class) == 0) {
            jdbcTemplate.update("INSERT INTO employees (first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id) VALUES\n" +
                    "('John', 'Doe', 'john.doe@example.com', '123-456-7890', '2022-01-01T00:00:00', 'J001', 250000, 10, 1),\n" +
                    "('Jane', 'Doe', 'jane.doe@example.com', '123-456-7891', '2022-01-02T00:00:00', 'J002', 200000, 10, 1),\n" +
                    "('Jim', 'Smith', 'jim.smith@example.com', '123-456-7892', '2022-01-03T00:00:00', 'J003', 200000, 10, 1),\n" +
                    "('Jill', 'Smith', 'jill.smith@example.com', '123-456-7893', '2022-01-04T00:00:00', 'J004', 150000, 10, 2),\n" +
                    "('Joe', 'Johnson', 'joe.johnson@example.com', '123-456-7894', '2022-01-05T00:00:00', 'J005', 150000, 10, 2),\n" +
                    "('Jenny', 'Johnson', 'jenny.johnson@example.com', '123-456-7895', '2022-01-06T00:00:00', 'J006', 125000, 10, 3),\n" +
                    "('Jack', 'Williams', 'jack.williams@example.com', '123-456-7896', '2022-01-07T00:00:00', 'J007', 125000, 10, 3),\n" +
                    "('Jessica', 'Williams', 'jessica.williams@example.com', '123-456-7897', '2022-01-08T00:00:00', 'J008', 100000, 10, 4),\n" +
                    "('Jeff', 'Brown', 'jeff.brown@example.com', '123-456-7898', '2022-01-09T00:00:00', 'J009', 100000, 10, 4),\n" +
                    "('Julie', 'Brown', 'julie.brown@example.com', '123-456-7899', '2022-01-10T00:00:00', 'J010', 90000, 10, 5),\n" +
                    "('Justin', 'Davis', 'justin.davis@example.com', '123-456-7800', '2022-01-11T00:00:00', 'J011', 90000, 10, 5),\n" +
                    "('Jasmine', 'Davis', 'jasmine.davis@example.com', '123-456-7801', '2022-01-12T00:00:00', 'J012', 80000, 10, 6),\n" +
                    "('Jacob', 'Miller', 'jacob.miller@example.com', '123-456-7802', '2022-01-13T00:00:00', 'J013', 80000, 10, 6),\n" +
                    "('Jade', 'Miller', 'jade.miller@example.com', '123-456-7803', '2022-01-14T00:00:00', 'J014', 85000, 10, 7),\n" +
                    "('Jeremy', 'Wilson', 'jeremy.wilson@example.com', '123-456-7804', '2022-01-15T00:00:00', 'J015', 85000, 10, 7),\n" +
                    "('Jenna', 'Wilson', 'jenna.wilson@example.com', '123-456-7805', '2022-01-16T00:00:00', 'J016', 80000, 10, 8),\n" +
                    "('Jason', 'Moore', 'jason.moore@example.com', '123-456-7806', '2022-01-17T00:00:00', 'J017', 85000, 10, 8),\n" +
                    "('Joy', 'Moore', 'joy.moore@example.com', '123-456-7807', '2022-01-18T00:00:00', 'J018', 85000, 10, 9),\n" +
                    "('Jerry', 'Taylor', 'jerry.taylor@example.com', '123-456-7808', '2022-01-19T00:00:00', 'J011', 80000, 10, 9),\n" +
                    "('June', 'Taylor', 'june.taylor@example.com', '123-456-7809', '2022-01-20T00:00:00', 'J012', 80000, 10, 10),\n" +
                    "('Alan', 'Walker', 'alan.walker@example.com', '123-456-7810', '2022-01-21T00:00:00', 'J013', 80000, 10, 11),\n" +
                    "('Alice', 'Walker', 'alice.walker@example.com', '123-456-7811', '2022-01-22T00:00:00', 'J014', 85000, 10, 11),\n" +
                    "('Andrew', 'Harris', 'andrew.harris@example.com', '123-456-7812', '2022-01-23T00:00:00', 'J015', 85000, 10, 11),\n" +
                    "('Anna', 'Harris', 'anna.harris@example.com', '123-456-7813', '2022-01-24T00:00:00', 'J016', 80000, 10, 11),\n" +
                    "('Arthur', 'Clark', 'arthur.clark@example.com', '123-456-7814', '2022-01-25T00:00:00', 'J017', 85000, 10, 11),\n" +
                    "('Ava', 'Clark', 'ava.clark@example.com', '123-456-7815', '2022-01-26T00:00:00', 'J018', 85000, 10, 11),\n" +
                    "('Adam', 'Rodriguez', 'adam.rodriguez@example.com', '123-456-7816', '2022-01-27T00:00:00', 'J011', 80000, 10, 11),\n" +
                    "('Amelia', 'Rodriguez', 'amelia.rodriguez@example.com', '123-456-7817', '2022-01-28T00:00:00', 'J012', 80000, 10, 11),\n" +
                    "('Aaron', 'Lewis', 'aaron.lewis@example.com', '123-456-7818', '2022-01-29T00:00:00', 'J013', 80000, 10, 11),\n" +
                    "('Aria', 'Lewis', 'aria.lewis@example.com', '123-456-7819', '2022-01-30T00:00:00', 'J014', 85000, 10, 11);");
        }

    }
}
