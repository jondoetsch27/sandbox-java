package com.jdd.sandbox.java.vmware;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RockPaperScissorsTest {

  private RockPaperScissors subject;

  @BeforeEach
  public void setup() {
    subject = new RockPaperScissors();
  }

  @ParameterizedTest
  @CsvSource(
      value = {"rock:rock", "scissors:scissors", "paper:paper"},
      delimiter = ':')
  public void givenDraw_returnDraw(String player1, String player2) {
    String expectedResult = "Draw";
    String actualResult = subject.play(player1, player2);
    assertTrue(actualResult.contains(expectedResult));
  }

  @ParameterizedTest
  @CsvSource(
      value = {"rock:scissors", "scissors:paper", "paper:rock"},
      delimiter = ':')
  public void givenPlayer1Wins_returnPlayer1(String player1, String player2) {
    String expectedResult = "Player 1";
    String actualResult = subject.play(player1, player2);
    assertTrue(actualResult.contains(expectedResult));
  }

  @ParameterizedTest
  @CsvSource(
      value = {"rock:paper", "paper:scissors", "scissors:rock"},
      delimiter = ':')
  public void givenPlayer2Wins_returnPlayer2(String player1, String player2) {
    String expectedResult = "Player 2";
    String actualResult = subject.play(player1, player2);
    assertTrue(actualResult.contains(expectedResult));
  }

  @ParameterizedTest
  @CsvSource(
      value = {"p@p3r:r0c5", "slicedTrees:slicyThings", "boulder:boulder"},
      delimiter = ':')
  public void givenInvalidMoveByBothPlayers_returnInvalidMoveByBothPlayers(
      String player1, String player2) {
    String expectedResult = "Invalid move by both players";
    try {
      String actualResult = subject.play(player1, player2);
    } catch (RuntimeException exception) {
      assertTrue(exception.getMessage().contains(expectedResult));
    }
  }

  @ParameterizedTest
  @CsvSource(
      value = {"p@p3r:rock", "slicedTrees:scissors", "boulder:paper"},
      delimiter = ':')
  public void givenInvalidMoveByPlayer1_returnInvalidMoveByPlayer1(String player1, String player2) {
    String expectedResult = "Invalid move by Player 1";
    try {
      String actualResult = subject.play(player1, player2);
    } catch (RuntimeException exception) {
      assertTrue(exception.getMessage().contains(expectedResult));
    }
  }

  @ParameterizedTest
  @CsvSource(
      value = {
        "paper:CAN YOU SMELL WHAT THE ROCK IS COOKING?",
        "scissors:coldCutTreeSandwich",
        "paper:boulder"
      },
      delimiter = ':')
  public void givenInvalidMoveByPlayer2_returnInvalidMoveByPlayer2(String player1, String player2) {
    String expectedResult = "Invalid move by Player 2";
    try {
      String actualResult = subject.play(player1, player2);
    } catch (RuntimeException exception) {
      assertTrue(exception.getMessage().contains(expectedResult));
    }
  }
}
