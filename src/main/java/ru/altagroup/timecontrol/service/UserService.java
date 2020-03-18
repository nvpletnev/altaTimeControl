package ru.altagroup.timecontrol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.altagroup.timecontrol.dao.FactWeeklySheduleDaoImpl;
import ru.altagroup.timecontrol.dao.PlanWeeklySheduleDaoImpl;
import ru.altagroup.timecontrol.dao.UserDaoImpl;
import ru.altagroup.timecontrol.model.FactWeeklyShedule;
import ru.altagroup.timecontrol.model.PlanWeeklyShedule;
import ru.altagroup.timecontrol.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class UserService {

    @Autowired
    private UserDaoImpl userDao;

    @Autowired
    private FactWeeklySheduleDaoImpl factSheduleDao;

    @Autowired
    private PlanWeeklySheduleDaoImpl planSheduleDao;

    private List<User> userList;
    private List<FactWeeklyShedule> factWeeklySheduleList;
    private List<PlanWeeklyShedule> planWeeklySheduleList;

    public List<User> findAll() {

        userList = userDao.findAll();
        factWeeklySheduleList = factSheduleDao.findFactWeeklyShedule();
        planWeeklySheduleList = planSheduleDao.findWeeklyPlanShedule();

        for (User user : userList) {
            user.setFactWeeklyShedule(factWeeklySheduleList.stream()
                    .filter(factWeeklyShedule -> factWeeklyShedule.getUid() == user.getUid())
                    .collect(Collectors.toList()));

            user.setPlanWeeklyShedule(planWeeklySheduleList.stream()
                    .filter(planWeeklyShedule -> planWeeklyShedule.getUid() == user.getUid())
                    .collect(Collectors.toList()));

        }
        return userList;
    }

}
