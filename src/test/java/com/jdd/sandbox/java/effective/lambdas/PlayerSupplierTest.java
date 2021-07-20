package com.jdd.sandbox.java.effective.lambdas;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerSupplierTest {

  private PlayerServiceImpl subject;

  @BeforeEach
  public void setUp() {
    subject = new PlayerServiceImpl();
  }

  @Test
  public void getPlayerTest() {
    String expectedResult = "Josh Allen";
    String actualResult = subject.getPlayer().getPlayerName();
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void createRandomPlayerTest() {
    Player testPlayer = subject.createRandomPlayer();
    System.out.println(testPlayer.toString());
    for (char c: testPlayer.getPlayerTeam().toCharArray()) {
      assertTrue(Character.isUpperCase(c));
    }
  }

  @Test
  public void createPlayerTest() {
    Player testPlayer = subject.createRandomPlayer();
    System.out.println(testPlayer.toString());
  }

  @Test
  public void listPlayersTest() {
    subject.listPlayers();
  }
}
