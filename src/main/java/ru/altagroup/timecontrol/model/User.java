package ru.altagroup.timecontrol.model;

import java.util.List;

public class User {

    private String fullname;
    private int uid;
    private List<FactShedule> factShedule;
    private List<PlanShedule> planShedule;

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

    public List<FactShedule> getFactShedule() {
        return factShedule;
    }

    public void setFactShedule(List<FactShedule> factShedule) {
        this.factShedule = factShedule;
    }

    public List<PlanShedule> getPlanShedule() {
        return planShedule;
    }

    public void setPlanShedule(List<PlanShedule> planShedule) {
        this.planShedule = planShedule;
    }
}
