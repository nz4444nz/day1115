package com.lening.test_niuzhuang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "tb_company")
@Entity
@Data
public class CompanyBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;
    private String cname;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datea;

    private String service;
    private Integer open;

    @Transient
    private List<String> services = new ArrayList<String>();


}
