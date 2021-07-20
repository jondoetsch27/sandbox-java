package com.jdd.sandbox.java.effective.lambdas;

import java.util.Random;

public class PlayerServiceImpl implements PlayerService {

  private PlayerSupplier playerSupplier;
  private UniformSupplier uniformSupplier;
  private static final String[] possibleTeams;
  private static final String[][] possibleNames;

  static {
    possibleTeams =
        new String[] {
          "ARI", "ATL", "BAL", "BUF", "CAR", "CIN", "CHI", "CLE", "DAL", "DEN", "DET", "GBP", "HOU",
          "IND", "JAX", "KCC", "LAC", "LAL", "LVR", "MIA", "MIN", "NEP", "NOS", "NYG", "NYJ", "PHI",
          "PIT", "SEA", "SF4", "TBB", "TEN", "WAS"
        };
    possibleNames =
        new String[][] {
          {"Anthony", "Brian", "James", "Josh", "Matthew", "Sam", "Trevor", "Tyler"},
          {"Allen", "Barber", "Brown", "Jones", "Lawrence", "Michaels", "Roberts", "Smith"}
        };
  }

  @Override
  public Player getPlayer() {
    playerSupplier =
        () -> {
          return new Player("Josh Allen", "17", "BUF");
        };
    return playerSupplier.get();
  }

  @Override
  public Player createRandomPlayer() {
    playerSupplier =
        () -> {
          return new Player("", "", "");
        };
    Player randomPlayer = playerSupplier.get();
    uniformSupplier =
        () -> {
          Random random = new Random();
          return random.nextInt(99);
        };
    randomPlayer.setPlayerNumber(String.valueOf(uniformSupplier.getAsLong()));
    randomPlayer.setPlayerName(
        possibleNames[0][new Random().nextInt(possibleNames[0].length - 1)]
            + " "
            + possibleNames[1][new Random().nextInt(possibleNames[1].length - 1)]);
    randomPlayer.setPlayerTeam(possibleTeams[new Random().nextInt(possibleTeams.length) - 1]);
    return randomPlayer;
  }
}
