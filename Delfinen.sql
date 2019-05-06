DROP TABLE if exists competitions;
DROP TABLE if exists competitive_swimmers;
DROP TABLE if exists members;

CREATE TABLE members (
first_name VARCHAR(255),
last_name VARCHAR (255),
age INT NOT NULL,
is_active TINYINT (1),
id INT AUTO_INCREMENT, 
contingent FLOAT NOT NULL,
restance FLOAT,
PRIMARY KEY (id)
);

CREATE TABLE competitive_swimmers (
id INT AUTO_INCREMENT, 
disciplin VARCHAR(50),
best_time TIME,
date_of_best_time TIMESTAMP,
FOREIGN KEY (id) REFERENCES members(id)
);

CREATE TABLE competitions (
id INT AUTO_INCREMENT, 
competition_name VARCHAR(255),
ranking INT NOT NULL,
best_time TIME,
FOREIGN KEY (id) REFERENCES competitive_swimmers(id)
);

INSERT INTO members(first_name, last_name, age, is_active, contingent, restance) VALUES ('Klara', 'Hansen', 20, 1, 1600, 0);
INSERT INTO members(first_name, last_name, age, is_active, contingent, restance) VALUES ('Sara', 'Hansen', 20, 1, 1600, 0);
INSERT INTO members(first_name, last_name, age, is_active, contingent, restance) VALUES ('Mie', 'Hansen', 20, 1, 1600, 0);
INSERT INTO members(first_name, last_name, age, is_active, contingent, restance) VALUES ('Kurt', 'Hansen', 20, 1, 1600, 0);

INSERT INTO competitive_swimmers(id) VALUES (3);
