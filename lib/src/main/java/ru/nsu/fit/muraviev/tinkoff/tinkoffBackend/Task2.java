package ru.nsu.fit.muraviev.tinkoff.tinkoffBackend;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Дана матрица цифр, необходимо её повернуть на 90 вправо.
 */

public class Task2 {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int N = input.nextInt();
    int M = input.nextInt();

    ArrayList<ArrayList<Integer>> matrix = new ArrayList<>(N);
    for (int i = 0; i < N; i++) {
      ArrayList<Integer> row = new ArrayList<>(M);
      for (int j = 0; j < M; j++) {
        row.add(input.nextInt());
      }
      matrix.add(row);
    }
    for (int j = 0; j < M; j++){
      for (int i = N - 1; i >= 0; i--) {
        System.out.print(matrix.get(i).get(j));
        System.out.print(' ');
      }
      System.out.println();
    }
  }
}
