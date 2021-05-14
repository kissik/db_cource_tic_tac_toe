package org.javalab.fe.tictactoe.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.javalab.fe.tictactoe.enums.GameResult;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "game_session")
@JsonIgnoreProperties({"id"})
public class GameSession {
  @EmbeddedId
  private GameSessionId id;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("accountId")
  private Account account;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("gameId")
  private Game game;

  @Enumerated(EnumType.STRING)
  private GameResult result;

  public GameSession(Account account, Game game, GameResult result) {
    this.account = account;
    this.game = game;
    this.result = result;
    this.id = new GameSessionId(account.getId(), game.getId());
  }
}
