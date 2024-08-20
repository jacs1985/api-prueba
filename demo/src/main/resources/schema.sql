CREATE TABLE IF NOT EXISTS usuario (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    created TIMESTAMP,
    modified TIMESTAMP,
    lastLogin TIMESTAMP,
    token UUID,
    active BOOLEAN
    );

CREATE TABLE IF NOT EXISTS telefono (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    number VARCHAR(20),
    citycode VARCHAR(10),
    contrycode VARCHAR(10),
    usuario_id UUID,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
    );
