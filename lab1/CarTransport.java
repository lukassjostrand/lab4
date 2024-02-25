import java.awt.*;
import java.util.ArrayList;

public class CarTransport extends Truck implements Loadable<Car>{
    private ArrayList<Car> carsLoaded; // private
    private int maxCapacity;

    private CarPlatform platform;


    public CarTransport(int nrDoors, double enginePower, Color color, String modelName, double currentSpeed, int x, int y, int maxCapacity) {
        super(nrDoors, enginePower, color, modelName, currentSpeed, x, y);
        this.maxCapacity = maxCapacity;
        this.carsLoaded = new ArrayList<Car>();

        this.platform = new CarPlatform(false);
    }

    public boolean getPlatformActive(){
        return platform.active;
    }


    @Override
    public void move(){
        if (getPlatformActive()) {
            super.move();
            this.moveCars();

        }else{
            System.out.println("Can not move when platform is lowered");
        }

    }

    public ArrayList<Car> getCarsLoaded() {
        return carsLoaded;
    }

    @Override
    public void loadCar(Car car) {
        if (platform.active) {
            if ((car.getSize() == Size.MEDIUM || car.getSize() == Size.SMALL)) {
                if (maxCapacity > (carsLoaded.size() + 1)){
                    if (Math.abs(car.getX() - this.getX()) < 5  && Math.abs(car.getY() - this.getY()) < 5){
                        carsLoaded.add(car);
                        System.out.println("Car loaded");
                    }else{
                        System.out.println("Car is not close enough");
                    }
                }else{
                    System.out.println("Max Capacity Reached");
                }
            } else {
                System.out.println("Car is too big to be loaded");
            }
        } else {
            System.out.println("Platform is not in the right position");
        }
    }

    @Override
    public Car unloadCar(Car car){
        if (this.getCurrentSpeed() == 0){
            if (!carsLoaded.isEmpty()){
                Car unloaded_car = carsLoaded.removeLast();
                unloaded_car.setX(this.getX()+1);
                unloaded_car.setY(this.getY()+1);
                return unloaded_car;
            }
        }else{
            System.out.println("You need to be still to unload car");
            return null;
        }
        return null;
    }


    public void moveCars(){
        for (Car car : carsLoaded) {
            car.setX(this.getX());
            car.setY(this.getY());
        }
    }


    public void lowerBed(){
        if (currentSpeed != 0){
            System.out.println("Car cannot move when lowering platform");
        }else{
            platform.lowerPlatform();
        }
    }

    public void raiseBed(){
        if (currentSpeed != 0){
            System.out.println("Car cannot move when raising platform");
        }else{
            platform.raisePlatform();
        }
    }
}

