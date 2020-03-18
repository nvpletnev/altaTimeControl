package ru.altagroup.timecontrol.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.altagroup.timecontrol.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setFullname(resultSet.getString("FULLNAME"));
        user.setUid(resultSet.getInt("UID"));
        return user;
    }
}
