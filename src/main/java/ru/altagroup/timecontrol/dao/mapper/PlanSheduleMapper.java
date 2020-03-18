package ru.altagroup.timecontrol.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.altagroup.timecontrol.model.PlanWeeklyShedule;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlanSheduleMapper implements RowMapper<PlanWeeklyShedule> {

    @Override
    public PlanWeeklyShedule mapRow(ResultSet resultSet, int i) throws SQLException {
        String datePattern = "yyyy-MM-dd h:m:s.S";
        SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
        Date startTime = null;
        Date endTime = null;
        int uid = 0;
        try {
            uid = resultSet.getInt("UID");
            startTime = dateFormat.parse(resultSet.getString("STARTDATE"));
            endTime = dateFormat.parse(resultSet.getString("ENDDATE"));
        } catch (ParseException e) {
            System.out.println("Cannot parse date!");
        }
        PlanWeeklyShedule planWeeklyShedule = new PlanWeeklyShedule(startTime, endTime, uid);

        return planWeeklyShedule;
    }
}
