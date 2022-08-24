package com.Quess.EmployeeManagementSystem.Models;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Table(name="Employee")
public class Employee implements UserDetails{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    @NotEmpty
    @Pattern(message="Sorry !Only characters are allowed", regexp = "^[a-zA-Z ]+$")
    private String name;
    @Column(nullable = false)
    @Min(value = 22,message = "Age should be Between 22 To 45")
    @Max(value = 45,message = "Age should be Between 22 To 45")
    private int age;
    @Column(nullable = false)
    @NotEmpty
    @Pattern(message="Phone number is not valid, Please enter Valid Phone Number", regexp = "^[0-9]{10}$")
    private String contact;
    @Column(nullable = false)
    @Min(value = 5000,message = "salary Should be minimum 5000")
    private String salary;
    @Column(nullable = false)
    @NotEmpty
    @Email(message = "Email is not valid", regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    private String email;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    @Pattern(message="password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit with atleast 8 characters",
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
    private String password;



   @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   @JoinTable(name="EmployeeRole", joinColumns = @JoinColumn(name="employeeid", referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name="roleid",referencedColumnName = "id"))
    private Set<Role> roles=new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities=this.roles.stream().map((role)->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
        return  authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
