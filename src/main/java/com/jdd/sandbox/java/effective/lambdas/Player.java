package com.jdd.sandbox.java.effective.lambdas;

public class Player implements Comparable<Player> {

  private String playerName;
  private String playerNumber;
  private String playerTeam;

  public Player(String playerName, String playerNumber, String playerTeam) {
    this.playerName = playerName;
    this.playerNumber = playerNumber;
    this.playerTeam = playerTeam;
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

  public String getPlayerTeam() {
    return playerTeam;
  }

  public void setPlayerTeam(String playerTeam) {
    this.playerTeam = playerTeam;
  }

  @Override
  public int compareTo(Player player) {
    if (this.getPlayerName().compareTo(player.getPlayerName()) == 0) {
      return this.getPlayerNumber().compareTo(player.getPlayerNumber());
    } else {
      return this.getPlayerName().compareTo(player.getPlayerName());
    }
  }

  @Override
  public boolean equals(Object object) {
    return object != null
        && object.getClass() == Player.class
        && ((Player) object).getPlayerName().equals(this.getPlayerName())
        && ((Player) object).getPlayerNumber().equals(this.getPlayerNumber());
  }

  @Override
  public int hashCode() {
    int result = 31 * Short.hashCode(Short.parseShort(this.playerName));
    result += 31 * Short.hashCode(Short.parseShort(this.playerNumber));
    return result;
  }

  @Override
  public String toString() {
    return "Player{" +
        "playerName='" + playerName + '\'' +
        ", playerNumber='" + playerNumber + '\'' +
        ", playerTeam='" + playerTeam + '\'' +
        '}';
  }
}
