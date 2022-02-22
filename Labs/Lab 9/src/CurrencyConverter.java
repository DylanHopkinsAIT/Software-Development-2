import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

interface BaseCurrency {

    double getUSD();

    void setUSD(double value);

    void euroToUSD(double value);

    double usdToEuro();

    void gbpToUSD(double value);

    double usdToGBP();

    void rmbToUSD(double value);

    double usdToRMB();

}

public class CurrencyConverter implements BaseCurrency {
    final String[] currencies = {"USD", "EUR", "GBP", "CNY"};
    private double usd = 0.0;

    @Override
    public double getUSD() {
        return usd;
    }

    @Override
    public void setUSD(double value) {
        usd = value;
    }

    @Override
    public void euroToUSD(double value) {
        usd = fromToCurrency(value, 1, 0, "US Dollars");
    }

    @Override
    public double usdToEuro() {
        return fromToCurrency(usd, 0, 1, "Euros");
    }

    @Override
    public void gbpToUSD(double value) {
        usd = fromToCurrency(value, 2, 0, "US Dollars");
    }

    @Override
    public double usdToGBP() {
        return fromToCurrency(usd, 0, 2, "British Pounds");
    }

    @Override
    public void rmbToUSD(double value) {
        usd = fromToCurrency(value, 3, 0, "US Dollars");
    }

    @Override
    public double usdToRMB() {
        return fromToCurrency(usd, 0, 3, "Chinese Yuan Renminbi");
    }

    public double fromToCurrency(double currencyAmt, int currencyIndexFrom, int currencyIndexTo, String currencyName) {
        try {
            //Get base URL with no values
            String url = "https://www.xe.com/currencyconverter/convert/?Amount=%f&From=%s&To=%s";

            //Replace placeholders in URL string with appropriate values
            url = url.replaceFirst("%f", Double.toString(currencyAmt));
            url = url.replaceFirst("%s", currencies[currencyIndexFrom]);
            url = url.replaceFirst("%s", currencies[currencyIndexTo]);

            //Connect to URL with values implemented
            Document doc = Jsoup.connect(url).get();

            //Get all <p> elements from page
            Elements elements = doc.select("p");

            //Loop through all <p> elements in page
            for (Element element : elements) {

                //Get class tag from each element in page
                String classes = element.className();

                //If class tag contains result tag
                if (classes.contains("result__BigRate")) {
                    //Save the result string
                    String finalValue = element.text();

                    //Remove the non number values in string
                    finalValue = finalValue.replace(currencyName, "");

                    //Parse the string as a double, round it to 2 decimal places and return it
                    double convertedAmt = Double.parseDouble(finalValue);
                    return (double) Math.round(convertedAmt * 100) / 100;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void main(String[] args) {
        CurrencyConverter cc = new CurrencyConverter();

        //USD --> Others Conversion
        cc.setUSD(5);
        System.out.println("Value of 5 USD to EUR: " + cc.usdToEuro());
        System.out.println("Value of 5 USD to GBP: " + cc.usdToGBP());
        System.out.println("Value of 5 USD to RMB: " + cc.usdToRMB());
        System.out.println();

        //EUR --> Other Conversion
        cc.euroToUSD(5);
        System.out.println("Value of 5 EUR to USD: " + cc.getUSD());
        System.out.println("Value of 5 EUR to GBP: " + cc.usdToGBP());
        System.out.println("Value of 5 EUR to RMB: " + cc.usdToRMB());
        System.out.println();

        //GBP --> Other Conversion
        cc.gbpToUSD(5);
        System.out.println("Value of 5 GBP to USD: " + cc.getUSD());
        System.out.println("Value of 5 GBP to EUR: " + cc.usdToEuro());
        System.out.println("Value of 5 GBP to RMB: " + cc.usdToRMB());
        System.out.println();

        //RMB --> Other Conversion
        cc.rmbToUSD(5);
        System.out.println("Value of 5 RMB to USD: " + cc.getUSD());
        System.out.println("Value of 5 RMB to EUR: " + cc.usdToEuro());
        System.out.println("Value of 5 RMB to GBP: " + cc.usdToGBP());
        System.out.println();
    }
}


