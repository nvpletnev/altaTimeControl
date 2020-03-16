package ru.altagroup.timecontrol.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.altagroup.timecontrol.dao.mapper.UserMapper;
import ru.altagroup.timecontrol.model.User;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    private JdbcTemplate template;

    @Autowired
    public UserDaoImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT fullname,tabnum FROM users WHERE islocked IS NULL";
        return template.query(sql, new UserMapper());
    }
}
