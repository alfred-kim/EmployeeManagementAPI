package org.example;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id ;

    private String name ;
    private String email ;
    private int age ;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "department_id" , referencedColumnName = "id")
    @JsonBackReference
    private Department department ;

    public Employee(){

    }

    public Employee(String name , String email , int age , Department department){

        this.name = name ;
        this.email = email ;
        this.age = age ;
        this.department = department ;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
