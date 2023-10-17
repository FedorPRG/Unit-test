package seminars.second.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
Car car;
Motorcycle motorcycle;
@BeforeEach
    void setUp(){
    car = new Car("Dodge","Ram",2010);
    motorcycle = new Motorcycle("Suzuki","KATANA", 2023);
}
    @Test
    void testCarIsInstanceOfVehicle(){
        /*- проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)
         */
    assertTrue(car instanceof Vehicle);
}

    @Test
void testCarHaveFourWheels(){
        /*- проверка того, объект Car создается с 4-мя колесами
         */
    assertEquals(car.getNumWheels(),4);
}

    @Test
    void testMotorcycleHaveTwoWheels(){
        /*- проверка того, объект Motorcycle создается с 2-мя колесами
         */
        assertEquals(motorcycle.getNumWheels(),2);
    }

    @Test
    void testCarSpeedTestDrive(){
        /*- проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
         */
       car.testDrive();
        assertEquals(car.getSpeed(),60);
    }

    @Test
    void testMotorcycleSpeedTestDrive(){
        /*- проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
         */
        motorcycle.testDrive();
        assertEquals(motorcycle.getSpeed(),75);
    }

    @Test
    void testCarSpeedPark(){
        /*- проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта)
         машина останавливается (speed = 0)
         */
        car.testDrive();
        car.park();
        assertEquals(car.getSpeed(),0);
    }

    @Test
    void testMotorcycSpeedPark(){
        /*- проверить, что в режиме парковки (сначала testDrive, потом park  т.е эмуляция движения транспорта)
         мотоцикл останавливается (speed = 0)
         */
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(motorcycle.getSpeed(),0);
    }

}