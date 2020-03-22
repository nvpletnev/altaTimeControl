package ru.altagroup.timecontrol.model;

import java.util.Date;

public class WorkingDay {
    private Date start;
    private Date end;

    public WorkingDay(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }
}
