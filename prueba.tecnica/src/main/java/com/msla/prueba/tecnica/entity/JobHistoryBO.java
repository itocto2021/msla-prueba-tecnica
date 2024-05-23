package com.msla.prueba.tecnica.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class JobHistoryBO {

        @Id
        @ManyToOne()
        @JoinColumn(name = "employee_id")
        private Long employeeId;

        @Id
        @Column(name = "start_date")
        private String startDate;

        @Column(name = "end_date")
        private String endDate;

        @ManyToOne
        @JoinColumn(name = "job_id")
        private JobsBO jobId;

        @ManyToOne
        @JoinColumn(name = "departament_id")
        private DepartamentsBO departamentId;

        public JobHistoryBO() {
        }

    public JobHistoryBO(Long employeeId, String startDate, String endDate, JobsBO jobId, DepartamentsBO departamentId) {
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.jobId = jobId;
        this.departamentId = departamentId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public JobsBO getJobId() {
        return jobId;
    }

    public void setJobId(JobsBO jobId) {
        this.jobId = jobId;
    }

    public DepartamentsBO getDepartamentId() {
        return departamentId;
    }

    public void setDepartamentId(DepartamentsBO departamentId) {
        this.departamentId = departamentId;
    }

    @Override
    public String toString() {
        return "JobHistoryBO{" +
                "employeeId=" + employeeId +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", jobId=" + jobId +
                ", departamentId=" + departamentId +
                '}';
    }
}
