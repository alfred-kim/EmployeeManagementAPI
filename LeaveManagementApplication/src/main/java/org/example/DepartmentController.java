package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService  ;

    @PostMapping

    public Department addDepartment(@RequestBody Department department){

        return departmentService.addDepartment(department) ;
    }

    @GetMapping

    public List<Department> getDepartmets(){

        return departmentService.getAllDepartments() ;
    }

    @GetMapping("/{id}")


    public Department getDepartmentbyId(@PathVariable int id){

        return departmentService.getDepartmentbyID(id) ;

    }

    @PutMapping("/{id}")

    public Department updateDepartment(@PathVariable int id , @RequestBody Department department ){

        return departmentService.updateDepartment(id , department)  ;

    }

    @DeleteMapping("/{id}")

    public String deleteDepartment(@PathVariable int id){

        boolean result =  departmentService.deleteDepartment(id) ;

        return result?"Success":"Failure" ;
    }

    @GetMapping("/{id}/employees")

    public List<Employee>getEmployeesByDepartment(@PathVariable int id){

        return departmentService.getEmployeesByDepartment(id) ;

    }




}
