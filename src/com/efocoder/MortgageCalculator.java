package com.efocoder;

public class MortgageCalculator {
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;

    private final int principal;
    private final float annualInterestRate;
    private final byte years;

    public MortgageCalculator(int principal, float annualInterestRate, byte years) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
    }

    public  double calculateBalance(short numberOfpaymentMade){

        float monthlyInterestRate = getMonthlyInterestRate();
        short numberOfPayment = getNumberOfPayments();

        return principal *  (Math.pow(1 + monthlyInterestRate, numberOfPayment ) - Math.pow(1 + monthlyInterestRate, numberOfpaymentMade))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayment) - 1);
    }

    public  double calculateMortgage(){
        float monthlyInterestRate = getMonthlyInterestRate();
        short numberOfPayment = getNumberOfPayments();

        return principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayment))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayment) - 1);
    }

    public double[] getRemainingBalance(){
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++)
            balances[month -1] = calculateBalance(month);

        return  balances;
    }


    private short getNumberOfPayments() {
        return (short) (years * MONTHS_IN_YEAR);
    }

    private float getMonthlyInterestRate() {
        return annualInterestRate / PERCENT / MONTHS_IN_YEAR;
    }
}
