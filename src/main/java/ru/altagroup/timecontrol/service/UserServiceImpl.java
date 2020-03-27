package ru.altagroup.timecontrol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.altagroup.timecontrol.entity.GraphFact;
import ru.altagroup.timecontrol.entity.GraphPlan;
import ru.altagroup.timecontrol.entity.User;
import ru.altagroup.timecontrol.repository.GraphFactRepository;
import ru.altagroup.timecontrol.repository.GraphPlanRepository;
import ru.altagroup.timecontrol.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private GraphFactRepository graphFactRepository;
    private GraphPlanRepository graphPlanRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, GraphFactRepository graphFactRepository, GraphPlanRepository graphPlanRepository) {
        this.userRepository = userRepository;
        this.graphFactRepository = graphFactRepository;
        this.graphPlanRepository = graphPlanRepository;
    }

    @Override
    public List<User> getUsersWithLateness() {
        List<User> result = new ArrayList<>();

        List<User> userList = userRepository.findActiveUsers();
        List<GraphFact> factList = graphFactRepository.findGraphFactByInterval();
        List<GraphPlan> planList = graphPlanRepository.findGraphPlanByInterval();


        return result;
    }
}
