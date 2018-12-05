package one.laux.unittesting.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {

  public static final String DEFAULT_CURRENCY = "EUR";

  /*
   * Used to demonstrate TDD! assert(), fail() etc.
   */


  private static Map<String, Double> currencies = new HashMap<>();

  static {
    currencies.put("USD", 0.9);
    currencies.put("GBP", 0.5);
    currencies.put("DKR", 7.0);
  }

  // public boolean isSupported(String currency)
  // public Double calculateValue(Double euroValue, String currency)

}
