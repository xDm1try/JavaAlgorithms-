package ru.nsu.fit.muraviev.tinkoff.tinkoffBackend;

import java.util.Scanner;

public class Task6 {
  // TODO
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int N = input.nextInt();
    char[][] desk = new char[N][N];
    int startX, startY = 0;
    int finishX, finishY = 0;
    for (int i = 0; i < N; i++) {
      String row = input.next();
      char[] chars = row.toCharArray();
      for (int j = 0; j < N; j++) {
        desk[i][j] = chars[j];
        if (desk[i][j] == 'S') {
          startY = i;
          startX = j;
        }
        if (desk[i][j] == 'F') {
          finishY = i;
          finishX = j;
        }
      }
    }
  }

  public static int step(int row, int offset, char[][] desk, int score, char state) {
    char value = desk[row][offset];
    if (value == '.') {
      if (state == 'K') {
        horseMove(row, offset, desk, score, state);
      }
      if (state == 'G') {
        kingMove(row, offset, desk, score, state);
      }
    }
    if (state == 'K' && value == 'k') {
      return -1;
    }
    if (state == 'G' && value == 'g') {
      return -1;
    }
    if (value == 'G') {
      kingMove(row, offset, desk, score, 'G');
    } else if (value == 'K') {
      horseMove(row, offset, desk, score, 'K');
    }
    return -1;
  }

  public static void kingMove(int row, int offset, char[][] desk, int score, char state) {
    if (canStep(row + 1, offset, desk)) {
      step(row + 1, offset, desk, score + 1, state);
    } else if (canStep(row + 1, offset + 1, desk)) {
      step(row + 1, offset + 1, desk, score + 1, state);
    } else if (canStep(row, offset + 1, desk)) {
      step(row, offset + 1, desk, score + 1, state);
    } else if (canStep(row - 1, offset + 1, desk)) {
      step(row - 1, offset + 1, desk, score + 1, state);
    } else if (canStep(row - 1, offset, desk)) {
      step(row - 1, offset, desk, score + 1, state);
    } else if (canStep(row - 1, offset - 1, desk)) {
      step(row - 1, offset - 1, desk, score + 1, state);
    } else if (canStep(row, offset - 1, desk)) {
      step(row, offset - 1, desk, score + 1, state);
    } else if (canStep(row + 1, offset - 1, desk)) {
      step(row + 1, offset - 1, desk, score + 1, state);
    }
  }

  public static void horseMove(int row, int offset, char[][] desk, int score, char state) {
    if (canStep(row + 2, offset + 1, desk)) {
      step(row + 2, offset + 1, desk, score + 1, state);
    } else if (canStep(row + 2, offset - 1, desk)) {
      step(row + 2, offset - 1, desk, score + 1, state);
    } else if (canStep(row - 2, offset + 1, desk)) {
      step(row - 2, offset + 1, desk, score + 1, state);
    } else if (canStep(row - 2, offset - 1, desk)) {
      step(row - 2, offset - 1, desk, score + 1, state);
    } else if (canStep(row + 1, offset + 2, desk)) {
      step(row + 1, offset + 2, desk, score + 1, state);
    } else if (canStep(row - 1, offset + 2, desk)) {
      step(row - 1, offset + 2, desk, score + 1, state);
    } else if (canStep(row + 1, offset - 2, desk)) {
      step(row + 1, offset - 2, desk, score + 1, state);
    } else if (canStep(row - 1, offset - 2, desk)) {
      step(row - 1, offset - 2, desk, score + 1, state);
    }
  }

  public static boolean canStep(int row, int offset, char[][] desk) {
    if (row < 0 || row >= desk.length || offset < 0 || offset >= desk.length) {
      return false;
    }
    return true;
  }
}
