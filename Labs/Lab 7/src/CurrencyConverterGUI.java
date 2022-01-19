import javax.swing.*;

public class CurrencyConverterGUI {

    //Initialize these variables in the scope of the other methods
    private JFrame frame;
    private JPanel panel;
    private JLabel initialValueLabel;
    private JTextField initialValueField;
    private JLabel fromCurrencyLabel;
    private JComboBox fromCurrencyList;
    private JLabel toCurrencyLabel;
    private JComboBox toCurrencyList;
    private JTextArea finalValue;
    private JButton clearFields;
    private JButton calculateConversion;

    public CurrencyConverterGUI(){
        String[] currencies = new String[]{"US Dollars (USD)", "Pounds Sterling (GBP)", "Euro (EUR)","Chinese Yuan (RMB)"};

        frame = new JFrame();   //new frame
        panel = new JPanel();   //new panel
        initialValueLabel = new JLabel("Amount to convert: ");   //initial value label
        initialValueField = new JTextField();   //initial value text field
        fromCurrencyLabel = new JLabel("Convert From: ");   //from currency label
        fromCurrencyList = new JComboBox(currencies); //select currency drop down
        toCurrencyLabel = new JLabel("Convert To: ");   //to currency label
        toCurrencyList = new JComboBox(currencies);   //select currency drop down
        finalValue = new JTextArea(""); //text area to contain final converted value
        clearFields = new JButton("Clear"); //button to clear all fields
        calculateConversion = new JButton("Calculate");//button to calculate conversion

        //Initial frame and panel setup
        frame.setSize(800,600); //Set default size (pixel values)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //What to do when user closes panel
        frame.add(panel);
        frame.setVisible(true); //Make panel visible
        frame.setTitle("Currency Conversion");
        panel.setLayout(null);  //No value for now

        //Initial value box
        initialValueLabel.setBounds(335,20,150,25);
        initialValueField.setBounds(315,40,150,25);
        panel.add(initialValueLabel);
        panel.add(initialValueField);

        //From currency dropdown
        fromCurrencyLabel.setBounds(115, 100,100,25);
        fromCurrencyList.setBounds(250,100,300,25);
        panel.add(fromCurrencyLabel);
        panel.add(fromCurrencyList);

        //To currency dropdown
        toCurrencyLabel.setBounds(115, 160,100,25);
        toCurrencyList.setBounds(250,160,300,25);
        panel.add(toCurrencyLabel);
        panel.add(toCurrencyList);

        //Clear & calculate fields buttons
        clearFields.setBounds(250, 220, 100,25);
        calculateConversion.setBounds(450, 220, 100,25);
        panel.add(clearFields);
        panel.add(calculateConversion);

        //Final value text box
        finalValue.setBounds(250, 320,300, 100);
        panel.add(finalValue);

    }

    public static void main(String[] args) {
        new CurrencyConverterGUI();
    }

}

