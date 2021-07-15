package com.jdd.sandbox.java.vmware;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RockPaperScissors {

  private static final String drawResult;
  private static final String player1Result;
  private static final String player2Result;
  private static final String[] validMoves;
  private static final String[][] winningMoves;

  static {
    drawResult = "Draw";
    player1Result = "Player 1 wins";
    player2Result = "Player 2 wins";
    validMoves = new String[] {"rock", "paper", "scissors"};
    winningMoves = new String[][] {{"rock", "scissors"}, {"scissors", "paper"}, {"paper", "rock"}};
  }

  public String play(String player1, String player2) {
    if (!Arrays.stream(validMoves).sorted().collect(Collectors.toList()).contains(player1)
        && !Arrays.stream(validMoves).sorted().collect(Collectors.toList()).contains(player2)) {
      throw new RuntimeException("Invalid move by both players");
    } else if (!Arrays.stream(validMoves).sorted().collect(Collectors.toList()).contains(player1)) {
      throw new RuntimeException("Invalid move by Player 1");
    } else if (!Arrays.stream(validMoves).sorted().collect(Collectors.toList()).contains(player2)) {
      throw new RuntimeException("Invalid move by Player 2");
    } else if (player1.equals(player2)) {
      return drawResult;
    }
    for (String[] winningMove : winningMoves) {
      if (player1.equals(winningMove[0]) && player2.equals(winningMove[1])) {
        return player1Result;
      } else if (player2.equals(winningMove[0]) && player1.equals(winningMove[1])) {
        return player2Result;
      }
    }
    throw new RuntimeException();
  }
}
