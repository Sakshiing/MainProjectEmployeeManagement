package com.Quess.EmployeeManagementSystem.Repository;

import com.Quess.EmployeeManagementSystem.Models.EmployeeRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleOfEmployeeRepository extends JpaRepository<EmployeeRole,Integer> {
    Optional<EmployeeRole> findById(int id);


}
