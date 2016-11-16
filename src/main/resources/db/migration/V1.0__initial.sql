CREATE TABLE french (
  id        BIGINT auto_increment,
  name      VARCHAR(100) NOT NULL,
  password      VARCHAR(100) NOT NULL,
  email     VARCHAR(100),
  address     VARCHAR(100),
  PRIMARY KEY (id)
);

INSERT INTO french (name, password, email, address) VALUES ('baguette', 'b653f9375528e754aaa40e0b2b27ee2e2b58e1ca37caca378e019f990a6053c7b5d87a6fe2be6f26', 'baguette@french.co.jp', '山手');
INSERT INTO french (name, password, email, address) VALUES ('croissant', 'b653f9375528e754aaa40e0b2b27ee2e2b58e1ca37caca378e019f990a6053c7b5d87a6fe2be6f26', 'croissant@french.co.jp', '代官山');
INSERT INTO french (name, password, email, address) VALUES ('fendu', 'b653f9375528e754aaa40e0b2b27ee2e2b58e1ca37caca378e019f990a6053c7b5d87a6fe2be6f26', 'fendu@french.co.jp', '恵比寿');
INSERT INTO french (name, password, email, address) VALUES ('epi', 'b653f9375528e754aaa40e0b2b27ee2e2b58e1ca37caca378e019f990a6053c7b5d87a6fe2be6f26', 'epi@french.co.jp', '吉祥寺');