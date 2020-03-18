package ru.altagroup.timecontrol.dao.interfaces;

import ru.altagroup.timecontrol.model.PlanShedule;

import java.util.List;

public interface PlanSheduleDao {

    public List<PlanShedule> findPlanShedule(int uid);

}
