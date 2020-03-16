package ru.altagroup.timecontrol.dao;

import ru.altagroup.timecontrol.model.User;

import java.util.List;

public interface UserDao {

    public List<User> findAll();

}
