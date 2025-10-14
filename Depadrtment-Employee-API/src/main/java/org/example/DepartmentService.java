package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired

    private DepartmentRepository departmentRepository ;

    public Department addDepartment(Department department){
        return departmentRepository.save(department) ;
    }

    public List<Department>getAllDepartments(){
        return departmentRepository.findAll() ;
    }

    public Optional<Department> getDepartmentById(int id){

        return departmentRepository.findById(id) ;

    }

    public Department updateDepartment(int id ,Department department){

        Department existing = departmentRepository.findById(id).orElseThrow(()->new RuntimeException("Department not found with id " + id));

        existing.setName(department.getName());
        existing.setLocation(department.getLocation());
        return departmentRepository.save(existing);

    }



    public boolean deleteDepartment(int id){

        if(departmentRepository.existsById(id)){
            departmentRepository.deleteById(id);
            return true ;
        }

        else
            return false ;

    }

}
