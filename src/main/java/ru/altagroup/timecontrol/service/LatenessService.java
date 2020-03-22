package ru.altagroup.timecontrol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.altagroup.timecontrol.dao.EmployeeDao;
import ru.altagroup.timecontrol.dao.WorkingDayDao;
import ru.altagroup.timecontrol.model.Employee;
import ru.altagroup.timecontrol.model.WorkingDay;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class LatenessService {

    private EmployeeDao employeeDao;
    private WorkingDayDao workingDayDao;

    @Autowired
    public LatenessService(EmployeeDao employeeDao, WorkingDayDao workingDayDao) {
        this.employeeDao = employeeDao;
        this.workingDayDao = workingDayDao;
    }

    public List<Employee> findUsersWithLateness() {
        int daysCount = 7;
        Map<Integer, Employee> employeeMap = employeeDao.findAll();
        Map<Integer, List<WorkingDay>> factDayMap = workingDayDao.findFactDays(daysCount);
        Map<Integer, List<WorkingDay>> planDayMap = workingDayDao.findPlanDays(daysCount);

        List<Employee> result = new ArrayList<>();

        return result;
    }
}