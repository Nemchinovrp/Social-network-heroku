DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS groups;
DROP TABLE IF EXISTS phone;
DROP TABLE IF EXISTS friendship;


CREATE TABLE account (
  id              INT         NOT NULL PRIMARY KEY AUTO_INCREMENT,
  first_name      VARCHAR(45) NULL,
  middle_name     VARCHAR(45) NULL,
  last_name       VARCHAR(45) NULL,
  date_of_birth   DATE        NULL,
  home_address    VARCHAR(45) NULL,
  working_address VARCHAR(45) NULL,
  email           VARCHAR(45) NULL,
  password        VARCHAR(45) NULL,
  icq             VARCHAR(45) NULL,
  skype           VARCHAR(45) NULL,
  info            VARCHAR(45) NULL,
  foto            LONGBLOB    NULL
);

CREATE TABLE groups (
  id       INT         NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name     VARCHAR(45) NULL,
  id_owner INT         NULL,
  info     VARCHAR(45) NULL,
  logo     LONGBLOB    NULL
);

CREATE TABLE phone (
  id         INT         NOT NULL PRIMARY KEY AUTO_INCREMENT,
  type       VARCHAR(45) NULL,
  number     VARCHAR(45) NOT NULL,
  id_account INT         NOT NULL
);

CREATE TABLE friendship (
  id_acc    INT         NOT NULL,
  id_friend INT         NOT NULL,
  status    VARCHAR(45) NOT NULL
);


INSERT INTO account (id, first_name, middle_name, last_name, date_of_birth, home_address, working_address, email, password, icq, skype, info)
VALUES
  (1, 'Федор', 'Владимирович', 'Емельяненко', '1976-09-28', 'Home', 'Working', 'lastemperor@gmail.ru', '123', '12010',
      'skype', 'information');

INSERT INTO account (id, first_name, middle_name, last_name, date_of_birth, home_address, working_address, email, password, icq, skype, info)
VALUES
  (2, 'Ройс', 'Realroyce', 'Грейси', '1966-12-12', 'Home', 'Working', 'realroyce@gmail.ru', '123456', '12010', 'skype',
   'information');

INSERT INTO account (id, first_name, middle_name, last_name, date_of_birth, home_address, working_address, email, password, icq, skype, info)
VALUES
  (3, 'Сомбат', 'Буакхау ', 'Ivanov', '1982-05-08', 'Home', 'Working', 'buakaw@gmail.ru', '123456', '12010', 'skype',
   'information');

INSERT INTO groups (id, name, id_owner, info)
VALUES (1, 'MMA', 1, 'mixed martial arts');

INSERT INTO groups (id, name, id_owner, info)
VALUES (2, 'Jiu-Jitsu', 2, 'ground fighting');

INSERT INTO groups (id, name, id_owner, info)
VALUES (3, 'Muay Thai', 3, 'The art of eight limbs');

INSERT INTO phone (id, type, number, id_account)
VALUES (1, 'HOME', '8-950-74-55-443', 1);
INSERT INTO phone (id, type, number, id_account)
VALUES (2, 'WORK', '8-950-63-99-483', 1);
INSERT INTO phone (id, type, number, id_account)
VALUES (3, 'OTHER', '8-950-50-55-451', 1);

INSERT INTO friendship (id_acc, id_friend, status) VALUES (7, 2, 'FRIEND');
INSERT INTO friendship (id_acc, id_friend, status) VALUES (7, 1, 'FRIEND');
INSERT INTO FRIENDSHIP (ID_ACC, ID_FRIEND, STATUS) VALUES (8, 4, 'SUBSCRIBER');
INSERT INTO FRIENDSHIP (ID_ACC, ID_FRIEND, STATUS) VALUES (8, 3, 'SUBSCRIBER');
