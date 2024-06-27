CREATE TABLE IF NOT EXISTS person (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      name VARCHAR(255) NOT NULL,
                                      age INT NOT NULL
);

INSERT INTO person (name, age) VALUES ('John Doe', 30);
INSERT INTO person (name, age) VALUES ('Jane Smith', 25);

