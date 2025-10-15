package org.example;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id ;
    private String name ;
    private String email ;
    private String joinDate ;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    @JsonBackReference
    private Department department ;


    @OneToMany(mappedBy = "employee"  ,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<LeaveRequest> leaveRequests ;





    public List<LeaveRequest> getLeaveRequests() {
        return leaveRequests;
    }

    public void setLeaveRequests(List<LeaveRequest> leaveRequests) {
        this.leaveRequests = leaveRequests;
    }




    public Employee(){

    }

    public Employee(String name , String email , String joinDate){
        this.name = name ;
        this.email = email ;
        this.joinDate = joinDate ;
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

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
