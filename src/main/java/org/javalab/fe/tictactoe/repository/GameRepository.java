package org.javalab.fe.tictactoe.repository;

import org.javalab.fe.tictactoe.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
