package Currencies;

public class EUR extends Coin {

    final double value = 4.23;

    @Override
    protected double getValue() {
        return value;
    }

    @Override
    public double calculate(double num) {
        return num / getValue();
    }
}
