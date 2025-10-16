package org.example;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest , Integer> {

    List<LeaveRequest> findByEmployeeId(int employeeId) ;
}
