package Problems.digitalWallet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.get;

public class CurrencyConvertor {
    private static final Map<Currency, BigDecimal> exchangeRates = new HashMap<>();

    static {
        exchangeRates.put(Currency.USD, BigDecimal.ONE);
        exchangeRates.put(Currency.EUR, new BigDecimal("0.85"));
        exchangeRates.put(Currency.INR, new BigDecimal("0.012"));
        exchangeRates.put(Currency.YEN, new BigDecimal("110.0"));
    }

    public static BigDecimal convert(BigDecimal amount, Currency sourceCurrency, Currency targetCurrency){
        BigDecimal sourceExchangeRate = exchangeRates.get(sourceCurrency);
        BigDecimal targetExchangeRate = exchangeRates.get(targetCurrency);
        BigDecimal res = amount.multiply(sourceExchangeRate).divide(targetExchangeRate, RoundingMode.HALF_UP);
        return res;

    }

}