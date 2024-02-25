import java.awt.*;

public class CarFactory {

    public Volvo240 createVolvo(int x, int y){
        return new Volvo240(4, 300, Color.BLACK, "Volvo240", 0, x, y);
    }

    public Saab95 createSaab(int x, int y){
        return new Saab95(2, 350, Color.BLUE, "Saab95", 0, x,y );
    }

    public Scania createScania(int x, int y){
        return new Scania(2, 200, Color.BLUE, "Scania",0, x, y);
    }

    public Workshop<Volvo240> createWorkshop(int x, int y){
        return new Workshop<>(10, "VolvoBrand", x, y);
    }

}
