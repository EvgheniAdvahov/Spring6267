CREATE TABLE IF NOT EXISTS userTable (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstName varchar(50) NOT NULL,
    age INT NOT NULL,
    email varchar(50) NOT NULL
    );

INSERT INTO userTable (firstName, age, email) VALUES ('Иван', 28, 'example@gmail.com');