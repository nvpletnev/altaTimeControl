package ru.altagroup.timecontrol.model;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private int uid;
    private String fullname;
    private List<WorkingDay> workingDays;

    public Employee(int uid, String fullname) {
        this.uid = uid;
        this.fullname = fullname;
        this.workingDays = new ArrayList<>();
    }

    public List<WorkingDay> getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(List<WorkingDay> workingDays) {
        this.workingDays = workingDays;
    }

    public int getUid() {
        return uid;
    }

    public String getFullname() {
        return fullname;
    }
}
