package edu.step.employeeManager.service;

import edu.step.employeeManager.model.Employee;
import edu.step.employeeManager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeManager { // CRUD

    @Autowired
    private EmployeeRepository employeeRepository;

    public void create(Employee emp) {
        Employee savedEmployee = employeeRepository.save(emp);
    }

    public List<Employee> read(){
       return employeeRepository.findAll();
    }

    public List<Employee> filterBySalary(Double salary) {
        return employeeRepository.findEmployeesBySalaryIsGreaterThan(salary);
    }

    // edit
    public void update(Employee updatedEmployee){
        Optional<Employee> optionalEmployee = employeeRepository.findById(updatedEmployee.getId());
        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            employee.setFirstName(updatedEmployee.getFirstName());
            employee.setLastname(updatedEmployee.getLastname());
            employee.setSalary(updatedEmployee.getSalary());
            employeeRepository.save(employee);
        }
    }


    public boolean delete(Integer id){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()) {
            employeeRepository.delete(optionalEmployee.get());
            return true;
        }
        return false;
    }
    // delete
}
