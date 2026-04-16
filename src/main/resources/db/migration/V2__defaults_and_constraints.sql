-- DEFAULT VALUES

ALTER TABLE vehicule
    MODIFY statut ENUM('DISPONIBLE', 'EN_LIVRAISON', 'MAINTENANCE')
    NOT NULL DEFAULT 'DISPONIBLE';

ALTER TABLE chauffeur
    MODIFY disponible BOOLEAN DEFAULT TRUE;

ALTER TABLE livraison
    MODIFY statut ENUM('EN_ATTENTE', 'EN_COURS', 'LIVREE')
    NOT NULL DEFAULT 'EN_ATTENTE';


-- FOREIGN KEYS

ALTER TABLE livraison
    ADD CONSTRAINT fk_livraison_client
        FOREIGN KEY (client_id) REFERENCES client(id);

ALTER TABLE livraison
    ADD CONSTRAINT fk_livraison_vehicule
        FOREIGN KEY (vehicule_id) REFERENCES vehicule(id);

ALTER TABLE livraison
    ADD CONSTRAINT fk_livraison_chauffeur
        FOREIGN KEY (chauffeur_id) REFERENCES chauffeur(id);


-- CONSTRAINT DE COHÉRENCE

ALTER TABLE vehicule
    ADD CONSTRAINT chk_capacite_positive
        CHECK (capacite > 0);

