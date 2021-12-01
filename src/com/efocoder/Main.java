package com.efocoder;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {

         int principal = (int) readInputNumer("Principal: ", 1000, 1_000_000);
         float annualInterestRate = (float) readInputNumer( "Annual Interest Rate: ", 1, 30);
         byte years = (byte) readInputNumer("Period (Years): ", 1, 30);

        printMortgage(principal, annualInterestRate, years);

        printPaymentSchedule(principal, annualInterestRate, years);
    }

    private static void printMortgage(int principal, float annualInterestRate, byte years) {
        double mortgage = calculateMortgage(principal, annualInterestRate, years);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("---------");
        System.out.println("Monthly Payments: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }

    private static void printPaymentSchedule(int principal, float annualInterestRate, byte years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("-----------------");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++){
            double balance = calculateBalance(principal, annualInterestRate, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public  static  double readInputNumer(String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in);
        float value = 0;
        while (true) {
            System.out.print(prompt);
             value = scanner.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.println("Please enter a number between " + min + " and " +  max);
        }

        return value;
    }

    public static  double calculateBalance(int principal, float annualInterestRate, byte years, short numberOfpaymentMade){


        float monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayment = (short) (years * MONTHS_IN_YEAR);

        double balance = principal *  (Math.pow(1 + monthlyInterestRate, numberOfPayment ) - Math.pow(1 + monthlyInterestRate, numberOfpaymentMade))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayment) - 1);

        return balance;
    }

    public static double calculateMortgage(int principal, float annualInterestRate, byte years){
        float monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayment = (short) (years * MONTHS_IN_YEAR);

        return principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayment))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayment) - 1);
    }



}
