package org.example;

import jakarta.persistence.Entity;

@Entity
public class Employee {

    private String name  ;
    private String Email ;
    private int age ;


    public Employee(){

    }

    public Employee(String name , String Email , int age){
        this.name = name ;
        this.Email = Email ;
        this.age = age ;

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
}
