package com.jx.model;

import javax.persistence.*;

@Entity
@Table(name="t_problem")
public class Problem {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String createtime;
    private Integer sfzr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getSfzr() {
        return sfzr;
    }

    public void setSfzr(Integer sfzr) {
        this.sfzr = sfzr;
    }
}
