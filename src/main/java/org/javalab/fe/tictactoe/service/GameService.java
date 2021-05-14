package org.javalab.fe.tictactoe.service;

import org.javalab.fe.tictactoe.domain.Game;
import org.javalab.fe.tictactoe.dto.GameDto;

public interface GameService {
  GameDto createGame(Game newGame);

  Game loadGame(Long id);
}
