import java.awt.*;

public class Scania extends Truck {
    protected TruckPlatform platform;

    public Scania(int nrDoors, double enginePower, Color color, String modelName, double currentSpeed, int x, int y) {
        super(nrDoors, enginePower, color, modelName, currentSpeed, x, y);
        this.platform = new TruckPlatform(0, false);
    }

    @Override
    public void raiseBed() {
        if (currentSpeed != 0) {
            System.out.println("Car cannot move when raising platform");
        } else {
            platform.raisePlatform();
        }
    }

    @Override
    public void lowerBed() {
        if (currentSpeed != 0) {
            System.out.println("Car cannot move when lowering platform");
        } else {
            platform.lowerPlatform();
        }
    }


    @Override
    public void move() {
        if (platform.getPlatformAngle() != 0) {
            System.out.println("Can only move when platform angle is zero");
        } else {
            super.move();
        }}

    }





