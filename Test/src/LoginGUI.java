import javax.swing.*;

public class LoginGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame();    //Create new frame
        JPanel panel = new JPanel();    //Create new panel
        JLabel userLabel = new JLabel("Username: ");    //Create new username label
        JTextField userText = new JTextField(20);   //Create new username text field (and set length)
        JLabel passLabel = new JLabel("Password: ");    //Create new password label
        JPasswordField passText = new JPasswordField(20);   //Create new password field (and set length)
        JButton button = new JButton("Login");  //Create login button
        JLabel success = new JLabel("");    //Create successful login label


        //Initial frame and panel setup
        frame.setSize(400,300); //Set default size (pixel values)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //What to do when user closes panel
        frame.setVisible(true); //Make panel visible
        frame.add(panel);
        panel.setLayout(null);  //No value for now


        //Username and password labels and text boxes and login button setup
        userLabel.setBounds(10,20,80,25);   //Set padding of username label (pixel values)
        panel.add(userLabel);   //Add username label to panel

        userText.setBounds(100,20,165,25);  //Set padding of username text field (pixel values)
        panel.add(userText);    //Add username text box to panel

        passLabel.setBounds(10,50,80,25);   //Set padding of password label (pixel values)
        panel.add(passLabel);   //Add password label to panel

        passText.setBounds(100, 50, 165, 25);   //Set padding of password field
        panel.add(passText);    //Add password field to panel

        button.setBounds(10,80,80,25);  //Set padding of login button (pixel values)
        panel.add(button);  //Add button to panel

        //Post login actions setup
        success.setBounds(10,110,300,25);   //Set padding of success label (pixel values)
        panel.add(success); //Add label to panel






    }

}
