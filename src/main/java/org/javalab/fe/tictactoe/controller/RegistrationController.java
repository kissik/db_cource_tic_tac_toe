package org.javalab.fe.tictactoe.controller;

import lombok.extern.slf4j.Slf4j;
import org.javalab.fe.tictactoe.domain.Account;
import org.javalab.fe.tictactoe.dto.AccountDto;
import org.javalab.fe.tictactoe.dto.LoginDto;
import org.javalab.fe.tictactoe.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@Controller
public class RegistrationController {

  private final AccountService accountService;
  private final PasswordEncoder passwordEncoder;

  public RegistrationController(AccountService accountService,
                                PasswordEncoder passwordEncoder) {
    this.accountService = accountService;
    this.passwordEncoder = passwordEncoder;
  }

  @RequestMapping(value="/registration", produces = {"application/json"},
    consumes = {"application/json"},
    method = RequestMethod.POST)
  public ResponseEntity<AccountDto> registration(@Valid @RequestBody Account newAccount) {
    newAccount.setPassword(passwordEncoder.encode(newAccount.getPassword()));
    return ResponseEntity.ok(accountService.registerAccount(newAccount));
  }

  @RequestMapping(value="/sign-in", produces = {"application/json"},
    consumes = {"application/json"},
    method = RequestMethod.POST)
  public ResponseEntity<AccountDto> signIn(@Valid @RequestBody LoginDto login) {
    Optional<AccountDto> optionalAccountDto = accountService.userIdentification(login);
    if (optionalAccountDto.isPresent()) {
      return ResponseEntity.ok(optionalAccountDto.get());
    }
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
  }
}
