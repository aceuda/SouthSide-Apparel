package com.southsideapparel.southsideapparel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String passwordHash;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String province;
    private String postalCode;
}