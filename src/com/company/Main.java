package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> num = new ArrayList<String>();
      //  ArrayList <Integer> num1 = new ArrayList<Integer>();
        String min = null, max = null;
        int minLengt = 1000;
        int maxLengt = 0;
        int avg = 0;
        int countrepeat = 0;
        int even = 0;
        int odd = 0;
        Matrix.entryPoint();


        for (int i = 0; i < 5; i++) {

            num.add(reader.readLine());
        }
       //The shortest number

        for (int i = 0; i < num.size(); i++) {
            if (num.get(i).length() < minLengt) {
                minLengt = num.get(i).length();
                min = num.get(i);
            }
        }

        // The longest number

        for (int i = 0; i < num.size() ; i++) {
            if (num.get(i).length() > maxLengt){
                maxLengt = num.get(i).length();
                max = num.get(i);
            }
        }
        System.out.println("Min number " + min + " " + "Min Number length "  +  minLengt );// write your code here
        System.out.println("Max number " + max + " " + "Max Number length "  + maxLengt );

        IncLenSort(num);

        ArrPrintln(num);

        DecLenSort(num);

        ArrPrintln(num);

        avg = getSummLenElement(num, avg);
        // get avg summ all elements
        avg /= num.size();
            System.out.println("This avg" + " " + avg);

        LessThanAvg(num, avg);


        MuchThenAvg(num, avg);


        countrepeat = getCountrepeatMinDiffNumber(num, countrepeat);


        System.out.println("Min diff number " + countrepeat);

        // only even digits

        for (int i = 0; i < num.size() ; i++) {

            for (int j = 0; j < num.get(i).length() - 1; j++) {
                if (num.get(i).charAt(j) % 2 == 0 && num.get(i).charAt(j + 1) % 2 == 0) {
                    even++;
                }
                else odd++;

            }
        }
        System.out.println("Amount of even numbers " + even);
        System.out.println("Amount of odd numbers " + odd);

        // Find the number whose digits go in the strict ascending order.

        for (int i = 0; i < num.size() ; i++) {

            for (int j = 0; j < num.get(i).length() - 1; j++) {
                if (num.get(i).charAt(j) < num.get(i).charAt(j + 1)) {
                    System.out.println("Number whose digits go in the strict ascending order " + " " + num.get(i));
                }

            }

        }
        // number consisting only of different digits.

        for (int i = 0; i < num.size() ; i++) {

            for (int j = 0; j < num.get(i).length() - 1; j++) {
                if (num.get(i).charAt(j) != num.get(i).charAt(j + 1)) {
                    System.out.println("Number consisting only of different digits. " + " " + num.get(i));
                }

            }

        }





    }
    // The number of different numbers is minimal
    private static int getCountrepeatMinDiffNumber(ArrayList<String> num, int countrepeat) {
        for (int i = 0; i < num.size() ; i++) {

            for (int j = 0; j < num.get(i).length() - 1; j++) {
                if (num.get(i).charAt(j) == num.get(i).charAt(j + 1)) {
                    countrepeat++;
                }

            }
        }
        return countrepeat;
    }
           // Array console print
    private static void ArrPrintln(ArrayList<String> num) {
        for (int i = 0; i < num.size(); i++) {
            System.out.println(num.get(i));
        }
    }
        // length much then avg length
    private static void MuchThenAvg(ArrayList<String> num, int avg) {
        for (int i = 0; i < num.size() ; i++) {
            if (num.get(i).length() > avg){
                System.out.println(num.get(i)+ " " + "Length = " + num.get(i).length() + " "  + "Much than avg " + avg);
            }


        }
    }
    // length less then avg length
    private static void LessThanAvg(ArrayList<String> num, int avg) {
        for (int i = 0; i < num.size() ; i++) {
            if (num.get(i).length() < avg){
                System.out.println(num.get(i)+ " " + "Length = " + num.get(i).length() + " " + "Less than avg " + avg);
            }

        }
    }
        // Summa length all elements
    private static int getSummLenElement(ArrayList<String> num, int avg) {
        for (int i = 0; i < num.size() ; i++) {

            avg += num.get(i).length();
        }
        return avg;
    }
        // Sort by decreasing the length of the element
    private static void DecLenSort(ArrayList<String> num) {
        for (int x = 0; x < num.size(); x++) {
            for (int i = 0; i < num.size() - 1; i++) {
                if(num.get(i).length() < num.get(i + 1).length()){
                    String tmp = num.get(i);
                    num.set(i, num.get(i + 1));
                    num.set(i + 1, tmp);
                }

            }
        }
    }
        // Sort by increasing the length of the element
    private static void IncLenSort(ArrayList<String> num) {
        for (int x = 0; x < num.size(); x++) {
            for (int i = 0; i < num.size() - 1; i++) {
                if(num.get(i).length() > num.get(i + 1).length()){
                    String tmp = num.get(i);
                    num.set(i, num.get(i + 1));
                    num.set(i + 1, tmp);
                }

            }
        }
    }
}
