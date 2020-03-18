package ru.altagroup.timecontrol.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.altagroup.timecontrol.dao.interfaces.PlanSheduleDao;
import ru.altagroup.timecontrol.dao.mapper.PlanSheduleMapper;
import ru.altagroup.timecontrol.model.PlanShedule;

import java.util.List;

@Component
public class PlanSheduleDaoImpl implements PlanSheduleDao {

    private JdbcTemplate template;

    @Autowired
    public PlanSheduleDaoImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<PlanShedule> findPlanShedule(int uid) {

        String sql = "select first 7 startdate,enddate from graph_plan " +
                "where startdate < current_date and uid=? order by startdate DESC;";
        return template.query(sql, new PlanSheduleMapper(), uid);
    }
}
