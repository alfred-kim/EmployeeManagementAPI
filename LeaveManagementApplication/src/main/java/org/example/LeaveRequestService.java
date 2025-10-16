package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveRequestService {

    @Autowired

    private LeaveRequestRepository leaveRequestRepository ;

    @Autowired

    private EmployeeRepository employeeRepository ;

    public LeaveRequest submitLeaveRequest(LeaveRequest request){

        if(request.getEmployee()!=null && request.getEmployee().getId()!=0){

            Employee employee = employeeRepository.findById(request.getEmployee().getId()).orElseThrow(()->new RuntimeException("Employee not found with id "+ request.getEmployee().getId())) ;

            request.setEmployee(employee);

        }

        else{
            throw new RuntimeException("Employee must be provided when submitting a request") ;
        }

        request.setStatus(leaveStatus.PENDING);

        return leaveRequestRepository.save(request) ;
    }

    public List<LeaveRequest>getAllLeaveRequests(){
        return leaveRequestRepository.findAll() ;
    }

    public List<LeaveRequest>findByEmployeeID(int id){
        return leaveRequestRepository.findByEmployeeId(id) ;
    }

    public LeaveRequest approveLeaveRequest(int id){
        LeaveRequest request = leaveRequestRepository.findById(id).orElseThrow(()->new RuntimeException("Leave Request not found with id" + id)) ;

        request.setStatus(leaveStatus.APPROVED);
       return leaveRequestRepository.save(request) ;
    }

    public LeaveRequest rejectLeaveRequest(int id){

        LeaveRequest request = leaveRequestRepository.findById(id).orElseThrow(()->new RuntimeException("request not found with id "+ id)) ;

        request.setStatus(leaveStatus.REJECTED);

        return leaveRequestRepository.save(request) ;

    }

}
