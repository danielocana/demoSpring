CREATE TABLE person
(
  id varchar(255) NOT NULL,
  name varchar(255),
  dni varchar(255),
  phone varchar(255),
  PRIMARY KEY (id)
);

CREATE TABLE pet
(
  id varchar(255) NOT NULL,
  name varchar(255),
  type varchar(255),
  PRIMARY KEY (id)
);

INSERT INTO person
VALUES ('1','test-flyway-application','Y9999999T','123456789'), ('2','testingOne','Y1113425T','123456789');

INSERT INTO pet
VALUES ('1','petOne','dog'), ('2','petTwo','cat');