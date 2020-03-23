package ru.altagroup.timecontrol.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.altagroup.timecontrol.dao.EmployeeDao;
import ru.altagroup.timecontrol.dao.WorkingDayDao;
import ru.altagroup.timecontrol.model.Employee;
import ru.altagroup.timecontrol.model.WorkingDay;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@SpringBootTest
@RunWith(SpringRunner.class)
class LatenessServiceTest {

    @Autowired
    LatenessService service;

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    WorkingDayDao workingDayDao;

    @Test
    public void testLatenessService() {
        Map<Integer, List<WorkingDay>> latenessDays = workingDayDao.findLateness(7);
        Map<Integer, Employee> employees = employeeDao.findAll();


        for (Map.Entry<Integer, List<WorkingDay>> entry : latenessDays.entrySet()) {

            Employee employee = employees.get(entry.getKey());

            employee.setWorkingDays(entry.getValue());

            System.out.println(employee.getFullname());

            for (WorkingDay workingDay : employee.getWorkingDays()) {
                System.out.println(workingDay.getStart() + " " + workingDay.getEnd());
            }
        }

    }
}