DROP TABLE if exists competitions;
DROP TABLE if exists competitive_swimmers;
DROP TABLE if exists members;
DROP TABLE if exists contingent;

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
id INT, 
disciplin VARCHAR(50),
best_time TIME,
date_of_best_time DATE,
FOREIGN KEY (id) REFERENCES members(id)
);

CREATE TABLE competitions (
id INT, 
competition_name VARCHAR(255),
date_of_competition DATE,
ranking INT NOT NULL,
best_time TIME,
FOREIGN KEY (id) REFERENCES competitive_swimmers(id)
);

CREATE TABLE contingent (
under_18 INT NOT NULL,
between_18_and_60 INT NOT NULL,
over_60 INT NOT NULL,
passive INT NOT NULL
);

INSERT INTO members(first_name, last_name, age, is_active, contingent, restance) VALUES ('Klara', 'Hansen', 8, 1, 1000, 0);
INSERT INTO members(first_name, last_name, age, is_active, contingent, restance) VALUES ('Sara', 'Jensen', 20, 0, 1600, 0);
INSERT INTO members(first_name, last_name, age, is_active, contingent, restance) VALUES ('Mie', 'Madsen', 80, 1, 1200, 0);
INSERT INTO members(first_name, last_name, age, is_active, contingent, restance) VALUES ('Kurt', 'Knudsen', 30, 0, 1600, 0);
INSERT INTO members(first_name, last_name, age, is_active, contingent, restance) VALUES ('Rasmus', 'Petersen', 57, 1, 1600, 0);
INSERT INTO members(first_name, last_name, age, is_active, contingent, restance) VALUES ('Laura', 'Hoeg', 18, 1, 1600, 0);
INSERT INTO members(first_name, last_name, age, is_active, contingent, restance) VALUES ('Kristina', 'Svendsen', 9, 1, 1000, 0);
INSERT INTO members(first_name, last_name, age, is_active, contingent, restance) VALUES ('Thomas', 'Andersen', 57, 0, 1600, 0);
INSERT INTO members(first_name, last_name, age, is_active, contingent, restance) VALUES ('Hans', 'Mikkelsen', 23, 1, 1600, 0);
INSERT INTO members(first_name, last_name, age, is_active, contingent, restance) VALUES ('David', 'Soerensen', 44, 1, 1600, 0);

INSERT INTO competitive_swimmers VALUES (1, 'Butterfly', '00:10:25', '2019-05-06');
INSERT INTO competitive_swimmers VALUES (3, 'Crawl', '00:00:35', '2019-05-09');
INSERT INTO competitive_swimmers VALUES (5, 'Back', '00:10:25', '2019-05-06');
INSERT INTO competitive_swimmers VALUES (6, 'Breast', '00:00:35', '2019-05-09');
INSERT INTO competitive_swimmers VALUES (7, 'Fly', '00:10:25', '2019-05-06');
INSERT INTO competitive_swimmers VALUES (9, 'Crawl', '00:00:35', '2019-05-09');
INSERT INTO competitive_swimmers VALUES (10, 'Fly', '00:10:25', '2019-05-06');

INSERT INTO competitions VALUES (1, 'Ballerup mesterskab', '2019-03-02', 3, '00:03:58');
INSERT INTO competitions VALUES (10, 'Ballerup mesterskab', '2019-03-02', 1, '00:01:22');

INSERT INTO contingent VALUES (1000, 1600, 1200, 500);