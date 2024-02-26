import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class CarGame implements ViewListener{
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



        CarController controller = new CarController(this);

        CarView frame = new CarView("CarSim 1.0", controller, cars, shops);
        Widget widget = new Widget(controller);


        timer = new Timer(delay, new TimerListener(cars, frame, shops));

        timer.start();
    }


    public static void main(String[] args) {
        new CarGame();
    }

    @Override
    public void onTurboOn() {
        cars.forEach(car -> {
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOn();
            }
        });
    }

    @Override
    public void onTurboOff() {
        cars.forEach(car -> {
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOff();
            }
        });
    }

    @Override
    public void onGas(int amount) {
        double gas = ((double) amount)/100;
        cars.forEach(car -> {
            car.gas(gas);
        });
    }

    @Override
    public void onBrake(int amount) {
        double brake = (double) amount / 100;
        cars.forEach(car -> {
            car.brake(brake);
        });
    }


    @Override
    public void onLiftBed() {
        cars.forEach(car -> {
            if (car instanceof Scania){
                ((Scania)car).raiseBed();
            }
        });

    }

    @Override
    public void onLowerBed() {
        cars.forEach(car -> {
            if (car instanceof Scania){
                ((Scania)car).lowerBed();
            }
        });

    }

    @Override
    public void onStartAllCars() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    @Override
    public void onStopAllCars() {
        for (Car car: cars){
            car.stopEngine();
        }
    }
}
