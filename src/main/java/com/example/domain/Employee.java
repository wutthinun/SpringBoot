package com.example.domain;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Created by apichat on 3/7/2016 AD.
 */
@Table(name="Employee")
@Entity
@Data
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private int age;
}
