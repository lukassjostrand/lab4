public abstract class Platform {
    public boolean active;

    Platform(boolean active){
        this.active = active;
    }


    public abstract void lowerPlatform();

    public abstract void raisePlatform();


}
