-- Create and initialize the TurtleOceanJourney database
CREATE DATABASE IF NOT EXISTS TurtleOceanJourney;
USE TurtleOceanJourney;

-- Grant privileges to the user
GRANT ALL PRIVILEGES ON TurtleOceanJourney.* TO 'root'@'localhost';
FLUSH PRIVILEGES;

-- Show tables
SHOW TABLES;

-- Create the players table
CREATE TABLE players (
    player_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    turtle_name VARCHAR(45) NOT NULL STRING DEFAULT 'name',
    age INT DEFAULT 1,
    health INT DEFAULT 100
);

-- Create the progress table
CREATE TABLE progress (
    progress_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    player_id INT NOT NULL,
    chapter INT DEFAULT 1,
    progress_state ENUM('not_started', 'in_progress', 'completed') DEFAULT 'not_started',
    FOREIGN KEY (player_id) REFERENCES players(player_id) ON DELETE CASCADE
);

-- Create the characters table
CREATE TABLE characters (
    character_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    chapterAppearance INT NOT NULL,
    species VARCHAR(50),
    classification VARCHAR(50),
    kind VARCHAR(50),
    relationship VARCHAR(50),
    location VARCHAR(100),
    story TEXT,
    educationalFact TEXT
);

-- Create the location table
CREATE TABLE location (
    location_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    location VARCHAR(50),
    trivia TEXT
);

-- Create the edibleitem table
CREATE TABLE edibleitem (
    item_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    isEdible BOOLEAN DEFAULT TRUE
);

-- Create the quiz table
CREATE TABLE quiz (
    quiz_id INT AUTO_INCREMENT PRIMARY KEY,
    question TEXT NOT NULL,
    correct_answer VARCHAR(100) NOT NULL,
    wrong_answer_1 VARCHAR(100),
    wrong_answer_2 VARCHAR(100),
    wrong_answer_3 VARCHAR(100)
);

-- Insert initial data into players
INSERT INTO players (username, turtle_name, age, health) VALUES
('OceanExplorer', 'Sammy', 3, 95),
('ReefAdventurer', 'Shelly', 2, 90);

-- Insert initial data into progress
INSERT INTO progress (player_id, chapter, progress_state) VALUES
(1, 1, 'completed'),
(2, 1, 'in_progress');

-- Insert initial data into characters
INSERT INTO characters (chapterAppearance, name, species, classification, kind, relationship, location, story, educationalFact) VALUES
(1, 'Jake', 'Loggerhead Turtle', 'Reptile', 'Friend', 'Mentor', 'Bahamas Reef', 'Jake helps Sammy learn the basics of the ocean.', 'Loggerhead turtles can dive up to 300 meters.'),
(2, 'Oscar', 'Octopus', 'Mollusk', 'Friend', 'Guide', 'Ecuadorian Reef', 'Oscar provides trivia about marine biodiversity.', 'Octopuses have three hearts.');

-- Insert initial data into location
INSERT INTO location (name, location, story, trivia) VALUES
('Bahamas Reef', 'Atlantic Ocean', 'A vibrant coral reef with many friendly creatures.', 'The Bahamas is home to the third-largest barrier reef in the world.'),
('Ecuadorian Reef', 'Pacific Ocean', 'A colorful reef teeming with marine life.', 'The Galápagos Islands near Ecuador are a UNESCO World Heritage Site.');

-- Insert initial data into edibleitem
INSERT INTO edibleitem (name, isEdible) VALUES
('Seaweed', TRUE),
('Plastic Bag', FALSE),
('Shrimp', TRUE);

-- Insert initial data into quiz
INSERT INTO quiz (question, correct_answer, wrong_answer_1, wrong_answer_2, wrong_answer_3) VALUES
('What is the primary diet of green sea turtles?', 'Seagrass', 'Fish', 'Plankton', 'Crustaceans'),
('Which marine creature has three hearts?', 'Octopus', 'Turtle', 'Shark', 'Dolphin');

