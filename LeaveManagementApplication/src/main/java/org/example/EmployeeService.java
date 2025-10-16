package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private DepartmentRepository departmentRepository  ;

    @Autowired
    private EmployeeRepository employeeRepository ;

    @Autowired

    private LeaveRequestRepository leaveRequestRepository ;

    public Employee addEmployee(Employee employee){

        if(employee.getDepartment()!=null && employee.getDepartment().getId() !=0){

            Department dept = departmentRepository.findById(employee.getDepartment().getId()).orElseThrow(()->new RuntimeException("Department not found with id "+ employee.getDepartment().getId())) ;
            employee.setDepartment(dept);


        }

        else{
            throw new RuntimeException("department must be provided when creating an employee") ;
        }

        return employeeRepository.save(employee) ;

    }

    public List<Employee> viewEmployees(){
        return employeeRepository.findAll() ;
    }


    public Employee findEmployeebyID(int id){

        return employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee not found with id : " + id) ) ;

    }


    public boolean deleteEmployee(int id){

        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
            return true ;
        }

        else
            return false ;


    }

    public List<LeaveRequest>viewRequests(){

        return leaveRequestRepository.findAll() ;
    }


    public List<LeaveRequest>viewRequestbyEmployee(int id){

        Employee employee = employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee not found with id "+ id)) ;
        return employee.getLeaveRequests() ;

    }







}
