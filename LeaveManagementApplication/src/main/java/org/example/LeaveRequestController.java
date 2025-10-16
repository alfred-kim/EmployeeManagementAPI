package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaveRequest")
public class LeaveRequestController {

    @Autowired
    private LeaveRequestService leaveRequestService;

    @PostMapping

    public LeaveRequest submitRequest(@RequestBody LeaveRequest leaveRequest){

        return  leaveRequestService.submitLeaveRequest(leaveRequest) ;
    }

    @GetMapping

    public List<LeaveRequest> getAllRequests(){
        return leaveRequestService.getAllLeaveRequests() ;

    }

    @GetMapping("{id}")

    public List<LeaveRequest>getRequestsbyId(@PathVariable int id){
        return leaveRequestService.findByEmployeeID(id) ;
    }

    @PutMapping("/{id}/approve")

    public LeaveRequest approveRequest(@PathVariable int id){

        return leaveRequestService.approveLeaveRequest(id) ;
    }

    @PutMapping("/{id}/reject")

    public LeaveRequest rejectRequest(@PathVariable int id){

        return leaveRequestService.rejectLeaveRequest(id) ;

    }
}
