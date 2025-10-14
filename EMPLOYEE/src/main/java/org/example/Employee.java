package org.example;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int Id ;
    private String name ;
    private String email ;
    private int age ;

    public Employee(){

    }

    public Employee(String name , String email , int age){

        this.name = name ;
        this.email = email ;
        this.age = age ;

    }



    public long getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
