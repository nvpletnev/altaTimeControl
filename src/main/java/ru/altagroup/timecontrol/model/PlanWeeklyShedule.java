package ru.altagroup.timecontrol.model;

import java.util.Date;

public class PlanWeeklyShedule {

    private Date startTime;
    private Date endTime;
    private int uid;

    public PlanWeeklyShedule(Date startTime, Date endTime, int uid) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.uid = uid;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public int getUid() {
        return uid;
    }
}
