import java.awt.*;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel implements ModelListener{

    CarModel model;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarModel model) {
        this.model = model;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.yellow);


    }


    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        model.carImageMap.forEach((car, image) -> {
            g.drawImage(image, car.getX(), car.getY(), null);
        });

        model.workShopImageMap.forEach((workshop, image) -> {
            g.drawImage(image, workshop.getX(), workshop.getY(), null);
        });

    }


    @Override
    public void update() {
        model.loadCarImages(model.cars);
        model.loadWorkshopImages(model.shops);
        this.repaint();
    }
}
