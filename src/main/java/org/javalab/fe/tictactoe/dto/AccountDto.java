package org.javalab.fe.tictactoe.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AccountDto {
  private Long id;
  private String username;
  private String email;
//  List<GameDto> gameDtoList;
}
