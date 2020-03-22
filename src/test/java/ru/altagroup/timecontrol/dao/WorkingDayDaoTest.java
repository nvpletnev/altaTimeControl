package ru.altagroup.timecontrol.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.altagroup.timecontrol.model.WorkingDay;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class WorkingDayDaoTest {

    @Autowired
    WorkingDayDao workingDayDao;

    @Test
    void findFactDays() {
        int uid = 295;
        int countDays = 7;
        Map<Integer, List<WorkingDay>> map = workingDayDao.findFactDays(countDays);
        assertTrue(map.containsKey(uid));
    }

    @Test
    void findPlanDays() {
        int uid = 295;
        int countDays = 7;
        Map<Integer, List<WorkingDay>> map = workingDayDao.findPlanDays(countDays);
        assertTrue(map.containsKey(uid));
    }
}