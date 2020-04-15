package ru.altagroup.timecontrol.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.altagroup.timecontrol.entity.GraphFact;
import ru.altagroup.timecontrol.entity.GraphPlan;
import ru.altagroup.timecontrol.entity.User;
import ru.altagroup.timecontrol.repository.GraphFactRepository;
import ru.altagroup.timecontrol.repository.GraphPlanRepository;
import ru.altagroup.timecontrol.repository.UserRepository;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    GraphFactRepository graphFactRepository;

    @Autowired
    GraphPlanRepository graphPlanRepository;

    @Test
    public void getUsersWithSheduleFailureTest() {
        List<User> result = new ArrayList<>();
        List<GraphFact> factList = graphFactRepository.findGraphFact();
        List<GraphPlan> planList = graphPlanRepository.findGraphPlan();

        for (GraphPlan plan : planList) {
            //если у сотрудника несколько приходов и уходов за день
            if (Collections.frequency(factList, plan) > 1) {
                List<GraphFact> tempList = factList.stream()
                        .filter(factTemp -> factTemp.equals(plan))
                        .sorted(Comparator.comparing(GraphFact::getStartTime))
                        .collect(Collectors.toList());
                GraphFact fact = new GraphFact();
                fact.setUid(tempList.get(0).getUid());
                fact.setStartTime(tempList.get(0).getStartTime());
                fact.setEndTime(tempList.get(tempList.size() - 1).getEndTime());
                if (isLate(fact, plan)) {
                    addUserWithLatesToResult(result, fact);
                }
            }
            // если у сотрудника один приход/уход
            else if (factList.contains(plan)) {
                GraphFact fact = factList.get(factList.indexOf(plan));
                if (isLate(fact, plan)) {
                    addUserWithLatesToResult(result, fact);
                }
            }
            // прогулы, если фактическая запись не содержится в плановой
            else {
                User temp = userRepository.findById(plan.getUid()).get();
                if (result.contains(temp)) {
                    result.get(result.indexOf(temp)).getAbsenteeismList().add(plan);
                } else {
                    temp.getAbsenteeismList().add(plan);
                    result.add(temp);
                }
            }
        }
        result.forEach(System.out::println);
        Assertions.assertThat(result).isNotEmpty();
//        User user = new User();
//        user.setFullname("Медведев Александр Владимирович");
//        user.setUid(381);
//        Assertions.assertThat(result).doesNotContain(user);
    }

    private boolean isLate(GraphFact fact, GraphPlan plan) {
        Duration durationFact = Duration.between(fact.getEndTime().toInstant(), fact.getStartTime().toInstant());
        Duration durationPlan = Duration.between(plan.getEndDate().toInstant(), plan.getStartDate().toInstant());
        //вычет обеда
        durationPlan.minusHours(1);
        durationFact.minusHours(1);
        return (fact.getStartTime().after(plan.getStartDate()) || fact.getEndTime().before(plan.getEndDate())) ||
                (durationPlan.toMinutes() < durationFact.toMinutes());
    }

    private void addUserWithLatesToResult(List<User> result, GraphFact fact) {
        User temp = userRepository.findById(fact.getUid()).get();
        if (result.contains(temp)) {
            result.get(result.indexOf(temp)).getLatenessList().add(fact);
        } else {
            temp.getLatenessList().add(fact);
            result.add(temp);
        }
    }

    @Test
    public void getLastWeek() {
        List<LocalDate> lastWeek = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            LocalDate result = LocalDate.now().minusDays(i);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                lastWeek.add(result);
            }
        }
        for (LocalDate localDate : lastWeek) {
            System.out.println(localDate);
        }
    }
}