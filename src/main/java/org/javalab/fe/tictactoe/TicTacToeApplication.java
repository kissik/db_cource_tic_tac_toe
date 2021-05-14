package org.javalab.fe.tictactoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TicTacToeApplication {
  private final static int APP_BCRYPT_SALT = 11;
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(
      APP_BCRYPT_SALT
    );
  }
  public static void main(String[] args) {
    SpringApplication.run(TicTacToeApplication.class, args);
  }
}
