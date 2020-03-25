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
        int daysCount = 7;
        Map<Integer, Employee> employees = employeeDao.findAll();
        Map<Integer, List<WorkingDay>> latenessDays = workingDayDao.findLateness(daysCount);
        List<Employee> result = new ArrayList<>();

        for (Map.Entry<Integer, Employee> employeeEntry : employees.entrySet()) {
            List<String> list = workingDayDao.findAbsenteeism(employeeEntry.getKey(), daysCount);
            if (latenessDays.containsKey(employeeEntry.getKey())) {
                employeeEntry.getValue().setWorkingDays(latenessDays.get(employeeEntry.getKey()));
                if (!list.isEmpty()) {
                    employeeEntry.getValue().setAbsenteeism(list);
                }
                result.add(employeeEntry.getValue());
            } if (!list.isEmpty() && !result.contains(employeeEntry.getValue())) {
                employeeEntry.getValue().setAbsenteeism(list);
                result.add(employeeEntry.getValue());
            }
        }

        result.forEach(employee -> {
            System.out.println(employee.getFullname());
            employee.getWorkingDays().forEach(workingDay -> System.out.println(workingDay.getStart() + " " + workingDay.getEnd()));
            employee.getAbsenteeism().forEach(System.out::println);
        });

//        for (Map.Entry<Integer, List<WorkingDay>> entry : latenessDays.entrySet()) {
//
//            Employee employee = employees.get(entry.getKey());
//
//            employee.setWorkingDays(entry.getValue());
//
//            System.out.println(employee.getFullname());
//
//            employee.setAbsenteeism(workingDayDao.findAbsenteeism(entry.getKey(), 7));
//
//            employee.getWorkingDays().forEach(workingDay -> System.out.println(workingDay.getStart() + " " + workingDay.getEnd()));
//            employee.getAbsenteeism().forEach(absenteesm -> System.out.println(absenteesm));
//            System.out.println();
//        }

    }
}