package com.Quess.EmployeeManagementSystem.Controller;



import com.Quess.EmployeeManagementSystem.Models.EmployeeRole;
import com.Quess.EmployeeManagementSystem.Service.RoleOfEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employeerole")
public class RoleOfEmployeeController {
    @Autowired
    private RoleOfEmployeeService service;

    public RoleOfEmployeeController(RoleOfEmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> saveRoleOfEmployee(@RequestBody EmployeeRole roleOfEmployee)
    {
        service.saveRoleOfEmployee(roleOfEmployee);
        return new ResponseEntity<String>("Role Created successfully", HttpStatus.CREATED);
    }

    @GetMapping
    public List<EmployeeRole> getAllRoleOfEmployee()

    {
        return service.getAllRoleOfEmployee();
    }
    @GetMapping("{id}")
    public ResponseEntity<EmployeeRole> getRoleOfEmployeeById(@PathVariable("id")int id)
    {
        return new ResponseEntity<EmployeeRole>(service.getRoleOfEmployeeById(id),HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<String> updateRoleOfEmployee(@PathVariable("id")int id,@RequestBody EmployeeRole roleOfEmployee)
    {
        service.updateRoleOfEmployee(roleOfEmployee,id);
        return new ResponseEntity<String>("Role Updated Successfully", HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRoleOfEmployee(@PathVariable("id")int id)
    {
        service.deleteRoleOfEmployee(id);
        return new ResponseEntity<String>("Role deleted successfully",HttpStatus.OK);
    }
}
