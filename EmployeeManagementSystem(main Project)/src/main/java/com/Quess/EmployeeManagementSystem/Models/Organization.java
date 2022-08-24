package com.Quess.EmployeeManagementSystem.Models;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Table(name = "Organization")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Organization  {

    public Organization() {

    }
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    @NotEmpty
    @Pattern(message="Sorry ! Only characters are allowed", regexp = "^[a-zA-Z ]+$")
    private String name;

    @NotEmpty
    @Pattern(message="Sorry ! Only characters are allowed", regexp = "^[a-zA-Z ]+$")
    private String address;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval=true ,fetch = FetchType.EAGER)
    private Set<Employee> Employeeid=new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval=true ,fetch = FetchType.EAGER)
    private Set<Assets> Assetsid =new HashSet<>();

}
