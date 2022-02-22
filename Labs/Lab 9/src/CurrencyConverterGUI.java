import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverterGUI {

    public CurrencyConverterGUI() {
        String[] currencies = new String[]{"US Dollars (USD)", "Pounds Sterling (GBP)", "Euro (EUR)", "Chinese Yuan (RMB)"};
        CurrencyConverter cc = new CurrencyConverter();

        JFrame frame = new JFrame();   //new frame
        JPanel panel = new JPanel();   //new panel
        JLabel usdLabel = new JLabel(currencies[0]);   //USD value label
        JLabel eurLabel = new JLabel(currencies[2]);   //EUR value label
        JLabel gbpLabel = new JLabel(currencies[1]);   //GBP value label
        JLabel rmbLabel = new JLabel(currencies[3]);   //RMB value label
        JTextField usdField = new JTextField();   //USD value text field
        JTextField eurField = new JTextField();   //EUR value text field
        JTextField gbpField = new JTextField();   //GBP value text field
        JTextField rmbField = new JTextField();   //RBM value text field

        //Initial frame and panel setup
        frame.setSize(400, 400); //Set default size (pixel values)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //What to do when user closes panel
        frame.add(panel);   //Add panel to frame
        frame.setVisible(true); //Make panel visible
        frame.setTitle("Currency Conversion");  //Give panel a title
        panel.setLayout(null);  //No value for now

        //USD Box
        usdLabel.setBounds(125, 20, 140, 25);  //USD Label pixel values
        usdField.setBounds(125, 40, 140, 25);  //USD field pixel values
        usdField.addActionListener(new ActionListener() {
            //Currency conversions to display on UI
            @Override
            public void actionPerformed(ActionEvent e) {
                double val = Double.parseDouble(usdField.getText());
                cc.setUSD(val);

                //Euro conversion
                eurField.setText(String.valueOf(cc.usdToEuro()));

                //GBP Conversion
                gbpField.setText(String.valueOf(cc.usdToGBP()));

                //RMB Conversion
                rmbField.setText(String.valueOf(cc.usdToRMB()));
            }
        });
        panel.add(usdLabel);    //Add label for USD field
        panel.add(usdField);    //Add USD field

        //EUR Box
        eurLabel.setBounds(125, 80, 140, 25);
        eurField.setBounds(125, 100, 140, 25);
        eurField.addActionListener(new ActionListener() {
            //Currency conversions to display on UI
            @Override
            public void actionPerformed(ActionEvent e) {
                double val = Double.parseDouble(eurField.getText());
                cc.euroToUSD(val);

                //USD conversion
                usdField.setText(String.valueOf(cc.getUSD()));

                //GBP Conversion
                gbpField.setText(String.valueOf(cc.usdToGBP()));

                //RMB Conversion
                rmbField.setText(String.valueOf(cc.usdToRMB()));
            }
        });
        panel.add(eurLabel);    //Add euro label for euro field
        panel.add(eurField);    //Add euro field to panel

        //GBP Box
        gbpLabel.setBounds(125, 140, 140, 25);
        gbpField.setBounds(125, 160, 140, 25);
        gbpField.addActionListener(new ActionListener() {
            //Currency conversions to display on UI
            @Override
            public void actionPerformed(ActionEvent e) {
                double val = Double.parseDouble(gbpField.getText());
                cc.gbpToUSD(val);

                //USD conversion
                usdField.setText(String.valueOf(cc.getUSD()));

                //EUR Conversion
                eurField.setText(String.valueOf(cc.usdToEuro()));

                //RMB Conversion
                rmbField.setText(String.valueOf(cc.usdToRMB()));
            }
        });
        panel.add(gbpLabel);    //add label for GBP field
        panel.add(gbpField);    //add GBP field to panel

        //RMB Box
        rmbLabel.setBounds(125, 200, 140, 25);
        rmbField.setBounds(125, 220, 140, 25);
        rmbField.addActionListener(new ActionListener() {
            //Currency conversions to display on UI
            @Override
            public void actionPerformed(ActionEvent e) {
                double val = Double.parseDouble(rmbField.getText());
                cc.rmbToUSD(val);

                //Euro conversion
                eurField.setText(String.valueOf(cc.usdToEuro()));

                //GBP Conversion
                gbpField.setText(String.valueOf(cc.usdToGBP()));

                //USD Conversion
                usdField.setText(String.valueOf(cc.getUSD()));
            }
        });
        panel.add(rmbLabel);    //Add label for RMB field
        panel.add(rmbField);    // Add RMB field
    }

    public static void main(String[] args) {
        new CurrencyConverterGUI();
    }
}

