import java.util.ArrayList;


public class CarController implements ViewListener{
    // member fields:
    ArrayList<Car> cars;

    public CarController(ArrayList<Car> cars){
        this.cars = cars;
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
