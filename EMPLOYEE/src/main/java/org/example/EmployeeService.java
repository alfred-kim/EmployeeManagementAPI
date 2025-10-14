package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo ;

    public Employee addEmployee(Employee employee){

        return repo.save(employee) ;

    }

    public List<Employee> getEmployees(){
        return repo.findAll() ;
    }

    public Optional<Employee> getEmployeebyId(int id){

        return repo.findById(id) ;

    }

    public Employee UpdateEmployee(Employee employee){

        return repo.save(employee) ;

    }

    public boolean deleteEmployee(int id){

        if(repo.existsById(id)){
            repo.deleteById(id);

            return true ;
        }

        else
            return false ;


    }





}
