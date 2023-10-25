package seminars.five;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.five.number.MaxNumberModule;
import seminars.five.number.RandomNumberModule;
import seminars.five.order.OrderService;
import seminars.five.order.PaymentService;
import seminars.five.user.UserRepository;
import seminars.five.user.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    //5.1.
    List<Integer> randomList;
    @BeforeEach
    void setUp(){
        randomList = Arrays.asList(2,5,9,7,6,1);
    }
@Test
    void maxNumberModuleTest(){
        MaxNumberModule maxNumberModule = new MaxNumberModule();

        int maxValue = maxNumberModule.getMaxValue(randomList);

assertThat(maxValue).isEqualTo(9);
}

@Test
    void rundomNumberModuleTest(){
    RandomNumberModule randomNumbers = new RandomNumberModule();

    randomList = randomNumbers.getList(8);

    assertThat(randomList.size()).isEqualTo(8);

}

@Test
    void maxRandomTest(){
    MaxNumberModule maxNumberModule = new MaxNumberModule();
    RandomNumberModule randomNumbers = new RandomNumberModule();

    randomList = randomNumbers.getList(8);
    int maxValue = maxNumberModule.getMaxValue(randomList);

    assertThat(Collections.max(randomList)).isEqualTo(maxValue);


}

    //5.2.

    @Test
    void userServiceTest(){
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        String userName = userService.getUserName(5);

        assertThat(userName).isEqualTo("User 5");

    }

    //5.3.

    @Test

    void orderServiceTest(){
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService(paymentService);

        boolean result = orderService.placeOrder("ord_15", 15000);

        assertTrue(result);
    }

}