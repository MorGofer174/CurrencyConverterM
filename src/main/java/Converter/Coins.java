package Converter;

public enum Coins {
    ILS,
    USD,
    EUR ;

    public static Coins fromInteger(int x){
        switch (x){ case 1: return ILS;
            case 2 :return USD;
            case 3 : return EUR;}
        return null;
    }
}
