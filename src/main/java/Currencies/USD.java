package Currencies;

public class USD extends Coin{

    final double value = 3.52;

    @Override
    protected double getValue() {
        return value;
    }

    @Override
    public double calculate(double num) {
        return num / getValue();
    }
}
