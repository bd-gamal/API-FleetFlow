ALTER TABLE livraison DROP FOREIGN KEY fk_livraison_client;
ALTER TABLE livraison DROP FOREIGN KEY fk_livraison_chauffeur;

ALTER TABLE client DROP COLUMN email;
ALTER TABLE client MODIFY id BIGINT;
ALTER TABLE client ADD CONSTRAINT fk_client_user FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE;

ALTER TABLE chauffeur MODIFY id BIGINT;
ALTER TABLE chauffeur ADD CONSTRAINT fk_chauffeur_user FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE;

ALTER TABLE livraison ADD CONSTRAINT fk_livraison_client FOREIGN KEY (client_id) REFERENCES client(id);
ALTER TABLE livraison ADD CONSTRAINT fk_livraison_chauffeur FOREIGN KEY (chauffeur_id) REFERENCES chauffeur(id);