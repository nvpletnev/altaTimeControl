package ru.altagroup.timecontrol.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.altagroup.timecontrol.model.Employee;

import java.util.HashMap;
import java.util.Map;

@Component
public class EmployeeDao {

    private JdbcTemplate template;

    @Autowired
    public EmployeeDao(JdbcTemplate template) {
        this.template = template;
    }

    public Map<Integer, Employee> findAll() {
        String sql = "SELECT uid, fullname FROM users WHERE islocked is null";
        return template.query(sql, (resultSet) -> {
            Map<Integer, Employee> employeeMap = new HashMap<>();
            while (resultSet.next()) {
                employeeMap.put(resultSet.getInt("UID"), new Employee(resultSet.getInt("UID"),
                        resultSet.getString("FULLNAME")));
            }
            return employeeMap;
        });
    }

    public Employee find(int uid) {
        String sql = "SELECT uid, fullname FROM users WHERE uid=?";
        return template.queryForObject(sql, (resultSet, i) -> new Employee(
                        resultSet.getInt("UID"),
                        resultSet.getString("FULLNAME")),
                uid);

    }

}
