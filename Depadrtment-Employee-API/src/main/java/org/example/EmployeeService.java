package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired

    private EmployeeRepository employeeRepository ;

    @Autowired
    private DepartmentRepository departmentRepository ;

    public Employee addEmployee(Employee employee){

        if(employee.getDepartment() !=null && employee.getDepartment().getId() !=0){

            Department dept = departmentRepository.findById(employee.getDepartment().getId())
                    .orElseThrow(() ->new RuntimeException("Department not found with id" + employee.getDepartment().getId())) ;

            employee.setDepartment(dept);
        }

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
