package ru.altagroup.timecontrol.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "GRAPH_FACT")
public class GraphFact {

    private Integer sfcode;
    private Integer uid;
    private Date startDate;
    private Date endDate;
    private Timestamp startTime;
    private Timestamp endTime;

    @Id
    @Column(name = "SFCODE")
    public Integer getSfcode() {
        return sfcode;
    }

    public void setSfcode(Integer sfcode) {
        this.sfcode = sfcode;
    }

    @Column(name = "UID")
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Column(name = "STARTDATE")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name = "ENDDATE")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Column(name = "STARTTIME")
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Column(name = "ENDTIME")
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GraphFact) {
            LocalDate thisFactDate = LocalDate.from(this.getStartDate().toInstant());
            LocalDate factDate = ((GraphFact) obj).getStartDate().toLocalDate();
            return this.getUid().equals(((GraphFact) obj).getUid()) && thisFactDate.equals(factDate);
        } else if (obj instanceof GraphPlan) {
            LocalDate thisFactDate = this.getStartDate().toLocalDate();
            LocalDate planDate = ((GraphPlan) obj).getStartDate().toLocalDateTime().toLocalDate();
            return this.getUid().equals(((GraphPlan) obj).getUid()) && thisFactDate.equals(planDate);
        } else return false;
    }

    @Override
    public String toString() {
        return this.getStartTime() + " " + this.getEndTime();
    }
}
