package com.jdd.sandbox.java.effective.lambdas;

public class Player {

  private String playerName;
  private String playerNumber;

  public Player(String playerName, String playerNumber) {
    this.playerName = playerName;
    this.playerNumber = playerNumber;
  }

  public String getPlayerName() {
    return playerName;
  }

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  public String getPlayerNumber() {
    return playerNumber;
  }

  public void setPlayerNumber(String playerNumber) {
    this.playerNumber = playerNumber;
  }
}
