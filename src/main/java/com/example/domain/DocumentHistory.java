package com.example.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by apichat on 3/9/2016 AD.
 */
@Table(name="DocumentHistory")
@Entity
@Data
public class DocumentHistory implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    @Column(name="createDate")
    private Date createDate;

    @OneToOne(fetch = FetchType.EAGER)
    private AppUser createBy;

    @Column(name="actionType")
    private String actionType;

    @Column(name="remark")
    private String remark;

    @Column(name="status")
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "matter")
    private Matter matter;
}
