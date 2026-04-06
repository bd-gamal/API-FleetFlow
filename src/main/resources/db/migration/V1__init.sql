CREATE TABLE clients (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         nom VARCHAR(200) NOT NULL,
                         email VARCHAR(200) UNIQUE,
                         ville VARCHAR(100),
                         telephone VARCHAR(50)
);

CREATE TABLE vehicules (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           matricule VARCHAR(50) UNIQUE NOT NULL,
                           type VARCHAR(100),
                           capacite INT,
                           statut ENUM('DISPONIBLE', 'EN_LIVRAISON', 'MAINTENANCE') NOT NULL
);

CREATE TABLE chauffeurs (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            nom VARCHAR(200) NOT NULL,
                            telephone VARCHAR(50),
                            permisType VARCHAR(50),
                            disponible BOOLEAN
);

CREATE TABLE livraisons (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            date_livraison DATETIME DEFAULT CURRENT_TIMESTAMP,
                            adresse_depart VARCHAR(200),
                            adresse_destination VARCHAR(200),
                            statut ENUM('EN_ATTENTE', 'EN_COURS', 'LIVREE') NOT NULL,
                            chauffeurs_id BIGINT,
                            vehicules_id BIGINT,
                            clients_id BIGINT,


);