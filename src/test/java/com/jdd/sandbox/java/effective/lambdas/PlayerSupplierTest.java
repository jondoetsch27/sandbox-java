package com.jdd.sandbox.java.effective.lambdas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerSupplierTest {

  private PlayerService playerService;

  @BeforeEach
  public void setUp() {
    playerService = new PlayerService();
  }

  @Test
  public void getPlayerTest() {
    String expectedResult = "Josh Allen";
    String actualResult = playerService.getPlayer().getPlayerName();
    assertEquals(expectedResult, actualResult);
  }
}
