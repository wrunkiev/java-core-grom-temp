package lesson16;

import java.util.Arrays;

public class StringMethods {
    public static void main(String[] args) {
        String test = "someStringExample";

        // метод проверяет строка пустая или нет
        System.out.println(test.isEmpty());
        System.out.println("".isEmpty());

        // метод возвращает длинну стринга
        System.out.println(test.length());

        // метод возвращает символ который находится на конкретной позиции
        System.out.println(test.charAt(2));

        // метод заменяет одну строку на другую
        String res = test.replace("me", "T");
        System.out.println(res);

        System.out.println(test.replaceAll("me", "T"));

        // метод проверяет содержание подстроки в строке
        System.out.println(test);
        System.out.println( test.contains("mes"));

        // метод возвращает массив стрингов
        System.out.println(test);
        String phrase = "Hello there guys";
        System.out.println(Arrays.toString(phrase.split(" ")));

        // метод удаляет пробелы вначале и вконце
        System.out.println(" test a".trim());

        // метод возвращает подстроку от такой-то позиции включительно до такой-то невключительно
        System.out.println(phrase.substring(5));
        System.out.println(phrase.substring(5, 10).trim());

        //метод возвращает строку в верхнем регистре
        System.out.println(test.toUpperCase());

        //метод возвращает строку в нижнем регистре
        System.out.println(test.toLowerCase());

    }
}
