package edu.step.employeeManager.service;

import edu.step.employeeManager.model.Employee;
import edu.step.employeeManager.repository.CompanyRepository;
import edu.step.employeeManager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CompanyManager { // CRUD

    @Autowired
    private CompanyRepository companyRepository;

}
