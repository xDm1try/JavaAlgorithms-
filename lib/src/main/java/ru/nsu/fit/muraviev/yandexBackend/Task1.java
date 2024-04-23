package ru.nsu.fit.muraviev.yandexBackend;

import java.util.Scanner;

/**
 * Задача на проверку наличия в строке заглавной, прописной буквы и цифры.
 *
 */

public class Task1 {
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    String name = input.next();
    int size = name.length();
    if(size < 8){
      System.out.println("NO");
      return;
    }
    boolean hasDigit = false;
    boolean hasUpperLetter = false;
    boolean hasLetter = false;
    int i = 0;
    while (i < size){
      char c = name.charAt(i);
      if(Character.isDigit(c)){
        hasDigit = true;
      }
      if (Character.isLowerCase(c)){
        hasLetter = true;
      }
      if (Character.isUpperCase(c)){
        hasUpperLetter = true;
      }
      if(hasLetter && hasDigit && hasUpperLetter){
        System.out.println("YES");
        return;
      }
      i++;
    }
    System.out.println("NO");
  }
}
