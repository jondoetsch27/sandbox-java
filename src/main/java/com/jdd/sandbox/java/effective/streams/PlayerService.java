package com.jdd.sandbox.java.effective.streams;

import com.jdd.sandbox.java.effective.lambdas.Player;
import java.util.List;

public class PlayerService {

  public boolean queryPlayer(List<Player> playerList, Player targetPlayer) {
    return playerList.stream()
        .anyMatch(
            player -> {
              return player.getPlayerName().equals(targetPlayer.getPlayerName())
                  && player.getPlayerNumber().equals(targetPlayer.getPlayerNumber());
            });
  }
}
