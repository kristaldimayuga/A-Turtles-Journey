CREATE DATABASE IF NOT EXISTS TurtleOceanJourney;
USE TurtleOceanJourney;

GRANT ALL PRIVILEGES ON TurtleOceanJourney.* TO 'root'@'localhost';
FLUSH PRIVILEGES;

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
    chapter INT NOT NULL DEFAULT 1,
    progress_state TEXT NOT NULL,
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
('OceanExplorer', 'Sammy', 1, 90),
('ReefAdventurer', 'Shelly', 6, 90);

-- Insert initial data into progress
INSERT INTO progress (player_id, chapter, progress_state) VALUES
(1, 1, 'completed'),
(2, 1, 'completed');

-- Insert initial data into characters
INSERT INTO characters (chapterAppearance, name, species, classification, kind, relationship, location, story, educationalFact) VALUES
(1, 'Turtle', 'Green Sea Turtle', 'Animal', 'None', 'None', 'None', 'A green sea turtle who embarks on an adventure to find the island of the Bahamas.', 'Green sea turtles are known for their gentle nature, often migrating long distances between feeding grounds and nesting sites. They have a unique greenish-colored fat under their shell, which gives them their name. Green sea turtles can live up to 80 years and are primarily herbivorous.'),
(2, 'Jake', 'Loggerhead Sea Turtle', 'Reptile', 'Best Friend', 'Open ocean', 'Jake, the turtle\'s best friend, was separated from his siblings when a group of fishermen captured them to sell as pets.', 'Loggerhead sea turtles have large heads and powerful jaws, which help them feed on hard-shelled prey. They are known for their resilience and are often seen swimming long distances in the open ocean. Loggerheads are endangered, largely due to human activities such as fishing and pollution.'),
(2, 'Oscar', 'Day Octopus', 'Mollusk', 'Friend', 'Ecuador', 'Oscar is an old, wise octopus who lives in Ecuador. Known for guiding adventurers, he is knowledgeable about marine biodiversity and the impact of human activities on the ocean.', 'The day octopus is known for its incredible camouflage skills and intelligence. It can change colors and textures to blend in with its surroundings. Day octopuses are solitary creatures and prefer to hunt during the day, preying on crustaceans, fish, and mollusks.'),
(2, 'Milly', 'Butterfly Fish', 'Fish', 'Friend', 'Ecuador', 'A bubbly and happy butterfly fish that lives among the coral reefs.', 'Butterfly fish are small, brightly colored fish often found in coral reefs. They are known for their unique patterns and vibrant colors, which help them hide among the corals. Butterfly fish are generally social, often seen in pairs or small groups.'),
(2, 'Roy', 'Starfish', 'Echinoderm', 'Friend', 'Ecuador', 'A talkative starfish who sometimes travels but currently resides in the reefs of Ecuador.', 'Starfish are resilient creatures with the ability to regenerate lost arms. They use their tube feet to move and feed, often scavenging or preying on small marine organisms. Starfish are important members of the reef ecosystem.'),
(2, 'Julia', 'Moon Jelly', 'Cnidarian', 'Friend', 'Ecuador', 'A shy and soft-spoken moon jelly that shares stories about scuba divers and tourists interacting with marine animals and coral reefs.', 'Moon jellies are transparent and known for their delicate, umbrella-shaped bodies. They are gentle creatures that drift with ocean currents and feed on small plankton. Moon jellies play a crucial role in the ocean food chain.'),
(3, 'Seb', 'Ghost Crab', 'Crustacean', 'Friend', 'Chile', 'A wise friend of the turtle who lives on an uninhabited beach in Chile.', 'Ghost crabs are fast-moving, nocturnal creatures known for their pale coloring and ability to dig deep burrows in the sand. They are skilled hunters and scavengers, playing a key role in the coastal ecosystem.'),
(3, 'Lewis', 'Stray Dog', 'Mammal', 'Friend', 'Chile', 'A stray dog abandoned on the beach by his owners. Lewis is intelligent and loyal, helping the turtle adapt to life on the beach.', 'Stray dogs in Chile are often resourceful and friendly. They tend to form bonds with people and animals, showing a high degree of loyalty and intelligence.'),
(3, 'Judy', 'Humpback Whale', 'Mammal', 'Friend', 'Near the Antarctic Ice Sheet', 'A majestic whale who occasionally passes through the cold waters of the Drake Passage, guiding lost creatures and sharing stories of the ocean\'s depths.', 'Humpback whales are known for their migrations, often traveling thousands of miles each year. They communicate through complex songs and are highly social, often seen breaching and slapping the water.'),
(4, 'Carrie', 'Marine Biologist', 'Mammal', 'Caretaker', 'Argentina', 'Carrie is a marine biologist who rescues the turtle from frostbite in the Drake Passage.', 'Marine biologists study marine organisms and their ecosystems. They often engage in conservation efforts to protect endangered species and habitats, advocating for sustainable practices to preserve ocean biodiversity.'),
(4, 'Ricky', 'Magellanic Penguin', 'Bird', 'Friend', 'Argentina', 'A resilient penguin who lost his left eye due to an infection caused by a metal rod while swimming.', 'Magellanic penguins are found along the coasts of South America. They are social animals that form strong bonds with their mates and are excellent swimmers, diving to catch fish and squid.'),
(4, 'Maya', 'Commerson\'s Dolphin', 'Mammal', 'Friend', 'Argentina', 'A playful dolphin who escaped from a circus, now free and thriving in the wild.', 'Commerson\'s dolphins are known for their distinctive black-and-white coloring and playful nature. They are fast swimmers and are often seen riding waves. These dolphins are highly intelligent and social animals.'),
(4, 'Tod', 'South American Fur Seal', 'Mammal', 'Friend', 'Argentina', 'An elderly seal who lost his partner in a polar bear attack, now sharing wisdom with younger marine animals.', 'South American fur seals are strong swimmers, capable of deep dives. They live in colonies and have thick fur to protect them from cold waters. They are known for their loyalty and social structure.'),
(5, 'Mate', 'Green Sea Turtle', 'Reptile', 'Mate', 'Brazil', 'A green sea turtle that the main turtle meets while traveling in the seas off Brazil.', 'Like other green sea turtles, Mate is calm and resilient, capable of long migrations. Green sea turtles often form lifelong bonds with mates, and they instinctively return to the same beaches to nest.');

-- Insert initial data into location
INSERT INTO location (name, location, trivia) VALUES
('Costa Rica Beach', 'Costa Rica', 'Costa Rica Beach is renowned for its pristine sandy shores and vibrant marine life. The beach serves as a crucial nesting site for green sea turtles, providing a safe environment for hatchlings to emerge and embark on their first journey into the ocean. The warm climate and abundant food sources make it an ideal habitat for various marine species.'),
('Ecuadorian Coral Reef', 'Ecuador', 'The Ecuadorian Coral Reef is a bustling underwater ecosystem teeming with colorful corals, diverse fish species, and other marine life. Known for its exceptional biodiversity, the reef provides shelter and food for countless species. It is also a vital area for marine research and conservation efforts, highlighting the delicate balance between marine life and human activities.'),
('Abandoned Beach', 'Argentina', 'The Abandoned Beach in Argentina is a remote and serene location, characterized by its untouched sands and clear waters. Despite its beauty, the beach faces challenges from human interference, such as poaching and pollution. The area serves as a temporary sanctuary for displaced animals, offering a glimpse into the resilience of nature amidst adversity.'),
('Drake Passage', 'Near the Antarctic Ice Sheet', 'The Drake Passage is a narrow and tumultuous body of water located between South America\'s Cape Horn and the South Shetland Islands of Antarctica. Known for its strong currents and rough seas, it is one of the most challenging maritime passages in the world. The cold temperatures and icy conditions make it a hazardous area for marine life, but also a critical habitat for species like humpback whales.'),
('Ocean Conservation Facility', 'Argentina', 'The Ocean Conservation Facility in Argentina is dedicated to the rescue, rehabilitation, and study of marine animals affected by environmental hazards and human activities. Equipped with state-of-the-art laboratories and care centers, the facility serves as a safe haven for injured or distressed marine life. It plays a pivotal role in conservation efforts, education, and promoting sustainable practices to protect ocean ecosystems.'),
('Brazilian Coast', 'Brazil', 'The Brazilian Coast is famous for its extensive beaches, rich biodiversity, and vibrant marine ecosystems. Stretching along the Atlantic Ocean, it offers a variety of habitats, from coral reefs to mangroves, supporting numerous species of marine life. The region is also known for its cultural diversity and is a popular destination for eco-tourism and marine research.'),
('Bahamas Island', 'Bahamas', 'Bahamas Island is a tropical paradise characterized by its crystal-clear blue waters, white sandy beaches, and vibrant coral reefs. It is a vital nesting site for sea turtles and home to a myriad of marine species. The island\'s serene environment and protected waters make it an ideal location for conservation and the flourishing of marine life. The Bahamas also play a significant role in marine research and eco-tourism, attracting visitors from around the world.'),
('Near Antarctic Ice Sheet', 'Near Antarctica', 'The waters near the Antarctic Ice Sheet are among the coldest and most inhospitable in the world. These polar waters are home to specialized marine species adapted to extreme cold, such as humpback whales, seals, and various types of fish. The region is crucial for global marine biodiversity and plays a significant role in Earth\'s climate system. Despite the harsh conditions, it supports a unique and resilient ecosystem.');


-- Insert initial data into edibleitem
INSERT INTO edibleitem (name, isEdible) VALUES
('Seaweed', TRUE),
('Plastic Bag', FALSE),
('Jellyfish', TRUE),
('Bottle Cap', FALSE),
('Conchs', TRUE),
('Algae', TRUE),
('Shrimp', TRUE),
('Plastic Straw', FALSE),
('Shoelace', FALSE),
('Anchovies', TRUE),
('Sea Anemone', TRUE),
('Baby Crabs', TRUE),
('Cork', FALSE),
('Whelks', TRUE),
('Cardboard', FALSE),
('Plastic Cup', FALSE),
('Sponge', TRUE),
('Sea Urchin', TRUE),
('Sea Cucumbers', TRUE),
('Corals', TRUE),
('Toy Car', FALSE),
('Cellphone', FALSE),
('Rubber Band', FALSE),
('Mollusk', TRUE),
('Small Lobster', TRUE),
('Electric Wire', FALSE),
('String', FALSE),
('A Piece of Cloth', FALSE),
('Tunicate', TRUE),
('Candy Wrapper', FALSE);

-- Insert initial data into quiz
INSERT INTO quiz (question, correct_answer, wrong_answer_1, wrong_answer_2, wrong_answer_3) VALUES
('What is the primary diet of green sea turtles?', 'Seagrass', 'Fish', 'Plankton', 'Crustaceans'),
('Which marine creature has three hearts?', 'Octopus', 'Turtle', 'Shark', 'Dolphin'),
('What is Jake’s species?', 'Reptile', 'Mammal', 'Fish', 'Cnidarian'),
('What is unique about loggerhead sea turtles?', 'They have large heads and powerful jaws.', 'They glow in the dark.', 'They are immune to jellyfish stings.', 'They live only in freshwater lakes.'),
('Why are loggerhead sea turtles endangered?', 'Due to human activities like fishing and pollution.', 'Because of predator overpopulation.', 'Due to climate cooling.', 'Because they can’t find mates.'),
('What is Oscar’s classification?', 'Mollusk', 'Fish', 'Reptile', 'Crustacean'),
('What is a special skill of the day octopus?', 'It can camouflage and change texture.', 'It can fly above water.', 'It can glow in the dark.', 'It has venomous tentacles.'),
('When does the day octopus prefer to hunt?', 'During the day.', 'At night.', 'At dawn.', 'Only in the afternoon.'),
('Where does Milly, the butterfly fish, live?', 'Ecuador', 'Chile', 'Argentina', 'Brazil'),
('What is special about butterfly fish?', 'They are brightly colored and live in coral reefs.', 'They can jump out of the water.', 'They glow in the dark.', 'They are immune to shark attacks.'),
('What is Roy’s kind?', 'Starfish', 'Jellyfish', 'Dolphin', 'Sea Turtle'),
('What can starfish regenerate?', 'Their lost arms.', 'Their heads.', 'Their entire body.', 'Their tail.'),
('How do starfish move?', 'Using their tube feet.', 'By swimming with fins.', 'By gliding on mucus.', 'By crawling like crabs.'),
('What is Julia’s classification?', 'Cnidarian', 'Fish', 'Echinoderm', 'Mammal'),
('What shape is a moon jelly’s body?', 'Umbrella-shaped.', 'Star-shaped.', 'Heart-shaped.', 'Oval-shaped.'),
('What do moon jellies eat?', 'Plankton.', 'Small fish.', 'Seaweed.', 'Coral.'),
('What kind of creature is Seb?', 'Ghost Crab', 'Hermit Crab', 'Blue Crab', 'Snow Crab'),
('When are ghost crabs most active?', 'At night.', 'In the morning.', 'At noon.', 'Only during storms.'),
('What is a unique feature of ghost crabs?', 'They dig deep burrows in the sand.', 'They can fly short distances.', 'They are bioluminescent.', 'They form colonies on coral reefs.'),
('What kind of animal is Lewis?', 'Stray Dog', 'Sea Otter', 'Sea Lion', 'Walrus'),
('What is a common trait of stray dogs in Chile?', 'They are resourceful and friendly.', 'They hunt in packs.', 'They avoid human contact.', 'They live only in forests.'),
('What kind of whale is Judy?', 'Humpback Whale', 'Blue Whale', 'Sperm Whale', 'Beluga Whale'),
('Where does Judy live?', 'Near the Antarctic Ice Sheet.', 'In the Caribbean Sea.', 'Near the Arctic Circle.', 'In the Pacific Ocean.'),
('How do humpback whales communicate?', 'Through complex songs.', 'By clapping their fins.', 'By jumping out of water.', 'By glowing in the dark.'),
('What is Carrie’s profession?', 'Marine Biologist', 'Oceanographer', 'Fisherman', 'Conservationist'),
('What do marine biologists study?', 'Marine organisms and their ecosystems.', 'Weather patterns over oceans.', 'Fishing techniques.', 'Aquatic sports activities.'),
('What is Ricky’s kind?', 'Magellanic Penguin', 'Emperor Penguin', 'Adelie Penguin', 'King Penguin'),
('What caused Ricky to lose his eye?', 'An infection caused by a metal rod.', 'A shark attack.', 'A fight with another penguin.', 'A coral reef injury.'),
('Where is Ricky from?', 'Argentina', 'Brazil', 'Chile', 'Ecuador'),
('What kind of dolphin is Maya?', 'Commerson\'s Dolphin', 'Bottlenose Dolphin', 'Spinner Dolphin', 'Amazon River Dolphin'),
('What is unique about Commerson’s dolphins?', 'They have black-and-white coloring.', 'They can jump 20 feet high.', 'They can camouflage.', 'They are the largest dolphin species.'),
('What is Tod’s species?', 'South American Fur Seal', 'Walrus', 'Sea Lion', 'Manatee'),
('What helps South American fur seals survive in cold waters?', 'Their thick fur.', 'Their long fins.', 'Their large size.', 'Their fast swimming.'),
('Where does Tod live?', 'Argentina', 'Chile', 'Brazil', 'Ecuador');


