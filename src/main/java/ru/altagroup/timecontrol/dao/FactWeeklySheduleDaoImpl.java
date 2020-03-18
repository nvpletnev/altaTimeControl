package ru.altagroup.timecontrol.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.altagroup.timecontrol.dao.interfaces.FactWeeklySheduleDao;
import ru.altagroup.timecontrol.dao.mapper.FactSheduleMapper;
import ru.altagroup.timecontrol.model.FactWeeklyShedule;

import java.util.List;

@Component
public class FactWeeklySheduleDaoImpl implements FactWeeklySheduleDao {

    private JdbcTemplate template;

    @Autowired
    public FactWeeklySheduleDaoImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<FactWeeklyShedule> findFactWeeklyShedule() {
        String sql = "select uid,starttime,endtime from graph_fact where startdate between current_date-7 and current_date order by uid";
        return template.query(sql, new FactSheduleMapper());
    }
}
