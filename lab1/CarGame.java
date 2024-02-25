import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class CarGame{
    private Timer timer;
    private final int delay = 50;


    public ArrayList<Car> cars;
    public ArrayList<Workshop<Volvo240>> shops;

    // The frame that represents this instance View of the MVC pattern
    // A list of cars, modify if needed
    public CarGame(){
        this.cars = new ArrayList<>();
        this.shops = new ArrayList<>();

        CarFactory factory = new CarFactory();

        // Create cars/workshops using factory methods
        cars.add(factory.createSaab(0, 100));
        cars.add(factory.createVolvo(0, 200));
        cars.add(factory.createScania(0, 300));

        shops.add(factory.createWorkshop(0, 450));



        CarController controller = new CarController(cars);

        CarView frame = new CarView("CarSim 1.0",controller, cars, shops);


        timer = new Timer(delay, new TimerListener(cars, frame, shops));

        timer.start();
    }


    public static void main(String[] args) {
        new CarGame();
    }

}
