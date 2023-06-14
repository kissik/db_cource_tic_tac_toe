package org.javalab.fe.tictactoe;

import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.zonky.test.db.AutoConfigureEmbeddedDatabase.DatabaseProvider.ZONKY;
import static io.zonky.test.db.AutoConfigureEmbeddedDatabase.DatabaseType.POSTGRES;

@SpringBootTest
@AutoConfigureEmbeddedDatabase(beanName = "dataSource", type = POSTGRES, provider = ZONKY)
class TicTacToeApplicationTest {
  @Test
  void contextLoads() {
  }
}
