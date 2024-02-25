import java.util.ArrayList;

public class Workshop<A extends Car> implements Loadable<A> {

    private final int maxLoad;
    private ArrayList<A> loadedCars;
    private int x;
    private int y;
    private String name; // ta bort


    public Workshop(int maxLoad, String name, int x, int y) {
        this.maxLoad = maxLoad;
        this.name = name;
        this.x = x;
        this.y = y;

        this.loadedCars = new ArrayList<A>();
    }


    @Override
    public void loadCar(A car){
        if (loadedCars.size() < maxLoad && Math.abs(car.getX() - this.getX()) < 10  && Math.abs(car.getY() - this.getY()) < 10){
            if (!loadedCars.contains(car)){
                this.loadedCars.add(car);
                car.currentSpeed = 0;
                System.out.println("Car loaded");}else{
                System.out.println("Car already in shop");
            }

            }else{
                System.out.println("Max capacity is reached");
            }
        }


        @Override
    public A unloadCar(A car){
        if (loadedCars.contains(car)){
            loadedCars.remove(car);
            return car;
        }else{
            System.out.println("Car is not in workshop");
        }
        return null;
    }


    public ArrayList<A> getLoadedCars(){
        return loadedCars;
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    public String getName(){
        return this.name;
    }

}
