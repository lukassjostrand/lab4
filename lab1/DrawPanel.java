import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    public HashMap<Car, BufferedImage> carImageMap;
    public HashMap<Workshop<Volvo240>, BufferedImage> workShopImageMap;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Car> cars, ArrayList<Workshop<Volvo240>> shops) {
        this.carImageMap =  new HashMap<>();
        this.workShopImageMap = new HashMap<>();
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.yellow);
    }


    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        carImageMap.forEach((car, image) -> {
            g.drawImage(image, car.getX(), car.getY(), null);
        });

        workShopImageMap.forEach((workshop, image) -> {
            g.drawImage(image, workshop.getX(), workshop.getY(), null);
        });

    }


    public void loadCarImages(ArrayList<Car> cars) {
        carImageMap.clear();


        for (Car car : cars) {
            try{
                BufferedImage image = ImageIO.read(Objects.requireNonNull(CarGame.class.getResourceAsStream("pics/" + car.getModelName() + ".jpg")));
                if (image != null){
                    this.carImageMap.put(car, image);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void loadWorkshopImages(ArrayList<Workshop<Volvo240>> shop) {

        for (Workshop<Volvo240> workshop : shop) {
            try{
                BufferedImage image = ImageIO.read(Objects.requireNonNull(CarGame.class.getResourceAsStream("pics/" + workshop.getName() + ".jpg")));
                if (image != null){
                    this.workShopImageMap.put(workshop, image);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
