CREATE DATABASE legal_ai;
USE legal_ai;

CREATE TABLE legal_queries (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_query TEXT,
  predicted_category VARCHAR(100),
  advice TEXT,
  timestamp DATETIME DEFAULT CURRENT_TIMESTAMP
);
