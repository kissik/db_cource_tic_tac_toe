package org.javalab.fe.tictactoe.service;

import org.javalab.fe.tictactoe.domain.Account;
import org.javalab.fe.tictactoe.dto.AccountDto;
import org.javalab.fe.tictactoe.dto.LoginDto;

import java.util.Optional;

public interface AccountService {

  AccountDto registerAccount(Account newAccount);

  Optional<AccountDto> userIdentification(LoginDto login);

  Account loadAccount(Long accountId);
}
