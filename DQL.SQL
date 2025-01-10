USE CarreraBurros;

-- Insertar dueños
INSERT INTO Dueño (Nombre, edad) VALUES ('Juan Pérez', '45');
INSERT INTO Dueño (Nombre, edad) VALUES ('María Gómez', '38');
INSERT INTO Dueño (Nombre, edad) VALUES ('Carlos López', '50');

-- Insertar participantes
INSERT INTO Participante (Nombre, Cedula, SaldoDisponible) VALUES ('Luis Martínez', '1234567890', 1000);
INSERT INTO Participante (Nombre, Cedula, SaldoDisponible) VALUES ('Ana Torres', '9876543210', 1500);
INSERT INTO Participante (Nombre, Cedula, SaldoDisponible) VALUES ('Roberto Díaz', '1122334455', 1200);

-- Insertar burros
INSERT INTO Burros (Nombre, edad, Raza, Dueño_id) VALUES ('Burro1', '3', 'Jorobado', 1);
INSERT INTO Burros (Nombre, edad, Raza, Dueño_id) VALUES ('Burro2', '4', 'Mestizo', 2);
INSERT INTO Burros (Nombre, edad, Raza, Dueño_id) VALUES ('Burro3', '5', 'Andaluz', 3);

-- Insertar competencias
INSERT INTO Competencias (Fecha_Inicio, Lugar, Estado, Ganador) VALUES ('2025-02-01', 'Campo A', 1, 1);
INSERT INTO Competencias (Fecha_Inicio, Lugar, Estado, Ganador) VALUES ('2025-02-05', 'Campo B', 0, NULL);
INSERT INTO Competencias (Fecha_Inicio, Lugar, Estado, Ganador) VALUES ('2025-02-10', 'Campo C', 1, 2);

-- Insertar participación de burros en competencias
INSERT INTO CompetenciaBurros (Burro_id, Competencia_id) VALUES (1, 1);
INSERT INTO CompetenciaBurros (Burro_id, Competencia_id) VALUES (2, 1);
INSERT INTO CompetenciaBurros (Burro_id, Competencia_id) VALUES (3, 2);
INSERT INTO CompetenciaBurros (Burro_id, Competencia_id) VALUES (1, 3);

-- Insertar apuestas
INSERT INTO Apuestas (Particpante_id, Competencia_id, Burro_id, SaldoApuesta) VALUES (1, 1, 1, 500);
INSERT INTO Apuestas (Particpante_id, Competencia_id, Burro_id, SaldoApuesta) VALUES (2, 1, 2, 200);
INSERT INTO Apuestas (Particpante_id, Competencia_id, Burro_id, SaldoApuesta) VALUES (3, 2, 3, 700);
INSERT INTO Apuestas (Particpante_id, Competencia_id, Burro_id, SaldoApuesta) VALUES (1, 3, 1, 300);
