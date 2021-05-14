package org.javalab.fe.tictactoe.service;

import org.javalab.fe.tictactoe.domain.Game;
import org.javalab.fe.tictactoe.domain.GameSession;
import org.javalab.fe.tictactoe.dto.AccountDto;
import org.javalab.fe.tictactoe.dto.GameDto;
import org.javalab.fe.tictactoe.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.javalab.fe.tictactoe.utils.TicTacToeUtils.getGameDto;

@Service
public class GameServiceImpl implements GameService {

  private final GameRepository gameRepository;

  public GameServiceImpl(GameRepository gameRepository) {
    this.gameRepository = gameRepository;
  }

  @Override
  public GameDto createGame(Game newGame) {
    return getGameDto(gameRepository.save(newGame));
  }

  @Override
  public Game loadGame(Long id) {
    return gameRepository.findById(id).orElse(new Game());
  }
}
