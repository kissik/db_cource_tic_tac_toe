package org.javalab.fe.tictactoe.controller;

import lombok.extern.slf4j.Slf4j;
import org.javalab.fe.tictactoe.domain.Game;
import org.javalab.fe.tictactoe.domain.GameSession;
import org.javalab.fe.tictactoe.dto.GameDto;
import org.javalab.fe.tictactoe.dto.GameSessionDto;
import org.javalab.fe.tictactoe.service.AccountService;
import org.javalab.fe.tictactoe.service.GameService;
import org.javalab.fe.tictactoe.service.GameSessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/session")
public class GameSessionController {
  private final AccountService accountService;
  private final GameService gameService;
  private final GameSessionService gameSessionService;
  public GameSessionController(AccountService accountService,
                               GameService gameService,
                               GameSessionService gameSessionService) {
    this.accountService = accountService;
    this.gameService = gameService;
    this.gameSessionService = gameSessionService;
  }

  @RequestMapping(produces = {"application/json"},
    consumes = {"application/json"},
    method = RequestMethod.POST)
  public ResponseEntity<GameDto> saveGameSession(@Valid @RequestBody GameSessionDto gameSessionDto) {
    GameSession newGameSession = new GameSession(
      accountService.loadAccount(gameSessionDto.getAccountId()),
      gameService.loadGame(gameSessionDto.getGameId()),
      gameSessionDto.getResult());
    return ResponseEntity.ok(gameSessionService.createGameSession(newGameSession));
  }

}
