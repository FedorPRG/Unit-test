package seminars.third.tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
   static UserRepository repository;
    @BeforeAll
  static   void setUp(){
        repository = new UserRepository();
    }
    @Test
    void checkAuthenticateUserPositive(){
        String name = "name";
        String password = "password";
User user = new User(name,password, false);
boolean accept = user.authenticate(name, password);
assertTrue(accept);
    }
    @Test
    void checkAuthenticateUserNegative(){
        String name = "name";
        String password = "password";
        String wrongPassword = "wrongPassword";
        User user = new User(name,password, false);
        boolean accept = user.authenticate(name, wrongPassword);
        assertFalse(accept);
    }
    @Test
    void checkRepositoryAddAuthenticatedUserPositive(){
        String name = "name";
        String password = "password";

        User user = new User(name,password, false);
        boolean accept = user.authenticate(name, password);

        int currentCount = repository.data.size();
        repository.addUser(user);

        assertThat(repository.data.size()).isEqualTo(currentCount+1);

        User userInRepository = repository.data.get(repository.data.size()-1);
        assertEquals(user,userInRepository);
    }
    @Test
    void checkRepositoryAddNotAuthenticatedUserNegative(){
        String name = "name";
        String password = "password";

        User user = new User(name,password, false);


        int currentCount = repository.data.size();
        repository.addUser(user);

        assertThat(repository.data.size()).isEqualTo(currentCount);

    }
}