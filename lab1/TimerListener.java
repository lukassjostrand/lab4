import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Timer;

import static java.lang.Math.abs;

public class TimerListener implements ActionListener {

    private ArrayList<Workshop<Volvo240>> shops;
    private ArrayList<Car> cars;
    private CarView frame;
    public TimerListener(ArrayList<Car> cars, CarView frame, ArrayList<Workshop<Volvo240>> shops){
        this.shops = shops;
        this.cars = cars;
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        for (Car car : cars){
                check_workshop_collision(car);
                moveit();
            }
        }

    public void moveit() {
        for (Car car : cars){
            double height = frame.drawPanel.carImageMap.get(car).getHeight();
            double width = frame.drawPanel.carImageMap.get(car).getWidth();
            double panelWidth = frame.drawPanel.getWidth();
            double panelHeight = frame.drawPanel.getHeight();

            if (!((car.getX()  < -1 || car.getX() + width   > panelWidth ) || (car.getY()  < -1 || car.getY() + height  > panelHeight ))){
                car.move();
            }else{
                handleCollision(car);
                car.move();
            }
            frame.repaint();
        }
    }

    public void handleCollision(Car car){
        car.stopEngine();
        car.turnLeft();
        car.turnLeft();
        car.startEngine();
    }


    void check_workshop_collision(Car car){

        shops.forEach((workshop) -> {
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
