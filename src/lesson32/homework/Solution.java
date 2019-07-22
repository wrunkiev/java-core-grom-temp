package lesson32.homework;

import java.util.Scanner;

public class Solution {

    private static boolean validateInputString(String inputString){
        if(inputString == null || inputString. isEmpty()){
            return false;
        }

        String[] tempString = inputString.trim().split(" ");

        int n = 0;
        for (String s : tempString){
            if(!s.trim().isEmpty()){
                for(char c : s.trim().toCharArray()){
                    if(!Character.isDigit(c)){
                        return false;
                    }
                }
                if(Integer.parseInt(s.trim()) > 100){
                    return false;
                }
                n++;
            }
        }

        if(n != 10){
            return false;
        }

        return true;
    }

    public static void readNumbers(){

        int n = 3;
        int sum = 0;

        Scanner scanner = new Scanner(System.in);
        while(n > 0){
            System.out.println("Enter 10 numbers separated by spaces: ");

            String str = scanner.nextLine();

            if(n == 0){
                System.out.println("Your numbers are wrong. Number of attempts exceeded");
                break;
            }

            if(!validateInputString(str)){
                n--;
                System.out.println("Your numbers are wrong. You have " + n + " attempts to try again");
                continue;
            }

            String[] tempString = str.trim().split(" ");

            for (String s : tempString){
                if(!s.trim().isEmpty()){
                    sum += Integer.parseInt(s.trim());
                }
            }
            break;
        }

        System.out.println("Sum of numbers: " + sum);
        scanner.close();
    }
}
