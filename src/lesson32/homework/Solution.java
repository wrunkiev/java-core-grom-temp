package lesson32.homework;

import java.util.Scanner;

public class Solution {

    private static boolean checkString(String string){
        try {
            if(Integer.parseInt(string) < 100)
                return true;
            else
                return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static void readNumbers(){

        int n = 3;
        boolean isNumber = true;
        int sum = 0;
        int k = 0;

        Scanner scanner = new Scanner(System.in);
        while(n > 0){
            System.out.println("Enter 10 numbers separated by spaces: ");

            String str = scanner.nextLine();

            String[] tempString = str.trim().split(" ");

            for (String s : tempString){
                if(!s.trim().isEmpty() && !checkString(s.trim())){
                    n--;
                    isNumber = false;
                    break;
                }
                k++;
                sum += Integer.parseInt(s.trim());
            }

            if(isNumber )



            System.out.println("Your numbers are wrong. You have " + n + " attempts to try again");

            if(n == 0){
                System.out.println("Your numbers are wrong. Number of attempts exceeded");
                break;
            }

            if(isNumber){
                System.out.println(sum);
                break;
            }

        }
        scanner.close();
    }
}
