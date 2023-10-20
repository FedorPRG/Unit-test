package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import seminars.second.hw.Vehicle;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainHWTest {
    MainHW mainHW;
    @BeforeEach
    void setUp(){
        mainHW = new MainHW();
    }
    @Test
    public void testEvenOddNumberTrue(){
    assertTrue(mainHW.evenOddNumber(4));
    }
    @Test
    public void testEvenOddNumberFalse(){
        assertFalse(mainHW.evenOddNumber(3));
    }
    @Test
    public void testNumberZeroTrue(){
        assertTrue(mainHW.evenOddNumber(0));
    }
    /*------------------------------------*/
    @ParameterizedTest
    @ValueSource(ints={5,24,25,100,101,1000})
    void testNumberOutsideInterval(int n) {
        assertFalse(mainHW.numberInInterval(n));
    }
    @ParameterizedTest
    @ValueSource(ints={26,50,80,99})
    void testNumberInInterval(int n) {
        assertTrue(mainHW.numberInInterval(n));
    }
}
