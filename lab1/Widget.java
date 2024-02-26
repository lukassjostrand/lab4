import javax.swing.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Widget {

    private ViewListener viewListener;

    public ArrayList<JComponent> comps;
    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    public Widget(ViewListener viewListener){
        this.viewListener = viewListener;
        this.comps = new ArrayList<>();

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        controlPanel.add(gasPanel);
        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);

        addComponent(controlPanel);
        addComponent(startButton);
        addComponent(stopButton);



        gasButton.addActionListener(actionEvent -> viewListener.onGas(gasAmount));
        brakeButton.addActionListener(actionEvent -> viewListener.onBrake(gasAmount));
        turboOnButton.addActionListener(actionEvent -> viewListener.onTurboOn());
        turboOffButton.addActionListener(actionEvent -> viewListener.onTurboOff());
        liftBedButton.addActionListener(actionEvent -> viewListener.onLiftBed());
        lowerBedButton.addActionListener(actionEvent -> viewListener.onLowerBed());
        startButton.addActionListener(actionEvent -> viewListener.onStartAllCars());
        stopButton.addActionListener(actionEvent -> viewListener.onStopAllCars());
    }

    public void addComponent(JComponent component){
        this.comps.add(component);
    }

    public ArrayList<JComponent> returnComponents(){
        return this.comps;
    }

}
