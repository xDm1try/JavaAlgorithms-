package ru.nsu.fit.muraviev.yandexBackend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task4 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int N = input.nextInt();
    int K = input.nextInt();
    int[] array = new int[N];
    for (int i = 0; i < N; i++) {
      array[i] = input.nextInt();
    }
    if (K == 1){
      int count = Arrays.stream(array).sum();
      System.out.println(count);
      Arrays.stream(array).forEach(System.out::print);
    }
    int inventory = 0;
    int currentDay = 0;

  }
}
