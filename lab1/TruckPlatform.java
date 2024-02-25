import java.awt.*;
public class TruckPlatform extends Platform{

    private double maxAngle = 70;
    private final double platformRaiseAngle = 5;
    private double platformAngle;

    public TruckPlatform(int platformAngle, boolean active) {
        super(active);
        this.platformAngle = 0;
    }

    public double getPlatformAngle(){
        return this.platformAngle;
    }


    @Override
    public void lowerPlatform() {
        platformAngle = Math.max(this.platformAngle -= platformRaiseAngle, 0);
    }

    @Override
    public void raisePlatform() {
        platformAngle = Math.min(this.platformAngle += platformRaiseAngle, maxAngle);

    }
}
