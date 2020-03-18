package ru.altagroup.timecontrol.dao.interfaces;

import ru.altagroup.timecontrol.model.FactShedule;

import java.util.List;

public interface FactSheduleDao {

    public List<FactShedule> findFactShedule(int uid);

}
