package ru.altagroup.timecontrol.repository;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.altagroup.timecontrol.entity.User;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @Test
    public void findActiveUserTest() {
        List<User> userList = repository.findActiveUsers();
        Assertions.assertThat(userList).isNotEmpty();
        Assertions.assertThat(userList).filteredOnNull("isLocked").containsOnlyElementsOf(userList);
    }
}