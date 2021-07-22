package com.jdd.sandbox.java.effective.concurrency;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CallablePlayerTask implements Callable<Player> {

  private static final String[] possibleFirstNames;
  private static final String[] possibleLastNames;

  static {
    possibleFirstNames =
        new String[] {
          "Adam", "Anthony", "Charles", "Casey", "Daniel", "Davante", "Desean", "Frank", "Gary",
          "Hakeem", "Ian", "Jason", "Jerrick", "John", "Julius", "Lesean", "Matthew", "Tom",
        };
    possibleLastNames =
        new String[] {
          "Allen", "Brady", "Carter", "Clayton", "Drummond", "Henry", "Herbert", "Hendrickson",
          "Jefferson", "Matthews", "Reddick", "Roberts", "Smith", "Suggs", "Taylor", "Watt"
        };
  }

  @Override
  public Player call() throws Exception {
    return new Player(
        possibleFirstNames[new Random().nextInt(possibleFirstNames.length - 1)],
        possibleLastNames[new Random().nextInt(possibleLastNames.length - 1)],
        String.valueOf(new Random().nextInt(99))
    );
  }
}
