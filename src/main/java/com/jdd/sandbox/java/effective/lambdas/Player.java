package com.jdd.sandbox.java.effective.lambdas;

public class Player implements Comparable<Player> {

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

  @Override
  public int compareTo(Player player) {
    if (this.getPlayerName().compareTo(player.getPlayerName()) == 0) {
      return this.getPlayerNumber().compareTo(player.getPlayerNumber());
    } else {
      return this.getPlayerName().compareTo(player.getPlayerName());
    }
  }
}
