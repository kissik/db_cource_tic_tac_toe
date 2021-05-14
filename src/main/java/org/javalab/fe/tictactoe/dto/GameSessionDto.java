package org.javalab.fe.tictactoe.dto;

import lombok.Builder;
import lombok.Data;
import org.javalab.fe.tictactoe.enums.GameResult;

@Data
@Builder
public class GameSessionDto {
  private Long accountId;
  private Long gameId;
  private GameResult result;
}
