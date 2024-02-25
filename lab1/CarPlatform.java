import java.util.ArrayList;

public class CarPlatform extends Platform{

    public CarPlatform(boolean active){
        super(active);
    }

    @Override
    public void lowerPlatform() {
        active = true;
    }


    @Override
    public void raisePlatform() {
        active = false;
    }



}
