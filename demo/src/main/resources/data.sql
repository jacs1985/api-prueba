-- Insertar datos en la tabla usuario
INSERT INTO usuario (id, name, email, password, created, modified, lastLogin, token, active)
VALUES
    (RANDOM_UUID(), 'Juan Rodriguez', 'juan@rodriguez.org', 'hunter2', NOW(), NOW(), NOW(), RANDOM_UUID(), TRUE),
    (RANDOM_UUID(), 'Maria Lopez', 'maria@lopez.com', 'password123', NOW(), NOW(), NOW(), RANDOM_UUID(), TRUE);

-- Insertar datos en la tabla telefono
-- Suponiendo que la relación es con el id del usuario

-- Teléfonos para Juan Rodriguez
INSERT INTO telefono ( number, citycode, contrycode, usuario_id)
VALUES
    ( '1234567', '1', '57', (SELECT id FROM usuario WHERE email = 'juan@rodriguez.org')),
    ( '7654321', '1', '57', (SELECT id FROM usuario WHERE email = 'juan@rodriguez.org'));

-- Teléfonos para Maria Lopez
INSERT INTO telefono ( number, citycode, contrycode, usuario_id)
VALUES
    ( '2345678', '2', '34', (SELECT id FROM usuario WHERE email = 'maria@lopez.com')),
    ( '8765432', '2', '34', (SELECT id FROM usuario WHERE email = 'maria@lopez.com'));
