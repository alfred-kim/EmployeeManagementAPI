package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService ;





    @PostMapping
    public Employee addEmployee( @RequestBody Employee employee){
        return employeeService.addEmployee(employee) ;
    }

    @GetMapping
    public List<Employee> getEmployees(){

        return employeeService.viewEmployees() ;
    }

    @GetMapping("/{id}")

    public Employee findEmployeeById(@PathVariable int id){

        return employeeService.findEmployeebyID(id) ;
    }

    @DeleteMapping("/{id}")

    public String deleteEmployee(@PathVariable int id){

        boolean result = employeeService.deleteEmployee(id)  ;

        return result? "success" : "failure" ;

    }


    @GetMapping("/leaves")

    public List<LeaveRequest>getLeaveRequests(){

        return employeeService.viewRequests() ;
    }

    @GetMapping("/{id}/leaves")

    public List<LeaveRequest>getRequestsbyID(@PathVariable int id){
        return employeeService.viewRequestbyEmployee(id)  ;
    }




}
