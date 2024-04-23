package ru.nsu.fit.muraviev.tinkoff.tinkoffBackend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Дана последовательность оценок [2 - 5]. Найти подпоследовательность без оценки < 4 и с максимальным количеством 5 длиной = 7.
 * Если такая подпоследовательность существует.
 */

public class Task1 {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int N = input.nextInt();
    ArrayList<ArrayList<Integer>> sequences = new ArrayList<>();
    ArrayList<Integer> currentSequence = null;
    boolean wasBadMark = true;
    for (int i = 0; i < N; i++) {
      Integer mark = input.nextInt();
      if (mark < 4) {
        wasBadMark = true;
      } else {
        if (wasBadMark) {
          currentSequence = new ArrayList<>();
          sequences.add(currentSequence);
          wasBadMark = false;
        }
        currentSequence.add(mark);
      }
    }
    List<ArrayList<Integer>> bigSequences =
        sequences.stream().filter(seq -> seq.size() >= 7).toList();
    if (bigSequences.isEmpty()) {
      System.out.println(-1);
      return;
    }
    int score = 0;
    for (ArrayList<Integer> seq : bigSequences) {
      int res = method(seq, 0, 0, 0);
      score = Math.max(score, method(seq, 0, 0, 0));
    }
    System.out.println(score);
  }

  public static int method(ArrayList<Integer> marks, int i, int j, int score) {
    if (j - i == 7 || j == marks.size()) {
      return score;
    }
    int maxRes = 0;
    int continueWithFive = 0;
    if (marks.get(j) == 4) {
      int continueWithFour = method(marks, i, j + 1, score);
      int newSubsequence = method(marks, j + 1, j + 1, 0);
      maxRes = Math.max(continueWithFour, newSubsequence);
    } else if (marks.get(j) == 5) {
      continueWithFive = method(marks, i, j + 1, score + 1);
    }
    return Math.max(maxRes, continueWithFive);
  }
}
