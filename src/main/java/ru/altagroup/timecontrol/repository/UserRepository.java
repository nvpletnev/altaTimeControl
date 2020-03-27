package ru.altagroup.timecontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.altagroup.timecontrol.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT uid,fullname,islocked from USERS where islocked is null", nativeQuery = true)
    public List<User> findActiveUsers();
}
