package org.example;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Department {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String name ;
    private String location ;

    @OneToMany(mappedBy = "department" ,cascade = CascadeType.ALL)

    private List<Employee> employees ;




    public Department(){

    }

    public Department(String name , String location){
        this.name = name ;
        this.location = location ;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
