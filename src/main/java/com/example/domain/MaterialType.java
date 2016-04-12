package com.example.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by apichat on 3/8/2016 AD.
 */
@Table(name="MaterialType")
@Entity
@Data
public class MaterialType {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    @Column(name="createDate")
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    @Column(name="updateDate")
    private Date updateDate;

    @OneToOne(fetch = FetchType.EAGER)
    private AppUser createBy;

    @OneToOne(fetch = FetchType.EAGER)
    private AppUser updateBy;

    @Column(name="typeName")
    private String typeName;

    @OrderBy("createDate")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "materialType")
    private Set<Matter> matters;
}
