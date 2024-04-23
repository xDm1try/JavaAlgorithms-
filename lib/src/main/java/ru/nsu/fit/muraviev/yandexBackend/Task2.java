package ru.nsu.fit.muraviev.yandexBackend;

import java.util.Scanner;

/**
 * Задача распарсить ввод пользователя с возможностью перемещать указатель.
 *
 * TEST 1:
 *  Input:
 *  hellochild
 *  <left><left>helto<left><bspace>l<delete>ochilds<bspace>
 *
 *   Output:
 *   Yes
 *
 * TEST 2:
 *  Input:
 *  hellochild
 *  hellochild<left><left><delete>
 *
 *  Output:
 *  No
 */
public class Task2 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String firstLine = input.next();
    String userInput = input.next();
    String[] words = userInput.split("(?<=\\w)(?=<)|(?=<)|(?<=>)");
    StringBuilder result = new StringBuilder();
    int pointer = 0;
    for (String word : words) {
      if (word.equals("<left>")) {
        pointer -= 1;
        if (pointer < 0) {
          pointer = 0;
        }
        continue;
      }
      if (word.equals("<right>")) {
        pointer += 1;
        if (pointer >= result.length()) {
          pointer = result.length() - 1;
        }
        continue;
      }
      if (word.equals("<bspace>")) {
        if (pointer == 0) {
          continue;
        }
        result.deleteCharAt(pointer--);
        continue;
      }
      if (word.equals("<delete>")) {
        if (pointer + 1 == result.length()) {
          continue;
        }
        result.deleteCharAt(pointer + 1);
        continue;
      }
      if (result.length() == pointer + 1 || result.isEmpty()){
        result.append(word);
        pointer = result.length() - 1;
      }else{
        result.insert(pointer + 1, word);
        pointer += word.length();
      }
    }
    if (result.toString().equals(firstLine)){
      System.out.println("Yes");
    }else{
      System.out.println("No");
    }
  }
}
