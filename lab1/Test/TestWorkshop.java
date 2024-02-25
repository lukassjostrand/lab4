import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class TestWorkshop {

    @Test
    public void testWorkShopCapacity() {
        Workshop<Saab95> workshop = new Workshop<>(2, "Workshop1", 5, 5);
        Saab95 saab = new Saab95(2, 100, Color.black, "Saab95", 10, 5, 5);

        Saab95 saab1 = new Saab95(2, 100, Color.black, "Saab95", 10, 5, 5);
        Saab95 saab2 = new Saab95(2, 100, Color.black, "Saab95", 10, 5, 5);


        workshop.loadCar(saab);
        workshop.loadCar(saab1);
        workshop.loadCar(saab2); // capacity reached
    }

    @Test
    public void testWorkShopReturnCar() {
        Workshop<Saab95> workshop = new Workshop<>(10, "Workshop1", 5, 5);
        Saab95 saab = new Saab95(2, 100, Color.black, "Saab95", 0, 5, 5);
        Saab95 saab1 = new Saab95(2, 100, Color.black, "Saab95", 0, 5, 5);
        Saab95 saab2 = new Saab95(2, 100, Color.black, "Saab95", 0, 5, 5);

        workshop.loadCar(saab);
        workshop.loadCar(saab1);
        workshop.loadCar(saab2);

        assertEquals(saab, workshop.unloadCar(saab));
    }

    @Test
    public void getWorkShopCoordinates() {

        Workshop<Car> workshop = new Workshop<>(10, "Workshop1", 5, 5);
        assertEquals(5, workshop.getX(), 0.001);
        assertEquals(5, workshop.getY(), 0.001);
    }



    @Test
    public void testGetName(){
        Workshop<Car> workshop = new Workshop<>(2, "Workshop1", 5, 5);
        assertEquals("Workshop1", workshop.getName());
    }

    @Test
    public void testWorkshopType(){

        Workshop<Saab95> workshop = new Workshop<>(2, "Workshop1", 5, 5);
        Saab95 saab = new Saab95(2, 100, Color.black, "Saab95", 10, 5, 5);
        Volvo240 volvo = new Volvo240(2, 100, Color.black, "Volvo240", 3, 7,0);

        workshop.loadCar(saab);


    }
}
