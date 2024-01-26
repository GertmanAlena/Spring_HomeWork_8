--create table tasks (
--                         id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
--                         description VARCHAR(150) NOT NULL,
--                         task_status varchar(50) NOT NULL,
--                         date_of_creation DATE
--);
CREATE TABLE IF NOT EXISTS tasks (
  id INT AUTO_INCREMENT PRIMARY KEY,
  description VARCHAR(255) NOT NULL,
  task_status VARCHAR(50) NOT NULL,
  date_of_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);