package ru.altagroup.timecontrol.model;

import java.util.List;

public class User {

    private String fullname;
    private int uid;
    private List<FactWeeklyShedule> factWeeklyShedule;
    private List<PlanWeeklyShedule> planWeeklyShedule;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public List<FactWeeklyShedule> getFactWeeklyShedule() {
        return factWeeklyShedule;
    }

    public void setFactWeeklyShedule(List<FactWeeklyShedule> factWeeklyShedule) {
        this.factWeeklyShedule = factWeeklyShedule;
    }

    public List<PlanWeeklyShedule> getPlanWeeklyShedule() {
        return planWeeklyShedule;
    }

    public void setPlanWeeklyShedule(List<PlanWeeklyShedule> planWeeklyShedule) {
        this.planWeeklyShedule = planWeeklyShedule;
    }
}
