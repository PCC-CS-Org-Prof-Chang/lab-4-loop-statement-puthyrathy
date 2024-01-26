package edu.pasadena.cs.cs03b;

import java.util.Scanner;

public class Addition {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the base: ");
        int base = input.nextInt();

        System.out.print("Enter the number of digits: ");
        int digits = input.nextInt();

        System.out.print("Enter the first number: ");
        String num1 = input.next();

        System.out.print("Enter the second number: ");
        String num2 = input.next();

        System.out.println("Answer: " + add(base, digits, num1, num2));
    }

    public static String add(int base, int digits, String num1, String num2) {
        //ith digit of num1 and of num2
        char num1_i = '0';
        char num2_i = '0';
        
        //NOTE: the word 'result' denotes the product of a complete addition,
        //whereas 'answer' denotes the part of the product of the addition of
        //two single digit numbers that appears in the answer
        //For example: for the base ten addition 10 + 20,
        //the result is 30; the answer for 0 + 0 is 0; the answer for 1 + 2 is 3.


        //index of answer and of carry within conversionArray (corresponds to decimal values)
        int answerIndex = 0;
        int carryIndex = 0;
        
        //result of addition
        String result = "";

        //iterate through the numbers from smallest to largest digit
        for (int i = digits - 1; i >= 0; --i) {
            //get the ith digits of each number
            num1_i = num1.charAt(i);
            num2_i = num2.charAt(i);
            
            //the decimal value of the answer is the sum of decimal  
            //values of the digits in that place and the carry
            answerIndex = (indexOf(num1_i) + indexOf(num2_i)) + carryIndex;
            
            //if the decimal value of the answer is within the bounds
            //of the base, there is nothing to be carried over
            if (answerIndex < base)
                carryIndex = 0;
            
            //if the decimal value of the answer is beyond the bounds
            //of the base, 
            else {
                //the answer is the remainder of the answer divided by the base
                answerIndex %= base;    
               
                //the decimal value of the carry is the difference between the old value of the
                //decimal value of the answer and its new reduced value, divided by the base
                carryIndex = (indexOf(num1_i) + indexOf(num2_i) + carryIndex - answerIndex) / base;
            }

            //convert the decimal value of the answer to the right base
            //and append it to the result
            result = conversionArray[answerIndex] + result;
        }
        
        //if the addition between the last two digits produces a
        //non-zero carry decimal value, convert it and append to result
        if (carryIndex != 0)
            result = conversionArray[carryIndex] + result;
        
        //add the hexadecimal prefix if necessary
        if (base == 16)
            result = "0x" + result;

        return result;
    }

    static char conversionArray[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static int indexOf(char n) {
        for (int i = 0; i < 16; ++i)
            if (conversionArray[i] == n)
                return i;
        return -1;
    }
}

