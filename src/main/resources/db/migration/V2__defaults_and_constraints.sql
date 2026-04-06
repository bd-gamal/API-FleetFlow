-- DEFAULT VALUES

ALTER TABLE vehicules
    MODIFY statut ENUM('DISPONIBLE', 'EN_LIVRAISON', 'MAINTENANCE')
    NOT NULL DEFAULT 'DISPONIBLE';

ALTER TABLE chauffeurs
    MODIFY disponible BOOLEAN DEFAULT TRUE;

ALTER TABLE livraisons
    MODIFY statut ENUM('EN_ATTENTE', 'EN_COURS', 'LIVREE')
    NOT NULL DEFAULT 'EN_ATTENTE';


-- FOREIGN KEYS

ALTER TABLE livraisons
    ADD CONSTRAINT fk_livraison_client
        FOREIGN KEY (clients_id) REFERENCES clients(id);

ALTER TABLE livraisons
    ADD CONSTRAINT fk_livraison_vehicule
        FOREIGN KEY (vehicules_id) REFERENCES vehicules(id);

ALTER TABLE livraisons
    ADD CONSTRAINT fk_livraison_chauffeur
        FOREIGN KEY (chauffeurs_id) REFERENCES chauffeurs(id);


-- CONSTRAINT DE COHÉRENCE

ALTER TABLE vehicules
    ADD CONSTRAINT chk_capacite_positive
        CHECK (capacite > 0);