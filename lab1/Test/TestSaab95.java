import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class TestSaab95 {

    @Test
    public void assert_saab_equal_doors(){
        Car saab = new Saab95(2, 100, Color.red, "Saab95", 0, 1,2);
        assertEquals(2, saab.getNrDoors());
    }

    @Test
    public void testTurboOnAndOff() {
        Saab95 saab = new Saab95(4, 200, Color.blue, "Saab95", 0, 0, 0);

        // No turbo should give a speedFactor of 2.0
        assertEquals(2.0, saab.speedFactor(), 0.001);

        // Turn on the turbo, should give a higher speed factor
        saab.setTurboOn();
        assertEquals(2.6, saab.speedFactor(), 0.001);

        // Turn off the turbo
        saab.setTurboOff();
        assertEquals(2.0, saab.speedFactor(), 0.001);
    }

    @Test
    public void testChangeColor() {
        Saab95 saab = new Saab95(4, 200, Color.blue, "Saab95", 0, 0, 0);

        // Color bljue
        assertEquals(Color.blue, saab.getColor());
        // Color now black
        saab.setColor(Color.black);
        assertEquals(Color.black, saab.getColor());
    }

    @Test
    public void testCurrentSpeed() {
        Saab95 saab = new Saab95(4, 200, Color.blue, "Saab95", 0, 0, 0);
        saab.startEngine();
        double expectedSpeed = 0.1;
        assertEquals(expectedSpeed, saab.getCurrentSpeed(), 0.1);
    }
}
