import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Currency_Converter {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Map <String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.75);
        exchangeRates.put("INR", 74.0);

        String baseCurrency = getBaseCurrency(exchangeRates);

        String targetCurrency = getTargetCurrency(exchangeRates);

        System.out.print("\nEnter amount to convert: ");
        double amount = sc.nextDouble();

        double baseToUSD = amount / exchangeRates.get(baseCurrency);
        double convertedAmount = baseToUSD * exchangeRates.get(targetCurrency);

        System.out.printf("\n\nConverted Amount: %.2f %s\n\n", convertedAmount, targetCurrency);
    }

    public static String getBaseCurrency (Map<String, Double> exchangeRates) {
        String baseCurrency;
        do {
            System.out.print("\nEnter base currency (USD, EUR, GBP, INR): ");
            baseCurrency = sc.nextLine().toUpperCase();
            if (!exchangeRates.containsKey(baseCurrency)) {
                System.out.println("\nInvalid base currency. Please try again.");
            }
        } while (!exchangeRates.containsKey(baseCurrency));
        return baseCurrency;
    }

    public static String getTargetCurrency (Map<String, Double> exchangeRates) {
        String targetCurrency;
        do {
            System.out.print("\nEnter target currency (USD, EUR, GBP, INR): ");
            targetCurrency = sc.nextLine().toUpperCase();
            if (!exchangeRates.containsKey(targetCurrency)) {
                System.out.println("\nInvalid target currency. Please try again.");
            }
        } while (!exchangeRates.containsKey(targetCurrency));
        return targetCurrency;
    }
}