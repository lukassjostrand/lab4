import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestVolvo240 {

    @Test
    public void assert_volvo_equal_doors(){
        Car Volvo = new Volvo240(4, 100, Color.red, "Volvo240", 0, 1,2);
        assertEquals(4, Volvo.getNrDoors());
    }

    @Test
    public void test_change_in_pos(){
        Car car = new Volvo240(4, 200, Color.blue, "Car", 10, 0, 0);
        car.move();
        System.out.println("Initial Speed: " + car.getCurrentSpeed());
        java.util.List<Integer> coordinateList = new ArrayList<>();
        coordinateList.add(10);
        coordinateList.add(0);
        List<Integer> CarCords = new ArrayList<>();
        CarCords.add(car.getY());
        CarCords.add(car.getX());

        assertEquals(coordinateList, CarCords);
    }

    @Test
    public void test_gas_works(){
        Volvo240 volvo = new Volvo240(4, 100, Color.red, "Volvo240", 0, 0,0);
        volvo.gas(0.5);
        assertEquals(0.5, volvo.getCurrentSpeed(), 0.2); // Litte over due to trimfactor
    }

    @Test
    public void test_brake_works(){
        Volvo240 volvo = new Volvo240(4, 100, Color.red, "Volvo240", 5, 0,0);
        volvo.brake(0.5);
        assertEquals(4.5, volvo.getCurrentSpeed(), 0.2); // Litte over due to trimfactor
    }

    @Test
    public void test_gas_works_normal_car(){
        Car car = new Volvo240(4, 100, Color.red, "Volvo240", 0, 0,0);
        car.startEngine();
        car.gas(0.5);
        assertEquals(0.6, car.getCurrentSpeed(), 0.2); // 0.6 since starting the car makes speed 0.1 plus trimfactor effect
    }

    @Test
    public void test_coordinates_car(){
        Car car = new Volvo240(4, 100, Color.red, "Volvo240", 0, 10,20);
        List<Integer> coordinateList = new ArrayList<>();
        coordinateList.add(car.getX());
        coordinateList.add(car.getY());
        List<Integer> TestCords = new ArrayList<>();
        TestCords.add(10);
        TestCords.add(20);
        assertEquals(TestCords, coordinateList);
    }

    @Test
    public void car_should_not_gas_over_1(){
        Car car = new Volvo240(4, 100, Color.red, "Volvo240", 10, 10,20);
        car.gas(2);
        assertEquals(10, car.getCurrentSpeed(), 0.0001);
        // Should print "Car cannot gas that much"
    }

    @Test
    public void car_should_not_brake_over_1(){
        Car car = new Volvo240(4, 100, Color.red, "Volvo240", 10, 10,20);
        car.brake(2);
        assertEquals(10, car.getCurrentSpeed(), 0.0001);
        // Should print "Car cannot brake that much"
    }

    @Test
    public void car_speed_should_not_exceed_enginePower(){
        Car car = new Volvo240(4, 100, Color.red, "Volvo240", 99.5, 10,20);
        car.gas(0.9);
        assertEquals(100, car.getCurrentSpeed(), 0.0001); // Caps out at 100 because of "min" statement
    }

    @Test
    public void TestLeft(){
        Car car = new Volvo240(4, 100, Color.red, "Volvo240", 0, 10,20);
        car.turnLeft();
        assertEquals(-1, car.getXDirection(), 0.001);
        assertEquals(0, car.getYDirection(), 0.001);// Caps out at 100 because of "min" statement
    }

    @Test
    public void TestRight(){
        Car car = new Volvo240(4, 100, Color.red, "Volvo240", 0, 10,20);
        car.turnRight(); // 90 to 0
        assertEquals(1, car.getXDirection(), 0.001);
        assertEquals(0, car.getYDirection(), 0.001);
    }
}
