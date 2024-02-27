import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class CarApp implements ViewListener{
    private Timer timer;
    private final int delay = 50;
    public ArrayList<Car> cars;
    public ArrayList<Workshop<Volvo240>> shops;

    public CarFactory factory;


    public CarApp() {
        this.cars = new ArrayList<>();
        this.shops = new ArrayList<>();
        this.factory = new CarFactory();


        // Create cars/workshops using factory methods
        cars.add(factory.createSaab(0, 100));
        cars.add(factory.createVolvo(0, 200));
        cars.add(factory.createScania(0, 300));

        shops.add(factory.createWorkshop(0, 450));

        CarController controller = new CarController(this);

        CarView frame = new CarView("CarSim 1.0", controller, cars, shops);
        Widget widget = new Widget(controller);

        Timer timer = new Timer(delay, new TimerListener(cars, frame, shops));
        timer.start();
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

    @Override
    public void onAddCar(JComboBox<String> box) {
        String selected = (String) box.getSelectedItem();

        if (cars.size() <= 10){
            if ("Random".equals(selected)) {
                int randomIndex = (int) (Math.random() * 3); // 3 car types
                switch (randomIndex) {
                    case 0:
                        cars.add(factory.createSaab(getRandomX(), getRandomY()));
                        break;
                    case 1:
                        cars.add(factory.createVolvo(getRandomX(), getRandomY()));
                        break;
                    case 2:
                        cars.add(factory.createScania(getRandomX(), getRandomY()));
                        break;
                }
            } else if ("Volvo240".equals(selected)) {
                cars.add(factory.createVolvo(getRandomX(), getRandomY()));
            } else if ("Saab95".equals(selected)) {
                cars.add(factory.createSaab(getRandomX(), getRandomY()));
            } else if ("Scania".equals(selected)) {
                cars.add(factory.createScania(getRandomX(), getRandomY()));
            }
        }else{
            System.out.println("Cant fit more cars");
        }
    }



    @Override
    public void onRemoveCar() {
        System.out.println(cars.size());
        if (cars.isEmpty()){
            System.out.println("Cant delete more cars");
        }else{
            cars.removeLast();
        }
    }


    private int getRandomX() {

        return (int) (Math.random() * (CarView.X) -100);
    }

    private int getRandomY() {
        return (int) (Math.random() * CarView.Y-240);
    }






}
