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
        usd = value * 1.14;
    }

    @Override
    public double usdToEuro() {
        return usd / 1.14;
    }


    @Override
    public void gbpToUSD(double value) {
        usd = value / 0.74;
    }

    @Override
    public double usdToGBP() {
        return usd * 0.74;
    }


    @Override
    public void rmbToUSD(double value) {
        usd = value / 6.32;
    }

    @Override
    public double usdToRMB() {
        return usd * 6.32;

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


