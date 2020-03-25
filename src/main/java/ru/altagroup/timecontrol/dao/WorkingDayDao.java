package ru.altagroup.timecontrol.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.altagroup.timecontrol.model.WorkingDay;

import java.sql.ResultSet;
import java.util.*;

@Component
public class WorkingDayDao {

    private JdbcTemplate template;

    @Autowired
    public WorkingDayDao(JdbcTemplate template) {
        this.template = template;
    }

    public Map<Integer, List<WorkingDay>> findFactDays(int days) {
        return findDays(days, "GRAPH_FACT", "starttime", "endtime");
    }

    public Map<Integer, List<WorkingDay>> findPlanDays(int days) {
        return findDays(days, "GRAPH_PLAN", "startdate", "enddate");
    }

    //todo удалить из map приходы в конце обеда, если есть уходы в начале обеда
    public Map<Integer, List<WorkingDay>> findLateness(int days) {
        String sql = String.format("select f.uid,f.starttime,f.endtime,p.startdate,p.enddate " +
                "from graph_fact as f join graph_plan as p on f.startdate=substring(p.startdate from 1 for 10) " +
                "where p.uid=f.uid and (f.starttime > p.startdate or f.endtime < p.enddate) " +
                "and (p.startdate between current_date-%d and current_date) order by f.uid", days);
        return template.query(sql, (ResultSet resultSet) -> {
            Map<Integer, List<WorkingDay>> lateness = new HashMap<>();
            while (resultSet.next()) {
                int key = Integer.parseInt(resultSet.getString("UID"));
                Date startdate = resultSet.getTimestamp("STARTTIME");
                Date enddate = resultSet.getTimestamp("ENDTIME");
                WorkingDay workingDay = new WorkingDay(startdate, enddate);
                if (lateness.containsKey(key)) {
                    lateness.get(key).add(workingDay);
                } else {
                    List<WorkingDay> workingDayArrayList = new ArrayList<>();
                    workingDayArrayList.add(workingDay);
                    lateness.put(key, workingDayArrayList);
                }
            }
            return lateness;
        });
    }

    public List<String> findAbsenteeism(int uid, int days) {
        String sql = String.format("select uid,startdate from graph_plan " +
                "where uid=%1$d and (startdate between current_date-%2$d and current_date) " +
                "and substring(startdate from 1 for 10) not in (select startdate from graph_fact where uid=%1$d)", uid, days);
        return template.query(sql, ((resultSet, i) -> resultSet.getString("STARTDATE").substring(0, 10)));
    }

    private Map<Integer, List<WorkingDay>> findDays(int days, String table, String column1, String column2) {
        String sql =
                String.format("select uid,%1$s,%2$s from %3$s where uid in" +
                                " (select uid from users where islocked is null) " +
                                "and %1$s between current_date-%4$d and current_date",
                        column1, column2, table, days);

        return template.query(sql, (ResultSet resultSet) -> {
            Map<Integer, List<WorkingDay>> workingDaymap = new HashMap<>();

            while (resultSet.next()) {
                int key = Integer.parseInt(resultSet.getString("UID"));
                Date startdate = resultSet.getTimestamp(column1);
                Date enddate = resultSet.getTimestamp(column2);
                WorkingDay workingDay = new WorkingDay(startdate, enddate);

                if (workingDaymap.containsKey(key)) {
                    workingDaymap.get(key).add(workingDay);
                } else {
                    List<WorkingDay> workingDayArrayList = new ArrayList<>();
                    workingDayArrayList.add(workingDay);
                    workingDaymap.put(key, workingDayArrayList);
                }
            }
            return workingDaymap;
        });
    }
}