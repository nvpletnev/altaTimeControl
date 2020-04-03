package ru.altagroup.timecontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.altagroup.timecontrol.entity.GraphPlan;

import java.util.List;

@Repository
public interface GraphPlanRepository extends JpaRepository<GraphPlan, Integer> {

    @Query(value = "SELECT pgid, p.uid, p.startdate, p.enddate, diner_start, diner_end FROM graph_plan AS p " +
            "JOIN users as u ON p.uid=u.uid " +
            "WHERE p.uid = u.uid " +
            "AND isLocked is null " +
            "AND p.startdate BETWEEN current_date - 7 and current_date", nativeQuery = true)
    List<GraphPlan> findGraphPlan();


}
