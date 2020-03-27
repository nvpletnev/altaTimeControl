package ru.altagroup.timecontrol.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {

    private Integer uid;
    private String fullname;
    private Integer isLocked;
    private List<Timestamp> latenessList = new ArrayList<>();
    private List<Date> absenteeismList = new ArrayList<>();

    @Transient
    public List<Timestamp> getLatenessList() {
        return latenessList;
    }

    @Transient
    public void setLatenessList(List<Timestamp> latenessList) {
        this.latenessList = latenessList;
    }

    @Transient
    public List<Date> getAbsenteeismList() {
        return absenteeismList;
    }

    @Transient
    public void setAbsenteeismList(List<Date> absenteeismList) {
        this.absenteeismList = absenteeismList;
    }

    @Column(name = "ISLOCKED")
    public Integer getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(Integer isLocked) {
        this.isLocked = isLocked;
    }

    @Id
    @Column(name = "UID")
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Column(name = "FULLNAME")
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

}
