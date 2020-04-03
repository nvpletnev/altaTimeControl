package ru.altagroup.timecontrol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public List<User> getUsersWithSheduleFailure() {
        List<User> result = new ArrayList<>();
        List<GraphFact> factList = graphFactRepository.findGraphFact();
        List<GraphPlan> planList = graphPlanRepository.findGraphPlan();

        for (GraphPlan plan : planList) {
            //если у сотрудника несколько приходов и уходов за день
            if (Collections.frequency(factList, plan) > 1) {
                GraphFact fact = factList.stream()
                        .filter(factTemp -> factTemp.equals(plan))
                        .reduce((fact1, fact2) -> {
                            GraphFact temp = new GraphFact();
                            temp.setStartTime(fact1.getStartTime());
                            temp.setEndTime(fact2.getEndTime());
                            temp.setUid(fact1.getUid());
                            return temp;
                        })
                        .get();
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
        result.sort(Comparator.comparing(User::getFullname));
        return result;
    }

    @Override
    public List<LocalDate> getLastWeek() {
        List<LocalDate> lastWeek = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            LocalDate result = LocalDate.now().minusDays(i);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)){
                lastWeek.add(result);
            }
        }
        return lastWeek;
    }

    private boolean isLate(GraphFact fact, GraphPlan plan) {
        Duration durationFact = Duration.between(fact.getEndTime().toInstant(), fact.getStartTime().toInstant());
        Duration durationPlan = Duration.between(plan.getEndDate().toInstant(), plan.getStartDate().toInstant());
        //вычет обеда
        durationPlan.minusHours(1);
        durationFact.minusHours(1);
        return durationPlan.toMinutes() < durationFact.toMinutes();
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
}
