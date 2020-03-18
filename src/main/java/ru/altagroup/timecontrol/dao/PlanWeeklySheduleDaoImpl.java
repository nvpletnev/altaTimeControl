package ru.altagroup.timecontrol.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.altagroup.timecontrol.dao.interfaces.PlanWeeklySheduleDao;
import ru.altagroup.timecontrol.dao.mapper.PlanSheduleMapper;
import ru.altagroup.timecontrol.model.PlanWeeklyShedule;

import java.util.List;

@Component
public class PlanWeeklySheduleDaoImpl implements PlanWeeklySheduleDao {

    private JdbcTemplate template;

    @Autowired
    public PlanWeeklySheduleDaoImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<PlanWeeklyShedule> findWeeklyPlanShedule() {
        String sql = "select uid,startdate,enddate from graph_plan where startdate between current_date-7 and current_date order by uid";
        return template.query(sql, new PlanSheduleMapper());
    }
}
