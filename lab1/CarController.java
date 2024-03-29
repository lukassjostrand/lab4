import javax.swing.*;


public class CarController implements ViewListener{
    // member fields:

    CarModel model;

    public CarController(CarModel model){
        this.model = model;
    }


    @Override
    public void onTurboOn() {
        model.onTurboOn();
    }

    @Override
    public void onTurboOff() {
        model.onTurboOff();
    }

    @Override
    public void onGas(int amount) {
        model.onGas(amount);
    }

    @Override
    public void onBrake(int amount) {
        model.onBrake(amount);
    }


    @Override
    public void onLiftBed() {
        model.onLiftBed();
    }

    @Override
    public void onLowerBed() {
        model.onLowerBed();

    }

    @Override
    public void onStartAllCars() {
        model.onStartAllCars();
    }

    @Override
    public void onStopAllCars() {
        model.onStopAllCars();
    }

    @Override
    public void onAddCar(JComboBox<String> box) {
        model.onAddCar(box);
    }

    @Override
    public void onRemoveCar() {
        model.onRemoveCar();
    }


}
