import java.awt.*;

public class Volvo240 extends Car{


    protected final static double trimFactor = 1.25;

    public final static Size size = Size.MEDIUM;


    public Volvo240(int nrDoors, double enginePower, Color color, String modelName, double currentSpeed, int x, int y) {
        super(nrDoors, enginePower, color, modelName, currentSpeed, x, y);
    }


    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    protected Size getSize() {
        return size;
    }
}