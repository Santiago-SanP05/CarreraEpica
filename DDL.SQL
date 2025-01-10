CREATE DATABASE CarreraBurros;
USE CarreraBurros;

CREATE TABLE Dueño (
Id_Dueño INT PRIMARY KEY auto_increment,
Nombre VARCHAR(45),
edad VARCHAR(45)
);

CREATE TABLE Participante(
Id_Participante INT PRIMARY KEY auto_increment,
Nombre VARCHAR(45),
Cedula VARCHAR(10),
SaldoDisponible INT
);

CREATE TABLE Burros(
Id_Burro INT PRIMARY KEY auto_increment,
Nombre VARCHAR(45),
edad VARCHAR(45),
Raza VARCHAR(100),
Dueño_id INT,
FOREIGN KEY (Dueño_id) REFERENCES Dueño(Id_Dueño) ON DELETE CASCADE
);

CREATE TABLE Competencias(
Id_Competencia INT PRIMARY KEY auto_increment,
Fecha_Inicio DATE,
Lugar VARCHAR(250),
Estado Boolean,
Ganador INT,
FOREIGN KEY (Ganador) REFERENCES Burros(Id_Burro) ON DELETE CASCADE
);

CREATE TABLE CompetenciaBurros(
Id_CompetenciaBurros INT PRIMARY KEY auto_increment,
Burro_id int,
Competencia_id int,
FOREIGN KEY (Burro_id) REFERENCES Burros(Id_Burro) ON DELETE CASCADE,
FOREIGN KEY (Competencia_id) REFERENCES Competencias(Id_Competencia) ON DELETE CASCADE
);

CREATE TABLE Apuestas(
Id_Apuesta INT PRIMARY KEY auto_increment,
Particpante_id INT,
Competencia_id INT,
SaldoApuesta INT,
FOREIGN KEY (Particpante_id) REFERENCES Participante(Id_Participante) ON DELETE CASCADE,
FOREIGN KEY (Competencia_id) REFERENCES Competencias(Id_Competencia) ON DELETE CASCADE
);




