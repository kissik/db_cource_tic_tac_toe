package org.javalab.fe.tictactoe.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class GameSessionId implements Serializable {
  @Column(name = "account_id")
  private Long accountId;
  @Column(name = "game_id")
  private Long gameId;
}
