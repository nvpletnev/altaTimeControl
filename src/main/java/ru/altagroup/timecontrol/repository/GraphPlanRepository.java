package ru.altagroup.timecontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.altagroup.timecontrol.entity.GraphFact;
import ru.altagroup.timecontrol.entity.GraphPlan;

import java.util.List;

@Repository
public interface GraphPlanRepository extends JpaRepository<GraphPlan, Integer> {

    @Query(value = "SELECT pgid, uid, startdate, enddate, diner_start, diner_end FROM graph_plan " +
            "WHERE startdate BETWEEN current_date - ? and current_date", nativeQuery = true)
    public List<GraphPlan> findGraphPlanByInterval();
}
