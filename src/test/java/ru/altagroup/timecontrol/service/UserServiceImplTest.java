package ru.altagroup.timecontrol.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.altagroup.timecontrol.entity.GraphFact;
import ru.altagroup.timecontrol.entity.User;
import ru.altagroup.timecontrol.repository.GraphFactRepository;
import ru.altagroup.timecontrol.repository.UserRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class UserServiceImplTest {

    @Autowired
    GraphFactRepository factRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void getUsers() {
        List<GraphFact> factList = factRepository.findGraphFactByInterval();
        factList.forEach(fact -> System.out.println(fact.getStartDate() + " " + fact.getEndDate()));
    }
}