CREATE TABLE ACCOUNT (
  id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL,
  username VARCHAR(50) NOT NULL,
  name VARCHAR(50) NOT NULL,
  password VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  CONSTRAINT pk_account_id PRIMARY KEY (id)
);

CREATE TABLE GAME (
  id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL,
  game_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  screen BLOB,
  CONSTRAINT pk_game_id PRIMARY KEY (id)
);

CREATE TABLE GAME_SESSION (
  game_id BIGINT UNSIGNED NOT NULL,
  account_id BIGINT UNSIGNED NOT NULL,
  result ENUM('WIN', 'LOSE', 'DRAW'),
  CONSTRAINT pk_game_session PRIMARY KEY (game_id, account_id)
);

ALTER TABLE ACCOUNT ADD CONSTRAINT
  uc_username UNIQUE(username);

ALTER TABLE ACCOUNT ADD CONSTRAINT
  uc_email UNIQUE(email);

ALTER TABLE GAME_SESSION ADD CONSTRAINT
  fk_game_session_game FOREIGN KEY (game_id)
  REFERENCES GAME(id);

ALTER TABLE GAME_SESSION ADD CONSTRAINT
  fk_game_session_account FOREIGN KEY (account_id)
  REFERENCES ACCOUNT(id);
