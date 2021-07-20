package com.jdd.sandbox.java.effective.lambdas;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class PlayerServiceImpl implements PlayerService {

  private OldPlayerSupplier oldPlayerSupplier;
  private PlayerSupplier playerSupplier;
  private UniformSupplier uniformSupplier;
  private static final Player[] playerList;
  private static final String[] possibleTeams;
  private static final String[][] possibleNames;

  static {
    playerList =
        new Player[] {
          new Player("Josh Allen", "17", "BUF"),
          new Player("Kyler Murray", "1", "ARI"),
          new Player("Patrick Mahomes", "15", "KCC")
        };
    possibleTeams =
        new String[] {
          "ARI", "ATL", "BAL", "BUF", "CAR", "CIN", "CHI", "CLE", "DAL", "DEN", "DET", "GBP", "HOU",
          "IND", "JAX", "KCC", "LAC", "LAR", "LVR", "MIA", "MIN", "NEP", "NOS", "NYG", "NYJ", "PHI",
          "PIT", "SEA", "SF4", "TBB", "TEN", "WAS"
        };
    possibleNames =
        new String[][] {
          new String[] {"Anthony", "Brian", "James", "Josh", "Matthew", "Sam", "Trevor", "Tyler"},
          new String[] {"Allen", "Barber", "Brown", "Jones", "Lawrence", "Michaels", "Roberts", "Smith"}
        };
  }

  @Override
  public Player getPlayer() {
    oldPlayerSupplier =
        () -> {
          return new Player("Josh Allen", "17", "BUF");
        };
    return oldPlayerSupplier.get();
  }

  public Player createRandomPlayer() {
    playerSupplier =
        (uniformRange) -> {
          return new Player(
              (possibleNames[0][new Random().nextInt(possibleNames[0].length - 1)]
                  + " "
                  + possibleNames[1][new Random().nextInt(possibleNames[1].length - 1)]),
              String.valueOf(new Random().nextInt(uniformRange)),
              possibleTeams[new Random().nextInt(possibleTeams.length - 1)]);
        };
    return playerSupplier.supplyPlayer(99);
  }

  public void listPlayers() {
    Arrays.stream(playerList)
        .collect(Collectors.toList())
        .forEach(
            (player) -> {
              System.out.println(player);
            });
  }
}
