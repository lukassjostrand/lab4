import javax.swing.JComboBox;

public interface ViewListener
{
    void onTurboOn();
    void onTurboOff();
    void onGas(int amount);
    void onBrake(int amount);
    void onLiftBed();
    void onLowerBed();
    void onStartAllCars();
    void onStopAllCars();
    void onAddCar(JComboBox<String> comboBox);
    void onRemoveCar();

}
