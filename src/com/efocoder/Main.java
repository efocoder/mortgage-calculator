package com.efocoder;

public class Main {

    public static void main(String[] args) {

         int principal = (int) Console.readInputNumber("Principal: ", 1000, 1_000_000);
         float annualInterestRate = (float) Console.readInputNumber( "Annual Interest Rate: ", 1, 30);
         byte years = (byte) Console.readInputNumber("Period (Years): ", 1, 30);

         var calculator = new MortgageCalculator(principal, annualInterestRate, years);

         var report = new MortgageReport(calculator);
         report.printMortgage();
         report.printPaymentSchedule();
    }


}
