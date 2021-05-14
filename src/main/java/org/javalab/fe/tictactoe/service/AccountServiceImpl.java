package org.javalab.fe.tictactoe.service;

import lombok.extern.slf4j.Slf4j;
import org.javalab.fe.tictactoe.domain.Account;
import org.javalab.fe.tictactoe.dto.AccountDto;
import org.javalab.fe.tictactoe.dto.LoginDto;
import org.javalab.fe.tictactoe.repository.AccountRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.javalab.fe.tictactoe.utils.TicTacToeUtils.getAccountDto;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {
  private final AccountRepository accountRepository;
  private final PasswordEncoder passwordEncoder;

  public AccountServiceImpl(AccountRepository accountRepository,
                            PasswordEncoder passwordEncoder) {
    this.accountRepository = accountRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public AccountDto registerAccount(Account account) {
    return getAccountDto(accountRepository.save(account));
  }

  @Override
  public Optional<AccountDto> userIdentification(LoginDto login) {
    Account account = accountRepository.findByUsername(login.getUsername());
    if (passwordEncoder.matches(login.getPassword(), account.getPassword())) {
      log.info("right password");
      return Optional.of(getAccountDto(account));
    }
    log.info("wrong password");
    return Optional.empty();
  }

  @Override
  public Account loadAccount(Long id) {
    return accountRepository.findById(id).orElse(new Account());
  }
}
