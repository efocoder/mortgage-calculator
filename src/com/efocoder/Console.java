package com.efocoder;

import java.util.Scanner;

public class Console {

    private  static final Scanner scanner = new Scanner(System.in);

    public  static  double readInputNumber(String prompt){
        return  scanner.nextDouble();
    }

    public  static  double readInputNumber(String prompt, double min, double max){
        double value = 0;
        while (true) {
            System.out.print(prompt);
             value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Please enter a number between " + min + " and " +  max);
        }
        return value;
    }
}
