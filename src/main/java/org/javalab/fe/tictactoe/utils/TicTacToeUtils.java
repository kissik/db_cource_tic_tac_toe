package org.javalab.fe.tictactoe.utils;

import org.javalab.fe.tictactoe.domain.Account;
import org.javalab.fe.tictactoe.domain.Game;
import org.javalab.fe.tictactoe.domain.GameSession;
import org.javalab.fe.tictactoe.dto.AccountDto;
import org.javalab.fe.tictactoe.dto.GameDto;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeUtils {
  public static GameDto getGameDto(Game game) {
    GameDto gameDto = GameDto.builder().gameDate(game.getGameDate()).id(game.getId()).screen(game.getScreen()).build();
    List<AccountDto> accountDtoList = new ArrayList<>();
    for (GameSession session : game.getGameSessions()) {
      accountDtoList.add(getAccountDto(session.getAccount()));
    }
    gameDto.setAccountDtoList(accountDtoList);
    return gameDto;
  }

  public static AccountDto getAccountDto(Account account) {
    return AccountDto.builder()
      .id(account.getId())
      .username(account.getUsername())
      .email(account.getEmail())
      .build();
  }

}
