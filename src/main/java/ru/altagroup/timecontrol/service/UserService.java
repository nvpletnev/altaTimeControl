package ru.altagroup.timecontrol.service;

import ru.altagroup.timecontrol.entity.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {

    public List<User> getUsersWithSheduleFailure();
    public List<LocalDate> getLastWeek();
}
