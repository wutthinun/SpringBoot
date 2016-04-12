package com.example.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by apichat on 3/8/2016 AD.
 */
@Table(name="MaterialCode")
@Entity
@Data
public class MaterialCode {

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

    @Column(name="codeName")
    private String codeName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "matter")
    private Matter matter;
}
