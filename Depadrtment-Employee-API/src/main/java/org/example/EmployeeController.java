package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService ;


    @PostMapping

    public Employee addEmployee(@RequestBody Employee employee  ){

        return employeeService.addEmployee(employee) ;


    }


    @GetMapping

    public List<Employee> getEmployees(){

        return employeeService.getAllEmployees() ;

    }

    @GetMapping("/{id}")

    public Optional<Employee> getEmployeeByID(@PathVariable int id){

        return employeeService.getEmployeebyId(id) ;
    }

    @PutMapping("/{id}")

    public Employee updateEmployee(@PathVariable int id , @RequestBody Employee employee){



        return employeeService.updateEmployee(id ,employee) ;

    }

    @DeleteMapping("/{id}")
    public boolean deleteEmployee(@PathVariable int id){

        return employeeService.deleteEmployeebyID(id) ;

    }






}
