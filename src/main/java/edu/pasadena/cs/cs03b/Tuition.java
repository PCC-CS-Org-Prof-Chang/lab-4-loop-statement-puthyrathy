package edu.pasadena.cs.cs03b;

import java.util.Scanner;

public class Tuition {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the tuition cost: ");
        double tuitionCost = input.nextDouble();

        System.out.print("Enter the annual interest rate (decimal): ");
        double interestRate = input.nextDouble();

        System.out.println("Tuition in ten years is " + futureTuition(tuitionCost, interestRate, 10));
        System.out.println("The four-year tuition in ten years is " + totalTuition(tuitionCost, interestRate, 4, 10));
    }

    public static double totalTuition(double principal, double interestRate, int years, int yearsFromNow) {
        double total = 0;

        for (int y = 0; y < years; ++y)
            total += futureTuition(principal, interestRate, yearsFromNow + y);
        
        return total;
    }

    public static double futureTuition(double principal, double interestRate, int years) {
        return principal * Math.pow(1 + interestRate, years);
    }
}
