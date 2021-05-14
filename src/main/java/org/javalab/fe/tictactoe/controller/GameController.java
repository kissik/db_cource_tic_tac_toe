package org.javalab.fe.tictactoe.controller;

import lombok.extern.slf4j.Slf4j;
import org.javalab.fe.tictactoe.domain.Game;
import org.javalab.fe.tictactoe.dto.GameDto;
import org.javalab.fe.tictactoe.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.Instant;

import static org.javalab.fe.tictactoe.utils.TicTacToeUtils.getGameDto;

@Slf4j
@Controller
@RequestMapping("/game")
public class GameController {
  private final GameService gameService;
  public GameController(GameService gameService) {
    this.gameService = gameService;
  }

  @RequestMapping(produces = {"application/json"},
    consumes = {"application/json"},
    method = RequestMethod.POST)
  public ResponseEntity<GameDto> saveGame(@Valid @RequestBody Game newGame) {
    newGame.setGameDate(Timestamp.from(Instant.now()));
    return ResponseEntity.ok(gameService.createGame(newGame));
  }

  @RequestMapping(
    value = "/{id}",
    method = RequestMethod.GET)
  public ResponseEntity<GameDto> getGame(@PathVariable("id") Long id) {
    return ResponseEntity.ok(getGameDto(gameService.loadGame(id)));
  }
}
