package ru.altagroup.timecontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.altagroup.timecontrol.entity.GraphFact;

import java.util.List;

@Repository
public interface GraphFactRepository extends JpaRepository<GraphFact, Integer> {


    @Query(value = "SELECT sfcode, uid, startdate, enddate, starttime, endtime FROM graph_fact " +
            "WHERE startdate BETWEEN current_date - 7  and current_date", nativeQuery = true)
    public List<GraphFact> findGraphFactByInterval();
}
