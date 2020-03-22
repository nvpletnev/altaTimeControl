package ru.altagroup.timecontrol.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.altagroup.timecontrol.model.Employee;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeDaoTest {

    private static int uid = 512;

    @Autowired
    EmployeeDao employeeDao;

    @Test
    void findAll() {
        Map<Integer, Employee> userMap = employeeDao.findAll();
        assertEquals(uid, userMap.get(uid).getUid());
    }

    @Test
    void find() {
        Employee employee = employeeDao.find(uid);
        assertEquals(uid, employee.getUid());
    }

    @Test
    public void printAllEmployes() {
        Map<Integer, Employee> employees = employeeDao.findAll();
        employees.entrySet().forEach(entry -> {
            System.out.println(entry.getValue().getFullname() + " " + entry.getValue().getUid());
        });
    }
}