package org.javalab.fe.tictactoe.repository;

import org.javalab.fe.tictactoe.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
  Account findByUsername(String username);
}
