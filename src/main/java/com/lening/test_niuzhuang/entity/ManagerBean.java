package com.lening.test_niuzhuang.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "tb_manager")
@Entity
@Data
public class ManagerBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;


}
