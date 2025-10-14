package org.example;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmployeeService {

    @Autowired

    private EmployeeRepository employeeRepository ;

    public Employee addEmployee(Employee employee){

        return employeeRepository.save(employee) ;

    }

    public List<Employee>getAllEmployees(){

        return employeeRepository.findAll() ;

    }

    public Optional<Employee>getEmployeebyId(int id){
        return employeeRepository.findById(id) ;
    }

    public Employee updateEmployee(int id , Employee employee){

        Employee existing = employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee not found with id "+ id)) ;

        existing.setName(employee.getName());
        existing.setAge(employee.getAge());
        existing.setDepartment(employee.getDepartment());
        existing.setEmail(employee.getEmail());

        return employeeRepository.save(existing) ;


    }

    public boolean deleteEmployeebyID(int id){

        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
            return true ;
        }

        else
            return false ;



    }





}
