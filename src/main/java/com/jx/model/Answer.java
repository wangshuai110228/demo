package com.jx.model;

import javax.persistence.*;

@Entity
@Table(name="t_answer")
public class Answer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  Integer id;
    private  String contont;
    private  String createtime;
    private  Integer wid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContont() {
        return contont;
    }

    public void setContont(String contont) {
        this.contont = contont;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }
}
