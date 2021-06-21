package Converter;

import Manager.Manager;

public class Main {

    CoinFactory coinType = new CoinFactory();
    static Manager manager;

    public static void main(String[] args) {

        System.out.println("Welcome to currency converter"); // intro

        do {
            manager.askUser();
            manager.userAmount();
            manager.setCalcResult(Coins.fromInteger(manager.uChoice));
            manager.resultScreen();
        }
        while (manager.finalAnswer == true);

            System.out.println("Thanks for using our currency converter");
            manager.results.forEach(System.out::print);
            manager.saveToFile();
        }
    }


