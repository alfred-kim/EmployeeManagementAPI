package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private DepartmentRepository departmentRepository  ;

    @Autowired
    private EmployeeRepository employeeRepository ;

    public Employee addEmployee(Employee employee){

        if(employee.getDepartment()!=null && employee.getDepartment().getId() !=0){

            Department dept = departmentRepository.findById(employee.getDepartment().getId()).orElseThrow(()->new RuntimeException("Department not found with id "+ employee.getDepartment().getId())) ;
            employee.setDepartment(dept);


        }

        return employeeRepository.save(employee) ;

    }

    



}
