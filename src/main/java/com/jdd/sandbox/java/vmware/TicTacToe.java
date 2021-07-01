package com.jdd.sandbox.java.vmware;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TicTacToe {

  private static final char charO = 'O';
  private static final char charX = 'X';
  private static final char space = ' ';

  private static final int[][] rowSolutions;
  private static final int[][] columnSolutions;
  private static final int[][] diagonalSolutions;
  private static final List<int[][]> allSolutions;

  static {
    rowSolutions = new int[][] {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
    columnSolutions = new int[][] {{0, 3, 6}, {1, 4, 7}, {2, 5, 8}};
    diagonalSolutions = new int[][] {{0, 4, 8}, {2, 4, 6}};
    allSolutions = new ArrayList<int[][]>();
    allSolutions.add(rowSolutions);
    allSolutions.add(columnSolutions);
    allSolutions.add(diagonalSolutions);
  }

  public Integer solve(char[] board) {
    List<Integer> charOPositions = getCharOPositions(board);
    List<Integer> charXPositions = getCharXPositions(board);
    for (int[][] solutionArray : allSolutions) {
      for (int[] solution : solutionArray) {
        if (isSolutionPresent(solution, charOPositions, charXPositions)) {
          throw new RuntimeException("Solution present: " + Arrays.toString(solution));
        }
      }
    }
    for (int[][] solutionArray : allSolutions) {
      for (int[] solution : solutionArray) {
        Integer winningMove = getAvailableSolution(solution, charOPositions, charXPositions);
        if (winningMove != null) {
          return winningMove;
        }
      }
    }
    for (int i = 0; i < board.length; i++) {
      if (board[i] == ' ') {
        return i;
      }
    }
    throw new RuntimeException("Draw - board full");
  }

  private static List<Integer> getCharOPositions(char[] board) {
    List<Integer> charOPositions = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
      if (board[i] == charO) {
        charOPositions.add(i);
      }
    }
    return charOPositions;
  }

  private static List<Integer> getCharXPositions(char[] board) {
    List<Integer> charXPositions = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
      if (board[i] == charX) {
        charXPositions.add(i);
      }
    }
    return charXPositions;
  }

  private static boolean isSolutionPresent(
      int[] solution, List<Integer> charOPositions, List<Integer> charXPositions) {
    return charOPositions.containsAll(Arrays.stream(solution).boxed().collect(Collectors.toList()))
        || charXPositions.containsAll(Arrays.stream(solution).boxed().collect(Collectors.toList()));
  }

  private static Integer getAvailableSolution(
      int[] solution, List<Integer> charOPositions, List<Integer> charXPositions) {
    if (charXPositions.contains(solution[0])
        && charXPositions.contains(solution[1])
        && !charOPositions.contains(solution[2])) {
      return solution[2];
    } else if (charXPositions.contains(solution[0])
        && !charOPositions.contains(solution[1])
        && charXPositions.contains(solution[2])) {
      return solution[1];
    } else if (!charOPositions.contains(solution[0])
        && charXPositions.contains(solution[1])
        && charXPositions.contains(solution[2])) {
      return solution[0];
    } else {
      return null;
    }
  }
}
