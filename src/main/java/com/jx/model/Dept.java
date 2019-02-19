package com.jx.model;

import javax.persistence.*;

@Entity
@Table(name="t_dept")
public class Dept {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String dname;
    private Integer uid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
