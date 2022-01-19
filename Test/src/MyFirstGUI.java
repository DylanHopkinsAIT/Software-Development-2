import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFirstGUI implements ActionListener {

    //Keep these variables outside GUI constructor so that they are in the scope of other methods
    private int count = 0;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;

    //GUI Constructor
    public MyFirstGUI() {

        frame = new JFrame(); //Create new frame
        panel = new JPanel(); //Create new panel
        label = new JLabel("Number of clicks: "); //Create new label with "Number of clicks: " text
        JButton button = new JButton("Click me! "); //Create new button with "Click me!" text

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30)); //Add border to panel (values are in pixels)
        panel.setLayout(new GridLayout(0, 1)); //Configure grid layout
        panel.add(button);  //Add the button created above to the panel
        panel.add(label);   //Add the label created above to the panel

        button.addActionListener(this);

        frame.add(panel, BorderLayout.CENTER);  //Add Panel to frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Set what happens when frame closes
        frame.setTitle("Test GUI"); //Set title of frame
        frame.pack();   //Set Window to match a certain size
        frame.setVisible(true); //Set window to be visible and in focus
    }

    public static void main(String[] args) {

        new MyFirstGUI(); //Construct new GUI using GUI Constructor

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++; //Increment count when button is clicked
        label.setText("Number of clicks: " + count); //Edit label to update number of clicks
    }
}
