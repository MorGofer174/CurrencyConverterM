package Converter;

import Currencies.Coin;
import Currencies.EUR;
import Currencies.ILS;
import Currencies.USD;

public class CoinFactory {
    public static Coin getCoin (String coinType) {
        if (coinType == null) {
            return null;
        }

        try {
            if (coinType.equalsIgnoreCase(String.valueOf(Coins.ILS))) {
                return new ILS();
            } else if (coinType.equalsIgnoreCase(String.valueOf(Coins.USD))) {
                return new USD();
            } else if (coinType.equalsIgnoreCase(String.valueOf(Coins.EUR))) {
                return new EUR();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

