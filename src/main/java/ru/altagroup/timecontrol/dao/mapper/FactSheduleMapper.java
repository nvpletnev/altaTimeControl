package ru.altagroup.timecontrol.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.altagroup.timecontrol.model.FactShedule;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class FactSheduleMapper implements RowMapper<FactShedule> {

    @Override
    public FactShedule mapRow(ResultSet resultSet, int i) throws SQLException {
        String datePattern = "yyyy-MM-dd h:m:s.S";
        SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
        Date startTime = null;
        Date endTime = null;
        try {
            startTime = dateFormat.parse(resultSet.getString("STARTTIME"));
            endTime = dateFormat.parse(resultSet.getString("ENDTIME"));
        } catch (ParseException e) {
            System.out.println("Cannot parse date!");
        }

        FactShedule factShedule = new FactShedule(startTime, endTime);

        return factShedule;
    }
}
