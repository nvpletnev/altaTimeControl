package ru.altagroup.timecontrol.model;

import java.util.Date;

public class PlanShedule {

    private Date startTime;
    private Date endTime;

    public PlanShedule(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }
}
