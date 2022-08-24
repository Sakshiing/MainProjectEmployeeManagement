package com.Quess.EmployeeManagementSystem.Service;


import com.Quess.EmployeeManagementSystem.Models.EmployeeRole;

import com.Quess.EmployeeManagementSystem.Repository.RoleOfEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleOfEmployeeServiceIMPL implements RoleOfEmployeeService{
    @Autowired
    private RoleOfEmployeeRepository roleOfEmployeeRepository;

    public RoleOfEmployeeServiceIMPL(RoleOfEmployeeRepository roleOfEmployeeRepository) {
        this.roleOfEmployeeRepository =roleOfEmployeeRepository;
    }

    @Override
    public EmployeeRole saveRoleOfEmployee(EmployeeRole roleOfEmployee) {
        return roleOfEmployeeRepository.save(roleOfEmployee);
    }

    @Override
    public List<EmployeeRole> getAllRoleOfEmployee() {
        return roleOfEmployeeRepository.findAll();
    }

    @Override
    public EmployeeRole getRoleOfEmployeeById(int id) {
        return roleOfEmployeeRepository.findById(id).orElseThrow(() -> new com.Quess.EmployeeManagementSystem.exception.ResourceNotFoundException("Role not found with id :" + id));
    }

    @Override
    public EmployeeRole updateRoleOfEmployee(EmployeeRole roleOfEmployee, int id) {
        EmployeeRole existingDetail=roleOfEmployeeRepository.findById(id).orElseThrow(() -> new com.Quess.EmployeeManagementSystem.exception.ResourceNotFoundException("Role not found with id :" + id));
        existingDetail.setEmployeeid(roleOfEmployee.getEmployeeid());
        existingDetail.setRoleid(roleOfEmployee.getRoleid());
        roleOfEmployeeRepository.save(existingDetail);
        return existingDetail;
    }

    @Override
    public void deleteRoleOfEmployee(int id) {
        roleOfEmployeeRepository.findById(id).orElseThrow(() -> new com.Quess.EmployeeManagementSystem.exception.ResourceNotFoundException("Role not found with id :" + id));
        roleOfEmployeeRepository.deleteById(id);


    }

}
