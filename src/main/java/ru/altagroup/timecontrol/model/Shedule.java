package ru.altagroup.timecontrol.model;

import org.springframework.stereotype.Component;

@Component
public class Shedule {

    private String start;
    private String end;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Shedule() {
    }
}
