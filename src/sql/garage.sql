drop database if exists garage; 
create database garage;
	use garage

create table client 
	(
	idclient int(3) not null auto_increment,
	nom varchar(50) not  null,
	prenom varchar(50) not  null,
	adresse varchar(50) not  null,
	email varchar(50) not  null,
	tel varchar(50) not  null,
	primary key (idclient)
		);

	create table technicien 
	(
	idtechnicien int(3) not null auto_increment,
	nom varchar(50) not  null,
	prenom varchar(50) not  null,
	qualification varchar(50) not  null,
	email varchar(50) not  null,
	tel varchar(50) not  null,
	primary key (idtechnicien)
		);

	create table vehicule 
	(
	idvehicule int(3) not null auto_increment,
	matricule varchar(50) not  null,
	marque varchar(50) not  null,
	energie varchar(50) not  null,
	nbkm int(10),
	datecirculation date,
	idclient int(3) not null,
	primary key (idvehicule),
	foreign key (idclient) references client (idclient)
		);

	create table intervention 
	(
	idintervention int(3) not null auto_increment,
	description varchar(50) not  null,
	prix float (5.2) not  null,
	dateinter date,
	idvehicule int(3) not null,
	idtechnicien int(3) not null,
	primary key (idintervention),
	foreign key (idtechnicien) references technicien (idtechnicien),
	foreign key(idvehicule) references vehicule(idvehicule)
		);
