public class CarApp {

    public CarApp(){
        CarModel model = new CarModel();
        CarView frame = new CarView("CarSim 1.0", model);
        CarController cc = new CarController(model);
        Widget jButtonListener = new Widget(cc);

        model.addObserver(frame.drawPanel);

    }
    public static void main(String[] args) {
        new CarApp();
    }
}
