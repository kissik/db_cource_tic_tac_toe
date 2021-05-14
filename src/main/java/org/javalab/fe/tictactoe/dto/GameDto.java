package org.javalab.fe.tictactoe.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
public class GameDto {
  private Long id;
  private Timestamp gameDate;
  private byte[] screen;
  List<AccountDto> accountDtoList;
}
