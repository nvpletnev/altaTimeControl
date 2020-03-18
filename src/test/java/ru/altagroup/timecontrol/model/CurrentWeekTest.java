package ru.altagroup.timecontrol.model;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class CurrentWeekTest {

    @Test
    public void getWeek() {
        List<Date> week = new ArrayList<>();
        int startWeek = 1;
        int endWeek = 7;
        LocalDate today = LocalDate.now();
        for (int i = startWeek; i <= endWeek; i++) {
            if (!(today.minusDays(i).getDayOfWeek() == DayOfWeek.SATURDAY
                    || today.minusDays(i).getDayOfWeek() == DayOfWeek.SUNDAY)) {
                System.out.println(today.minusDays(i));
                week.add(Date.valueOf(today.minusDays(i)));
            }
        }

    }
}