ALTER TABLE livraison ADD CONSTRAINT fk_livraison_chauffeur FOREIGN KEY (chauffeur_id) REFERENCES chauffeur(id);
ALTER TABLE livraison ADD CONSTRAINT fk_livraison_vehicule FOREIGN KEY (vehicule_id) REFERENCES vehicule(id);
ALTER TABLE livraison ADD CONSTRAINT fk_livraison_client FOREIGN KEY (client_id) REFERENCES client(id);


ALTER TABLE vehicule ADD CONSTRAINT check_capacite_positive CHECK (capacite > 0);
ALTER TABLE chauffeur ALTER COLUMN disponible SET DEFAULT true;
ALTER TABLE vehicule MODIFY COLUMN statut ENUM('DISPONIBLE', 'EN_LIVRAISON', 'MAINTENANCE') DEFAULT 'DISPONIBLE';
ALTER TABLE livraison MODIFY COLUMN statut ENUM('EN_ATTENTE', 'EN_COURS', 'LIVREE') DEFAULT 'EN_ATTENTE';