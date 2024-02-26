import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of its components.
 **/

public class CarView extends JFrame{

    public static final int X = 800;
    public static final int Y = 800;



    // The controller member

    DrawPanel drawPanel;
    Widget widget;
    ArrayList<JComponent> components;


    // Constructor
    public CarView(String framename, ViewListener viewListener, ArrayList<Car> cars, ArrayList<Workshop<Volvo240>> shops){
        this.drawPanel = new DrawPanel(X, Y-240, cars, shops);
        this.widget = new Widget(viewListener);
        initComponents(framename);
    }



    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        components = widget.returnComponents();


        for (JComponent comp : components){
            if (comp.getLayout() instanceof GridLayout){
                comp.setBackground(Color.red);
                comp.setForeground(Color.black);
                comp.setPreferredSize(new Dimension((X/2)+4, 200));
                this.add(comp);


            }else{
                comp.setBackground(Color.red);
                comp.setForeground(Color.black);
                comp.setPreferredSize(new Dimension(X/5-15,200));
                this.add(comp);
            }
        }






            // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}