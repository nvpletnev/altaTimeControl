package ru.altagroup.timecontrol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.altagroup.timecontrol.dao.UserDaoImpl;
import ru.altagroup.timecontrol.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class UserService {

    @Autowired
    private UserDaoImpl userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }
}
