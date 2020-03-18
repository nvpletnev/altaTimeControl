package ru.altagroup.timecontrol.model;

import java.util.Date;

public class FactWeeklyShedule {

    private Date startTime;
    private Date endTime;
    private int uid;

    public FactWeeklyShedule(Date startTime, Date endTime, int uid) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.uid = uid;
    }

    public int getUid() {
        return uid;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }
}
