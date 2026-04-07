CREATE TABLE client (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        nom VARCHAR(200) NOT NULL,
                        email VARCHAR(200) UNIQUE,
                        ville VARCHAR(100),
                        telephone VARCHAR(50)
);

CREATE TABLE vehicule (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          matricule VARCHAR(50) UNIQUE NOT NULL,
                          type VARCHAR(100),
                          capacite INT,
                          statut ENUM('DISPONIBLE', 'EN_LIVRAISON', 'MAINTENANCE') NOT NULL
);

CREATE TABLE chauffeur (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           nom VARCHAR(200) NOT NULL,
                           telephone VARCHAR(50),
                           permis_type VARCHAR(50),
                           disponible BOOLEAN
);

CREATE TABLE livraison (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           date_livraison DATE,
                           adresse_depart VARCHAR(200),
                           adresse_destination VARCHAR(200),
                           statut ENUM('EN_ATTENTE', 'EN_COURS', 'LIVREE') NOT NULL,
                           chauffeur_id BIGINT,
                           vehicule_id BIGINT,
                           client_id BIGINT
);