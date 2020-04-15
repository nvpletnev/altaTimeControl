package ru.altagroup.timecontrol.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {

    private Integer uid;
    private String fullname;
    private Integer isLocked;
    private List<GraphFact> latenessList = new ArrayList();
    private List<GraphPlan> absenteeismList = new ArrayList();

    @Transient
    public List<GraphFact> getLatenessList() {
        return latenessList;
    }

    @Transient
    public void setLatenessList(List<GraphFact> latenessList) {
        this.latenessList = latenessList;
    }

    @Transient
    public List<GraphPlan> getAbsenteeismList() {
        return absenteeismList;
    }

    @Transient
    public void setAbsenteeismList(List<GraphPlan> absenteeismList) {
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

    public boolean hasLateForDay(LocalDate date) {
        if (latenessList.size() == 0) return false;
        return latenessList.stream().anyMatch(graphFact ->
                LocalDate.from(graphFact.getStartTime().toLocalDateTime()).equals(date));
    }

    public GraphFact getLateForDay(LocalDate date) {
        return latenessList.stream()
                .filter(graphFact -> LocalDate.from(graphFact.getStartTime().toLocalDateTime()).equals(date))
                .findFirst()
                .get();
    }

    public boolean hasAbsenteesmForDay(LocalDate date) {
        if (absenteeismList.size() == 0) return false;
        return absenteeismList.stream()
                .filter(graphFact -> LocalDate.from(graphFact.getStartDate().toLocalDateTime()).equals(date))
                .count() > 0;
    }

    public GraphPlan getAbsenteesmForDay(LocalDate date) {
        return absenteeismList.stream()
                .filter(graphFact -> LocalDate.from(graphFact.getStartDate().toLocalDateTime()).equals(date))
                .findFirst()
                .get();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            User user = (User) obj;
            return this.getUid().equals(user.getUid());
        } else return false;
    }

    @Override
    public String toString() {
        String[] temp = this.getFullname().split(" ");
        return temp[0] + " " + temp[1].charAt(0) + "." + temp[2].charAt(0);
    }
}
