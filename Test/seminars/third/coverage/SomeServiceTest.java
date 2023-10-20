package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {
   // 3.1.
    SomeService service;
    @BeforeEach
    void setUp(){
        service = new SomeService();
    }
    @ParameterizedTest
    @ValueSource(ints={3,6,9,12})
    void multipleThreeNotFiveReturnsFizz(int n) {
        // assertEquals...
        String actual = service.fizzBuzz(n);

        assertThat(actual).isEqualTo("Fizz");
    }
    @ParameterizedTest
    @ValueSource(ints={5,10,20})
    void multipleFiveNotThreeReturnsBuzz(int n) {
        // assertEquals...
        String actual = service.fizzBuzz(n);

        assertThat(actual).isEqualTo("Buzz");
    }
    @ParameterizedTest
    @ValueSource(ints={15,30,45,60})
    void multipleFiveWithThreeReturnsFizzBuzz(int n) {
        // assertEquals...
        String actual = service.fizzBuzz(n);

        assertThat(actual).isEqualTo("FizzBuzz");
    }
    @ParameterizedTest
    @ValueSource(ints={14,32,46,61})
    void multipleNoFiveWithNoThreeReturnsValue(int n) {
        // assertEquals...
        String actual = service.fizzBuzz(n);

        assertThat(actual).isEqualTo(String.valueOf(n));
    }
    @Test
    void checkEmptyArray(){
        boolean actual = service.firstLast6(new int[] {});

        assertFalse(actual);
    }
    @Test
    void checkWithout6Array(){
        boolean actual = service.firstLast6(new int[] {0,0,0});

        assertFalse(actual);
    }
    @Test
    void checkFirst6Array(){
        boolean actual = service.firstLast6(new int[] {6,0,0});

        assertTrue(actual);
    }
    @Test
    void checkLast6Array(){
        boolean actual = service.firstLast6(new int[] {0,0,6});

        assertTrue(actual);
    }
    @Test
    void checkFirstAndLast6Array(){
        boolean actual = service.firstLast6(new int[] {6,0,6});

        assertTrue(actual);
    }
    @Test
    void checkMiddle6Array(){
        boolean actual = service.firstLast6(new int[] {0,6,0});

        assertFalse(actual);
    }
    @ParameterizedTest
    @CsvSource(value = {"100,50","200,50","1000,20"})
    void chackCalculateDiscountPositive(double purchase, int discount){
double actual = service.calculatingDiscount(purchase,discount);

assertThat(actual).isEqualTo(purchase-purchase*discount/100);
    }

    @ParameterizedTest
    @CsvSource(value = {"-100,50","-200,50","-1000,20"})
    void chackCalculateDiscountWithNegPurchaseNegative(double purchase, int discount){

       Exception exc= assertThrows(IllegalArgumentException.class,
               ()->service.calculatingDiscount(purchase,discount));
       assertEquals(exc.getMessage(),"error");
    }
    @ParameterizedTest
    @CsvSource(value = {"100,-50","200,-50","1000,-20"})
    void chackCalculateDiscountWithNegDiscNegative(double purchase, int discount){

        Exception exc= assertThrows(IllegalArgumentException.class,
                ()->service.calculatingDiscount(purchase,discount));
        assertEquals(exc.getMessage(),"error");
    }
    @ParameterizedTest
    @CsvSource(value = {"100,150","200,150","1000,120"})
    void chackCalculateDiscountWithBigDiscNegative(double purchase, int discount){

        Exception exc= assertThrows(IllegalArgumentException.class,
                ()->service.calculatingDiscount(purchase,discount));
        assertEquals(exc.getMessage(),"error");
    }
    @Test
    void chackSumThreeNumbersPositiveResult(){
int actual = service.calculatingSumThreeNumbers(1,2,3);
        assertThat(actual).isEqualTo(6);
    }
    @Test
    void chackSumThreeNumbersFirst13Result(){
        int actual = service.calculatingSumThreeNumbers(13,2,3);
        assertThat(actual).isEqualTo(5);
    }
    @Test
    void chackSumThreeNumbersSecond13Result(){
        int actual = service.calculatingSumThreeNumbers(1,13,3);
        assertThat(actual).isEqualTo(4);
    }
    @Test
    void chackSumThreeNumbersThird13Result(){
        int actual = service.calculatingSumThreeNumbers(1,2,13);
        assertThat(actual).isEqualTo(3);
    }
    @Test
    void chackSumThreeNumbersFirstAndThird13Result(){
        int actual = service.calculatingSumThreeNumbers(13,2,13);
        assertThat(actual).isEqualTo(2);
    }
    @Test
    void chackSumThreeNumbersAll13Result(){
        int actual = service.calculatingSumThreeNumbers(13,13,13);
        assertThat(actual).isEqualTo(0);
    }
}