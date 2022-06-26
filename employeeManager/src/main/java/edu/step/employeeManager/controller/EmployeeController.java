package edu.step.employeeManager.controller;

import edu.step.employeeManager.model.Employee;
import edu.step.employeeManager.repository.EmployeeRepository;
import edu.step.employeeManager.service.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeManager manager;


    @GetMapping
    public List<Employee> getAll(){
        return manager.read();
    }


    @PostMapping
    public void create(@RequestBody Employee emp){
        manager.create(emp);
    }

    @GetMapping
    @RequestMapping("/salary-filter")
    public List<Employee> filter() {
        return manager.filterBySalary(800.0);
    }


    @PutMapping
    public void edit(@RequestBody Employee emp) {
        manager.update(emp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        boolean result = manager.delete(id);
        if(result){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
