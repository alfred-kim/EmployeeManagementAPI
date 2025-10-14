package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired

    private EmployeeService employeeService ;

    //Add new Employee

    @PostMapping

    public Employee addEmployee(@RequestBody Employee employee){

        return employeeService.addEmployee(employee) ;

    }

    @GetMapping

    public List<Employee> getEmployees(){
        return employeeService.getEmployees() ;
    }

    @GetMapping("/{id}")

    public Optional<Employee> getEmployeebyID(@PathVariable int id){

        return employeeService.getEmployeebyId(id) ;

    }

    @PutMapping("/{id}")

    public Employee updateEmployee(@PathVariable int id , @RequestBody Employee employee){

      

        return employeeService.UpdateEmployee(employee) ;

    }

    @DeleteMapping("/{id}")

    public String deleteEmployee(@RequestParam int id){
        boolean result =  employeeService.deleteEmployee(id) ;

        return result?"Success" : "Failure" ;

    }










}
