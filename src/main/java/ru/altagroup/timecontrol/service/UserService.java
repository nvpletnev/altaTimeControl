package ru.altagroup.timecontrol.service;

import ru.altagroup.timecontrol.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getUsersWithSheduleFailure();
}
