package com.jdd.sandbox.java.vmware;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TicTacToeTest {

  private TicTacToe subject;

  @BeforeEach
  public void setup() {
    subject = new TicTacToe();
  }

  @ParameterizedTest
  @ValueSource(strings = {"XX OO    ", "OO   X  X", "OO  X X  "})
  public void givenWinningMoveAtPositionTwo_returnTwo(String boardString) {
    char[] board = boardString.toCharArray();
    Integer expectedResult = 2;
    Integer actualResult = subject.solve(board);
    assertEquals(expectedResult, actualResult);
  }

  @ParameterizedTest
  @ValueSource(strings = {"X O  OX  ", "OO  XX   ", "    XX OO"})
  public void givenWinningMoveAtPositionThree_returnThree(String boardString) {
    char[] board = boardString.toCharArray();
    Integer expectedResult = 3;
    Integer actualResult = subject.solve(board);
    assertEquals(expectedResult, actualResult);
  }

  @ParameterizedTest
  @ValueSource(strings = {" OX   X  ", "XOO     X", "OX O   X "})
  public void givenWinningMoveAtPositionFour_returnFour(String boardString) {
    char[] board = boardString.toCharArray();
    Integer expectedResult = 4;
    Integer actualResult = subject.solve(board);
    assertEquals(expectedResult, actualResult);
  }

  @ParameterizedTest
  @ValueSource(strings = {"OOOXX   X", "OX OX O X", "X O XO  X"})
  public void givenCompletedSolution_throwRuntimeException(String boardString) {
    char[] board = boardString.toCharArray();
    try {
      Integer actualResult = subject.solve(board);
    } catch (RuntimeException exception) {
      assertTrue(exception.getMessage().contains("Solution present: "));
    }
  }

  @ParameterizedTest
  @ValueSource(strings = {"XOXXOXOXO", "OXOOXOXOX", "XOXOOXXXO"})
  public void givenFullBoardDraw_throwRuntimeException(String boardString) {
    char[] board = boardString.toCharArray();
    try {
      Integer actualResult = subject.solve(board);
    } catch (RuntimeException exception) {
      assertTrue(exception.getMessage().contains("Draw"));
    }
  }
}
