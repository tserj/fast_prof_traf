# Users schema

# --- !Ups

CREATE TABLE User (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    login varchar(63) NOT NULL,
    password varchar(127) NOT NULL,
    email varchar(255) NOT NULL,
    fullname varchar(255) NOT NULL,
    locale varchar(7) NOT NULL,
    register timestamp NOT NULL default CURRENT_TIMESTAMP,
    enabled bool NOT NULL default '0',
    admin boolean NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY login (login)
) DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

INSERT INTO user VALUES (1, 'admin', 'dadb2735af84651c',
                         'admin@example.com', 'Administrator', 'en', default, 1, 1);
INSERT INTO user VALUES (2, 'user', '28879b5ffa815745',
                         'user@example.com', 'Simple user', 'ru', default, 0, 0);
INSERT INTO user VALUES (3, 'test', 'a1d94591f8c12af0',
                         'test@example.com', 'Simple test user', 'en', default, 0, 0);

# --- !Downs

DROP TABLE User;