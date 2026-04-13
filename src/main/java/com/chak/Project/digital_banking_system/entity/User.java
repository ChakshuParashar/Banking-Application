package com.chak.Project.digital_banking_system.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private Integer  age;
    private String address;
    private Long mobileNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Account> account;
}
