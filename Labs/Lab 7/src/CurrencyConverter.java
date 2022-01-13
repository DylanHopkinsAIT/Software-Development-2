interface BaseCurrency {

    void euroToUSD(double value);

    double usdToEuro(double value);

    void yuanToUSD(double value);

    double usdToYuan(double value);

    void gbpToUSD(double value);

    double usdToGBP(double value);

}

public class CurrencyConverter implements BaseCurrency {
    private double usd;

    //USD --> Euro Conversion
    @Override
    public void euroToUSD(double value) {
        usd = value * 1.14762;
    }

    @Override
    public double usdToEuro(double value) {
        return value / 1.14762;
    }

    //USD --> Yuan Conversion
    @Override
    public void yuanToUSD(double value) {
        usd = value * 6.35942;
    }

    @Override
    public double usdToYuan(double value) {
        return value / 6.35942;
    }

    //USD --> GBP Conversion
    @Override
    public void gbpToUSD(double value) {
        usd = value * 1.37463;
    }

    @Override
    public double usdToGBP(double value) {
        return value / 1.37463;
    }

    public static void main(String[] args) {
        CurrencyConverter cc = new CurrencyConverter();

        //USD --> Euro Conversion
        cc.euroToUSD(5);
        System.out.println("Value of 5 Euro to USD: " + cc.usd);
        System.out.println("Value of 5 USD to Euro: " + cc.usdToEuro(5));
        System.out.println();

        //USD --> GBP Conversion
        cc.gbpToUSD(5);
        System.out.println("Value of 5 USD to GBP: " + cc.usd);
        System.out.println("Value of 5 GBP to USD: " + cc.usdToGBP(5));
        System.out.println();

        //USD --> Yuan Conversion
        cc.yuanToUSD(5);
        System.out.println("Value of 5 USD to Yuan: " + cc.usd);
        System.out.println("Value of 5 Yuan to USD: " + cc.usdToYuan(5));
        System.out.println();

    }
}

