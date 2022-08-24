package com.Quess.EmployeeManagementSystem.Models;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table (name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;



}
