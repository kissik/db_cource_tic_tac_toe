package org.javalab.fe.tictactoe.service;

import org.javalab.fe.tictactoe.domain.Game;
import org.javalab.fe.tictactoe.domain.GameSession;
import org.javalab.fe.tictactoe.dto.GameDto;
import org.javalab.fe.tictactoe.repository.GameRepository;
import org.javalab.fe.tictactoe.repository.GameSessionRepository;
import org.springframework.stereotype.Service;

import static org.javalab.fe.tictactoe.utils.TicTacToeUtils.getGameDto;

@Service
public class GameSessionServiceImpl implements GameSessionService {
  private final GameRepository gameRepository;
  private final GameSessionRepository gameSessionRepository;

  public GameSessionServiceImpl(GameRepository gameRepository,
                                GameSessionRepository gameSessionRepository) {
    this.gameRepository = gameRepository;
    this.gameSessionRepository = gameSessionRepository;
  }
  public GameDto createGameSession(GameSession newGameSession) {
    GameSession gameSession = gameSessionRepository.save(newGameSession);
    return getGameDto(gameRepository.findById(gameSession.getGame().getId()).orElse(new Game()));
  }
}
