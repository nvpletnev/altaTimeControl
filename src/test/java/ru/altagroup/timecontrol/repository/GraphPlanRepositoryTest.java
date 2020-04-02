package ru.altagroup.timecontrol.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.altagroup.timecontrol.entity.GraphPlan;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class GraphPlanRepositoryTest {

    @Autowired
    GraphPlanRepository graphPlanRepository;

    @Test
    void findGraphPlanTest() {
        List<GraphPlan> graphPlan = graphPlanRepository.findGraphPlan();
        Assertions.assertThat(graphPlan).isNotEmpty();
    }
}