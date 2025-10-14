package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired

    private DepartmentService departmentService ;


    @PostMapping
    public Department addDepartment(@RequestBody Department department){

        return departmentService.addDepartment(department) ;

    }

    @GetMapping("/{id}")

    public Optional<Department> getDepartmentByID(@PathVariable int id){
        return departmentService.getDepartmentById(id) ;
    }

    @GetMapping

    public List<Department>getDepartments(){

        return departmentService.getAllDepartments() ;
    }

    @PutMapping("/{id}")

    public Department updateDepartment( @PathVariable int id , @RequestBody Department department ){
        return departmentService.updateDepartment(id , department) ;
    }

    @DeleteMapping("/{id}")

    public boolean deleteDepartment(@PathVariable int id){
        return departmentService.deleteDepartment(id) ; 
    }

}
