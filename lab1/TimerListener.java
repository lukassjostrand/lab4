import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerListener implements ActionListener{

    private CarModel model;

    private ModelListener modelListener; // Reference to CarViewObserver


    public TimerListener(CarModel model){
        this.model = model;
    }

    public void actionPerformed(ActionEvent e) {
        for (Car car : model.cars){
            model.notifyObservers();
            check_workshop_collision(car);
                moveit();
            }
        }

    public void moveit() {
        for (Car car : model.cars){

            double height = model.carImageMap.get(car).getHeight();
            double width = model.carImageMap.get(car).getWidth();
            double panelWidth = 800;
            double panelHeight = 560;



            if (!((car.getX()  < -1 || car.getX() + width   > panelWidth ) || (car.getY()  < -1 || car.getY() + height  > panelHeight ))){
                check_workshop_collision(car);
                car.move();
            }else{
                handleCollision(car);
                car.move();
            }
        }
    }

    public void handleCollision(Car car){
        car.stopEngine();
        car.turnLeft();
        car.turnLeft();
        car.startEngine();
    }


    void check_workshop_collision(Car car){

        model.shops.forEach((workshop) -> {
            if ((Math.abs(car.getX() - workshop.getX()) < 2 && Math.abs(car.getY() - workshop.getY()) < 2)){
                try{
                    workshop.loadCar((Volvo240) car);
                    car.stopEngine();
                    System.out.println("Car loaded");
                }catch (Exception ex){
                    System.out.println("Car cannot be loaded here");
                }
            }
        });
    }

}
