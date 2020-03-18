package ru.altagroup.timecontrol.dao.interfaces;

import ru.altagroup.timecontrol.model.PlanWeeklyShedule;

import java.util.List;

public interface PlanWeeklySheduleDao {

    public List<PlanWeeklyShedule> findWeeklyPlanShedule();

}
