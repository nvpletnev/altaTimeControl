package ru.altagroup.timecontrol.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "GRAPH_PLAN")
public class GraphPlan {

    private Integer pgid;
    private Integer uid;
    private Timestamp startDate;
    private Timestamp endDate;
    private Time dinerStart;
    private Time dinerEnd;

    @Id
    @Column(name = "PGID")
    public Integer getPgid() {
        return pgid;
    }

    public void setPgid(Integer pgid) {
        this.pgid = pgid;
    }

    @Column(name = "UID")
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Column(name = "STARTDATE")
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Column(name = "ENDDATE")
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Column(name = "DINER_START")
    public Time getDinerStart() {
        return dinerStart;
    }

    public void setDinerStart(Time dinerStart) {
        this.dinerStart = dinerStart;
    }

    @Column(name = "DINER_END")
    public Time getDinerEnd() {
        return dinerEnd;
    }

    public void setDinerEnd(Time dinerEnd) {
        this.dinerEnd = dinerEnd;
    }

}
