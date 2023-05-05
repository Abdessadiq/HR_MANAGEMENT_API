package com.hrmanagement.api.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "employees")
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String mail;
    private String password;

}
