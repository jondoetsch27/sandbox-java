package com.jdd.sandbox.java.effective.streams;

import com.jdd.sandbox.java.effective.lambdas.Player;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayerService {

  public boolean queryPlayer(List<Player> playerList, Player targetPlayer) {
    return playerList.stream()
        .anyMatch(
            player -> {
              return player.getPlayerName().equals(targetPlayer.getPlayerName())
                  && player.getPlayerNumber().equals(targetPlayer.getPlayerNumber());
            });
  }

  public List<Player> filteredPlayerList(List<Player> playerList, String playerTeam) {
    return playerList.stream()
        .filter(
            player -> {
              return player.getPlayerTeam().contains(playerTeam);
            })
        .collect(Collectors.toList());
  }
}
