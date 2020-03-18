package ru.altagroup.timecontrol.dao.mapper;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class FactWeeklySheduleMapperTest {

    @Test
    public void getDate() throws ParseException {
        String datePattern = "yyyy-MM-dd h:m:s.S";
        String dateFromTable = "2020-03-17 08:53:00.0000";
        Date date = new SimpleDateFormat(datePattern).parse(dateFromTable);
        System.out.println(date);

    }


}