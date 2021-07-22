package com.jdd.sandbox.java.effective.concurrency;

public class Player {

  private String playerFirstName;
  private String playerLastName;
  private String playerNumber;

  public Player(String playerFirstName, String playerLastName, String playerNumber) {
    this.playerFirstName = playerFirstName;
    this.playerLastName = playerLastName;
    this.playerNumber = playerNumber;
  }

  public String getPlayerFirstName() {
    return playerFirstName;
  }

  public void setPlayerFirstName(String playerFirstName) {
    this.playerFirstName = playerFirstName;
  }

  public String getPlayerLastName() {
    return playerLastName;
  }

  public void setPlayerLastName(String playerLastName) {
    this.playerLastName = playerLastName;
  }

  public String getPlayerNumber() {
    return playerNumber;
  }

  public void setPlayerNumber(String playerNumber) {
    this.playerNumber = playerNumber;
  }

  public String toString() {
    return "First Name: "
        + this.playerFirstName
        + "\n"
        + "Last Name: "
        + this.playerLastName
        + "\n"
        + "Number: "
        + this.playerNumber;
  }

  @Override
  public boolean equals(Object object) {
    return object != null
        && object.getClass() == Player.class
        && ((Player) object).getPlayerFirstName().equals(this.getPlayerFirstName())
        && ((Player) object).getPlayerLastName().equals(this.getPlayerLastName())
        && ((Player) object).getPlayerNumber().equals(this.getPlayerNumber());
  }

  @Override
  public int hashCode() {
    int result = 31 * Short.hashCode(Short.parseShort(this.playerFirstName));
    result += 31 * Short.hashCode(Short.parseShort(this.playerLastName));
    result += 31 * Short.hashCode(Short.parseShort(this.playerNumber));
    return result;
  }
}
