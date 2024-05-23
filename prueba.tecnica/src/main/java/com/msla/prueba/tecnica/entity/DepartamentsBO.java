package com.msla.prueba.tecnica.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "departaments")
public class DepartamentsBO {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "departament_id")
        private Long departamentId;

        @Column(name = "name")
        private String name;

        private Long managerId;

        @ManyToOne
        @JoinColumn(name = "location_id")
        private LocationsBO locationId;


        @OneToMany(mappedBy = "departments")
        private List<EmployeesBO> empleados;

        public DepartamentsBO() {
        }

    public DepartamentsBO(Long departamentId, String name, Long managerId, LocationsBO locationId, List<EmployeesBO> empleados) {
        this.departamentId = departamentId;
        this.name = name;
        this.managerId = managerId;
        this.locationId = locationId;
        this.empleados = empleados;
    }

    public Long getDepartamentId() {
        return departamentId;
    }

    public void setDepartamentId(Long departamentId) {
        this.departamentId = departamentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public LocationsBO getLocationId() {
        return locationId;
    }

    public void setLocationId(LocationsBO locationId) {
        this.locationId = locationId;
    }

    public List<EmployeesBO> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<EmployeesBO> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return "DepartamentsBO{" +
                "departamentId=" + departamentId +
                ", name='" + name + '\'' +
                ", managerId='" + managerId + '\'' +
                ", locationId=" + locationId +
                ", empleados=" + empleados +
                '}';
    }
}
