package com.jdd.sandbox.java.effective.lambdas;

public class PlayerService {

  private PlayerSupplier playerSupplier;

  public Player getPlayer() {
    PlayerSupplier playerSupplier = () -> {
      return new Player("Josh Allen", "17");
    };
    return playerSupplier.get();
  }
}
