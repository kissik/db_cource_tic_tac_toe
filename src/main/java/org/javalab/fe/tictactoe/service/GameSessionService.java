package org.javalab.fe.tictactoe.service;

import org.javalab.fe.tictactoe.domain.GameSession;
import org.javalab.fe.tictactoe.dto.GameDto;

public interface GameSessionService {
  GameDto createGameSession(GameSession newGameSession);
}
