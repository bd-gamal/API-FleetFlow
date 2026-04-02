create database fleetflow_db;
use fleetflow_db;

 create table clients(
 id bigint auto_increment primary key,
 nom varchar(200) not null,
 email varchar(200) unique,
 ville varchar(100),
 telephone varchar(50)
 );
 
 create table vehicules(
 id bigint auto_increment primary key,
 matricule varchar(50) unique not null,
 type varchar(100),
 capacite int,
 statut ENUM('DISPONIBLE', 'EN_LIVRAISON', 'MAINTENANCE') NOT NULL
 );
 
 create table chauffeurs(
 id bigint auto_increment primary key,
 nom varchar(200) not null,
 telephone varchar(50), 
 permisType varchar(50),
 disponible boolean
 );
 
 create table livraisons(
 id bigint auto_increment primary key ,
 date_livraison DATETIME DEFAULT CURRENT_TIMESTAMP, 
 adresse_depart varchar(200),
 adresse_destination varchar(200),
 statut enum('EN_ATTENTE', 'EN_COURS', 'LIVREE') not null,
 chauffeurs_id bigint,
 vehicules_id bigint,
 clients_id bigint,
 FOREIGN KEY (chauffeurs_id) REFERENCES chauffeurs(id),
 FOREIGN KEY (vehicules_id) REFERENCES vehicules(id),
 FOREIGN KEY (clients_id) REFERENCES clients(id)
 );