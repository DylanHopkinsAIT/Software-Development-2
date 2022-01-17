import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.PrintWriter;

public class CurrencyConverterGUI extends JFrame implements ActionListener, WindowListener {


    private Container contentPane = this.getContentPane();

    private JLabel usdLabel = new JLabel("$ US Dollar:"), eurLabel = new JLabel("€ Euro:");

    private JTextField usdArea = new JTextField(10), eurArea = new JTextField(10);

    private double usdValue, eurValue;

    public void CurrencyConvert()
    {
        this.setSize(400,300);
        this.setResizable(true);

        this.setDefaultCloseOperation(HIDE_ON_CLOSE);

        this.addWindowListener(this);

        this.setTitle("Currency Converter");
    }

    public void init()
    {

        contentPane.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.insets = new Insets(0,1,0,1);

        gbc.gridx = 1;
        gbc.gridy = 1;

        contentPane.add(usdLabel, gbc);

        gbc.gridx = 2;

        contentPane.add(eurLabel, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 1;
        gbc.gridy = 2;

        contentPane.add(usdArea, gbc);

        gbc.gridx = 2;

        contentPane.add(eurArea, gbc);

        usdArea.addActionListener(this);

        eurArea.addActionListener(this);

        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        CurrencyConverter cc = new CurrencyConverter();

        if(e.getSource() == usdArea)
        {
            usdValue = Double.parseDouble(usdArea.getText());
            eurValue = cc.usdToEuro(usdValue);
        }
        else{
            eurValue = Double.parseDouble(eurArea.getText());
            usdValue = cc.euroToUSD(eurValue);
        }

        usdArea.setText(""+usdValue);
        eurArea.setText(""+eurValue);

    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Window starts");
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {

    }


    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    public static void main(String[] args) {
        new CurrencyConverterGUI().init();
    }
}