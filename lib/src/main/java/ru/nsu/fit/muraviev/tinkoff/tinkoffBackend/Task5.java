package ru.nsu.fit.muraviev.tinkoff.tinkoffBackend;

import java.util.Scanner;

/**
 * Дана матрица Nx3, где:
 *  '.' - свободная клетка
 *  'W' - кусты, пройти нельзя
 *  'C' - гриб, +1 балл.
 *
 *  Грибник начинает с верхней строчки с любой её клетки и может перемещаться вниз, по-диагонали
 *
 */

public class Task5 {
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int N = input.nextInt();
    char[][] forest = new char[N][3];
    for(int i = 0; i < N; i++){
      String row = input.next();
      char[] chars = row.toCharArray();
      for(int j = 0; j < 3; j++){
        forest[i][j] = chars[j];
      }
    }
    System.out.println(Task5.findPath(-1, 1, forest, 0));
  }
  public static int findPath(int row, int offset, char[][] forest, int score){
    if (row == forest.length - 1){
      return score;
    }
    int leftStep = 0;
    if (Task5.canStepTo(row+1, offset-1, forest)){
      int newScore = forest[row+1][offset-1] == 'C' ? score + 1 : score;
      leftStep = Task5.findPath(row+1, offset-1, forest, newScore);
    }
    int midStep = 0;
    if (Task5.canStepTo(row+1, offset, forest)){
      int newScore = forest[row+1][offset] == 'C' ? score + 1 : score;
      midStep = Task5.findPath(row+1, offset, forest, newScore);
    }
    int rightStep = 0;
    if (Task5.canStepTo(row+1, offset+1, forest)){
      int newScore = forest[row+1][offset+1] == 'C' ? score + 1 : score;
      rightStep = Task5.findPath(row+1, offset+1, forest, newScore);
    }
    return Math.max(Math.max(leftStep, midStep), Math.max(rightStep, score));
  }
  public static boolean canStepTo(int row, int offset, char[][] forest){
    if ((offset > -1 && offset < 3 && forest[row][offset] != 'W')){
      return true;
    }
    return false;
  }
}
