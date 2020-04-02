package ru.altagroup.timecontrol.repository;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.altagroup.timecontrol.entity.GraphFact;
import ru.altagroup.timecontrol.entity.GraphPlan;

import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
class GraphFactRepositoryTest {

    @Autowired
    GraphFactRepository graphFactRepository;
    @Autowired
    GraphPlanRepository graphPlanRepository;

    @Test
    public void findGraphFact() {
        List<GraphFact> factList = graphFactRepository.findGraphFact();
        Assertions.assertThat(factList).isNotEmpty();
    }

    @Test
    public void factAndPlanEqualsTest() {
        Integer uid = 295;
        List<GraphFact> factList = graphFactRepository.findGraphFact();
        List<GraphFact> userFacts = factList.stream().filter(gf -> gf.getUid().equals(uid)).collect(Collectors.toList());

        List<GraphPlan> planList = graphPlanRepository.findGraphPlan();
        List<GraphPlan> userPlans = planList.stream().filter(gf -> gf.getUid().equals(uid)).collect(Collectors.toList());

        Assert.assertTrue(userPlans.containsAll(userFacts));
        Assert.assertTrue(userFacts.containsAll(userPlans));
    }
}