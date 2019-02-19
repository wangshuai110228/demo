package com.jx.model;

import javax.persistence.*;

@Entity
@Table(name="t_catalog")
public class Catalog {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  Integer  caid;
    private String  caname;
    private   String  calink;
    private   String  catime;

    public Integer getCaid() {
        return caid;
    }

    public void setCaid(Integer caid) {
        this.caid = caid;
    }

    public String getCaname() {
        return caname;
    }

    public void setCaname(String caname) {
        this.caname = caname;
    }

    public String getCalink() {
        return calink;
    }

    public void setCalink(String calink) {
        this.calink = calink;
    }

    public String getCatime() {
        return catime;
    }

    public void setCatime(String catime) {
        this.catime = catime;
    }
}
