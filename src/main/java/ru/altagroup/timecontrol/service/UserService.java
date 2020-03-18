package ru.altagroup.timecontrol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.altagroup.timecontrol.dao.FactSheduleDaoImpl;
import ru.altagroup.timecontrol.dao.PlanSheduleDaoImpl;
import ru.altagroup.timecontrol.dao.UserDaoImpl;
import ru.altagroup.timecontrol.model.User;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserDaoImpl userDao;

    @Autowired
    private FactSheduleDaoImpl factSheduleDao;

    @Autowired
    private PlanSheduleDaoImpl planSheduleDao;

    public List<User> findAll() {
        List<User> userList = userDao.findAll();
        userList.forEach(user -> {
            user.setFactShedule(factSheduleDao.findFactShedule(user.getUid()));
            user.setPlanShedule(planSheduleDao.findPlanShedule(user.getUid()));
        });

        return userList;
    }
}
