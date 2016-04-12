package com.example.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by apichat on 3/8/2016 AD.
 */
@Table(name="Matter")
@Entity
@Data
public class Matter implements Serializable {

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

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    @Column(name="endDate")
    private Date endDate;

    @Column(name="materialName")
    private String materialName;

    @Column(name="rohs")
    private String rohs;

    @Column(name="msds")
    private String msds;

    @Column(name="spec")
    private String spec;

    @Column(name="halogen")
    private String halogen;

    @Column(name="status")
    private String status;

    @Column(name="folw")
    private String folw;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "materialType")
    private MaterialType materialType;

    @OrderBy("createDate")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "matter")
    private Set<MaterialCode> materialCodes;

    @OrderBy("createDate")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "matter")
    private Set<DocumentHistory> documentHistorys;
}
