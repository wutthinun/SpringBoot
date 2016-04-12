package com.example.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;
/**
 * Created by apichat on 3/9/2016 AD.
 */
@Table(name="AppUser")
@Entity
@Data
public class AppUser implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="username", unique = true)
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="name")
    private String name;

    @Column(name="department")
    private String department;

    @Column(name="departmentCode")
    private String departmentCode;

    @Column(name="emailAddress")
    private String emailAddress;

    @Column(name="phoneNumber")
    private String phoneNumber;

    @Value("1")
    @Column(name="enabled")
    private Integer enabled;

    @Column(name="roleName")
    private String roleName;
}
