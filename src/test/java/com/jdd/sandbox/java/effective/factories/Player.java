package com.jdd.sandbox.java.effective.factories;

public class Player {

  private String playerName;
  private String playerNumber;
  private String playerTeam;

  private Player(String playerName, String playerNumber, String playerTeam) {
    this.playerName = playerName;
    this.playerNumber = playerNumber;
    this.playerTeam = playerTeam;
  }

  public static Player getInstance(String playerName, String playerNumber, String playerTeam) {
    return new Player(playerName, playerNumber, playerTeam);
  }

}
