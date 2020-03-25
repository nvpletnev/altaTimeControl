package ru.altagroup.timecontrol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.altagroup.timecontrol.dao.EmployeeDao;
import ru.altagroup.timecontrol.dao.WorkingDayDao;
import ru.altagroup.timecontrol.model.Employee;
import ru.altagroup.timecontrol.model.WorkingDay;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Component
public class LatenessService {

    private EmployeeDao employeeDao;
    private WorkingDayDao workingDayDao;
    private int numberOfDays = 7;

    @Autowired
    public LatenessService(EmployeeDao employeeDao, WorkingDayDao workingDayDao) {
        this.employeeDao = employeeDao;
        this.workingDayDao = workingDayDao;
    }

    public List<Employee> findUsersWithLateness() {
        int numberDays = 7;
        Map<Integer, Employee> employees = employeeDao.findAll();
        Map<Integer, List<WorkingDay>> latenessDays = workingDayDao.findLateness(numberDays);
        List<Employee> result = new ArrayList<>();

        for (Map.Entry<Integer, Employee> employeeEntry : employees.entrySet()) {
            List<String> list = workingDayDao.findAbsenteeism(employeeEntry.getKey(), numberDays);
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
        result.sort(Comparator.comparing(Employee::getFullname));
        return result;
    }
}