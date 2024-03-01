import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;


// Hej
public class CarModel implements ViewListener{

    ArrayList<ModelListener> observerList = new ArrayList<>();

    public HashMap<Car, BufferedImage> carImageMap;
    public HashMap<Workshop<Volvo240>, BufferedImage> workShopImageMap;
    private Timer timer;
    private final int delay = 50;
    public ArrayList<Car> cars;
    public ArrayList<Workshop<Volvo240>> shops;

    public CarFactory factory;


    public CarModel() {
        this.carImageMap =  new HashMap<>();
        this.workShopImageMap = new HashMap<>();

        this.cars = new ArrayList<>();
        this.shops = new ArrayList<>();
        this.factory = new CarFactory();





        // Create cars/workshops using factory methods
        cars.add(factory.createSaab(0, 100));
        cars.add(factory.createVolvo(0, 200));
        cars.add(factory.createScania(0, 300));

        shops.add(factory.createWorkshop(0, 450));

        loadWorkshopImages(shops);
        loadCarImages(cars);

        Timer timer = new Timer(delay, new TimerListener(this));
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

        if (cars.size() <= 9){
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
        if (!cars.isEmpty()) {
            cars.removeFirst();
            notifyObservers();
        }
    }



    private int getRandomX() {
        double panelWidth = 700; // Assuming this is the width of your panel
        int minX = 0; // Minimum X value
        return (int) (Math.random() * (panelWidth)) ;
    }

    private int getRandomY() {
        double panelHeight = 500; // Assuming this is the height of your panel
        int minY = 0; // Minimum Y value
        return (int) (Math.random() * (panelHeight));
    }




    public void loadCarImages(ArrayList<Car> cars) {
        carImageMap.clear();

        for (Car car : cars) {
            try{
                BufferedImage image = ImageIO.read(Objects.requireNonNull(CarApp.class.getResourceAsStream("pics/" + car.getModelName() + ".jpg")));
                if (image != null){
                    carImageMap.put(car, image);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void loadWorkshopImages(ArrayList<Workshop<Volvo240>> shop) {

        for (Workshop<Volvo240> workshop : shops) {
            try{
                BufferedImage image = ImageIO.read(Objects.requireNonNull(CarApp.class.getResourceAsStream("pics/" + workshop.getName() + ".jpg")));
                if (image != null){
                    workShopImageMap.put(workshop, image);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void addObserver(ModelListener observer) {
        observerList.add(observer);
    }
    public void removeObserver(ModelListener observer) {
        observerList.remove(observer);
    }
    public void notifyObservers() {
        for (ModelListener observer : observerList) {
            observer.update();
        }
    }



}
