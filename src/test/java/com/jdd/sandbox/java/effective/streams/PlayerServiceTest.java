package com.jdd.sandbox.java.effective.streams;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.jdd.sandbox.java.effective.lambdas.Player;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerServiceTest {

  private PlayerService subject;

  @BeforeEach
  public void setUp() {
    subject = new PlayerService();
  }

  @ParameterizedTest
  @CsvSource(
      delimiter = ':',
      value = {
        "Russell Wilson:3:SEA:false",
        "Josh Allen:17:BUF:true",
        "Kyler Murray:11:ARI:false",
        "Trevor Lawrence:16:JAX:false"
      })
  public void queryPlayerTest(
      String playerName, String playerNumber, boolean expectedResult, String playerTeam) {
    Player playerInputTarget = new Player(playerName, playerNumber, playerTeam);
    Player[] players =
        new Player[] {
          new Player("Josh Allen", "17", "BUF"),
          new Player("Kyler Murray", "1", "ARI"),
          new Player("Justin Herbert", "11", "LAC"),
          new Player("Matthew Stafford", "9", "LAR")
        };
    List<Player> playerInputList = Arrays.stream(players).sorted().collect(Collectors.toList());
    boolean actualResult = subject.queryPlayer(playerInputList, playerInputTarget);
    assertEquals(expectedResult, actualResult);
  }

  @ParameterizedTest
  @CsvSource(
      delimiter = ':',
      value = {
        "Josh Allen:17:BUF:BUF:true",
        "Cole Beasley:11:BUF:BUF:true",
        "Kyler Murray:1:ARI:BUF:false",
        "Justin Herbert:11:LAC:LAC:true"
      })
  public void filteredPlayerListTest(
      String playerName,
      String playerNumber,
      String playerTeam,
      String targetTeam,
      boolean expectedResult) {
    Player playerInputTarget = new Player(playerName, playerNumber, playerTeam);
    Player[] players =
        new Player[] {
          new Player("Kyler Murray", "1", "ARI"),
          new Player("Josh Allen", "17", "BUF"),
          new Player("Devin Singletary", "26", "BUF"),
          new Player("Zack Moss", "20", "BUF"),
          new Player("Stefon Diggs", "14", "BUF"),
          new Player("Emmanuel Sanders", "1", "BUF"),
          new Player("Cole Beasley", "11", "BUF"),
          new Player("Dawson Knox", "88", "BUF"),
          new Player("Justin Herbert", "11", "LAC")
        };
    List<Player> playerInputList = Arrays.stream(players).sorted().collect(Collectors.toList());
    List<Player> filteredPlayerList = subject.filteredPlayerList(playerInputList, targetTeam);
    boolean actualResult = filteredPlayerList.contains(playerInputTarget);
    assertEquals(expectedResult, actualResult);
  }
}
