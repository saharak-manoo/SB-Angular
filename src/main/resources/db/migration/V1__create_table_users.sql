CREATE TABLE users (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  username varchar(100) NOT NULL,
  password varchar(100) NOT NULL,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY `username` (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;