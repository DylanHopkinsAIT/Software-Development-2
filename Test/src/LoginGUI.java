import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI implements ActionListener {

    //Create these variables so that they are in the scope of the actionPerformed method
    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passLabel;
    private static JPasswordField passText;
    private static JButton button;
    private static JLabel success;

    public static void main(String[] args) {

        JFrame frame = new JFrame();    //Create new frame
        JPanel panel = new JPanel();    //Create new panel
        userLabel = new JLabel("Username: ");    //Create new username label
        userText = new JTextField(20);   //Create new username text field (and set length)
        passLabel = new JLabel("Password: ");    //Create new password label
        passText = new JPasswordField(20);   //Create new password field (and set length)
        button = new JButton("Login");  //Create login button
        success = new JLabel("");    //Create successful login label


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
        button.addActionListener(new LoginGUI());   //Add Action listener to login button
        panel.add(button);  //Add button to panel

        //Post login actions setup
        success.setBounds(10,110,300,25);   //Set padding of success label (pixel values)
        panel.add(success); //Add label to panel

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = userText.getText();   //Let username string equal text entered by user
        String password = passText.getText();   //Let password text equal text entered by user

        //Compare username and password to predefined values, if matching. Login
        if(username.equals("Bill") && password.equals("hello")){
            success.setText("Login Successful!");
        }
        else{
            success.setText("Incorrect username or password!");
        }

    }
}
