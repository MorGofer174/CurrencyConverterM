package Manager;

import Converter.CoinFactory;
import Converter.Coins;
import Currencies.ICalculate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Manager {
    private static boolean askUser = true;
    public static int uChoice;
    private static double uAmount;
    private static boolean userAmount = true;
    private static double converterResult;
    private static String askUserAgain;
    private static boolean tryAgain = true;
    public static boolean finalAnswer;
    public static ArrayList<Double> results = new ArrayList<>();
    File ConverterFile = new File("C:\\ConverterFile.txt");
    public static FileWriter fileWriter;

    static {
        try {
            fileWriter = new FileWriter("C:\\ConverterFile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void askUser() { // asks user to choose from options
        while (askUser == true)
            try {
                System.out.println("Please choose an option (1/2/3):\n" +
                        "1. Dollars to Shekels\n" +
                        "2. Shekels to Dollars\n" +
                        "3. Shekels to Euros");
                Scanner userChoice = new Scanner(System.in);
                int choice = userChoice.nextInt();
                if (choice == 1 || choice == 2 || choice == 3) {
                    uChoice = choice;
                    break;
                } else {
                    System.out.println("please try again");
                }
            } catch (InputMismatchException e) {
                System.out.println("please try again");
                continue;
        }
    }

    public static void userAmount() { // gets the amount to convert
        while (userAmount = true) {
            try {
                System.out.println("Please enter an amount to convert");
                Scanner userAmount = new Scanner(System.in);
                uAmount = userAmount.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice, please try again");
                continue;
            }
        }
    }

    public static void setCalcResult(Coins uChoice) {  // sends info to calculate and gets the result

        switch (uChoice){
            case ILS -> {
                ICalculate ILS = CoinFactory.getCoin("ILS");
                converterResult = ILS.calculate(uAmount);
                System.out.println(converterResult);
            }
            case USD -> {
                ICalculate USD = CoinFactory.getCoin("USD");
                converterResult = USD.calculate(uAmount);
                System.out.println(converterResult);
            }
            case EUR -> {
                ICalculate EUR = CoinFactory.getCoin("EUR");
                converterResult = EUR.calculate(uAmount);
                System.out.println(converterResult);
            }
        }
        // Daniel -
        // this was my first try and its working(the if's bellow), just thought to implement the Enum,
        // if you can tell me which way is better, it took me a lot of time to come up with the upper one,
        //so i left it also.

//        if (uChoice == 1) {
//            ICalculate ILS = CoinFactory.getCoin("ILS");
//            converterResult = ILS.calculate(uAmount);
//            System.out.println(converterResult);
//        }
//        else if (uChoice == 2) {
//            ICalculate USD = CoinFactory.getCoin("USD");
//            converterResult = USD.calculate(uAmount);
//            System.out.println(converterResult);
//        }
//        else if (uChoice == 3) {
//            ICalculate EUR = CoinFactory.getCoin("EUR");
//            converterResult = EUR.calculate(uAmount);
//            System.out.println(converterResult);
//        }
        results.add(converterResult);
    }

    public static void resultScreen() { // asks if user wants to do another conversion
        System.out.println("would you like to start over? \n" +
                "please enter Y / N");
        while (tryAgain == true) {
            try {
                Scanner userAgain = new Scanner(System.in);
                String askUserAgain = userAgain.nextLine();
                if (askUserAgain.matches("[YyNn]")) {
                    if (askUserAgain.equalsIgnoreCase("y")) {
                        finalAnswer = true;
                    } else if (askUserAgain.equalsIgnoreCase("n")) {
                        finalAnswer = false;
                    }
                    break;
                } else {
                    System.out.println("please enter Y / N");
                }
            } catch (InputMismatchException e) {
                System.out.println("please enter Y / N");
                continue;
            }
        }
    }

    public static void saveToFile() { // saves the result array to file
        try {
            File converterFile = new File("C:\\ConverterFile.txt");
            if (converterFile.createNewFile()) {
                System.out.println("File created: " + converterFile.getName());
            }

        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter("C:\\ConverterFile.txt", true);
            writer.write("\n" + results);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}