package com.jdd.sandbox.java.effective.lambdas;

@FunctionalInterface
public interface PlayerSupplier {

  public Player supplyPlayer(int uniformNumberRange);
}
