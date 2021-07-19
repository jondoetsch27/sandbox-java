package com.jdd.sandbox.java.effective.streams;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
        "Russell Wilson:3:false",
        "Josh Allen:17:true",
        "Kyler Murray:11:false",
        "Trevor Lawrence:16:false"
      })
  public void queryPlayerTest(String playerName, String playerNumber, boolean expectedResult) {
    Player playerInputTarget = new Player(playerName, playerNumber);
    Player[] players =
        new Player[] {
          new Player("Josh Allen", "17"),
          new Player("Kyler Murray", "1"),
          new Player("Justin Herbert", "11"),
          new Player("Matthew Stafford", "9")
        };
    List<Player> playerInputList = Arrays.stream(players).sorted().collect(Collectors.toList());
    boolean actualResult = subject.queryPlayer(playerInputList, playerInputTarget);
    assertEquals(expectedResult, actualResult);
  }
}
