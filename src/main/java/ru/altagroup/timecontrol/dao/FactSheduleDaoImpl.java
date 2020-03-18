package ru.altagroup.timecontrol.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.altagroup.timecontrol.dao.interfaces.FactSheduleDao;
import ru.altagroup.timecontrol.dao.mapper.FactSheduleMapper;
import ru.altagroup.timecontrol.model.FactShedule;

import java.util.List;

public class FactSheduleDaoImpl implements FactSheduleDao {

    private JdbcTemplate template;

    @Autowired
    public FactSheduleDaoImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<FactShedule> findFactShedule(int uid) {
        String sql = "SELECT first 7 starttime,endtime from graph_fact where uid=? order by starttime DESC";
        return template.query(sql, new FactSheduleMapper(), uid);
    }
}
