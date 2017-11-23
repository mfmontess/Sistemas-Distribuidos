CREATE TABLE db_movies_colombia.usuarios(
    usuario_id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre varchar(10) NOT NULL,
    contraseña varchar(10) NOT NULL
);
CREATE TABLE db_movies_colombia.estados_pelicula(
	estado_pelicula_id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    descripcion varchar(45)
);
CREATE TABLE db_movies_colombia.peliculas (
    pelicula_id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    titulo varchar(45),
    fecha_estreno date,
    resumen varchar(500),
    duracion_minutos int(11),
    director varchar(45),
    estado_pelicula_id int, FOREIGN KEY (estado_pelicula_id) REFERENCES estados_pelicula(estado_pelicula_id)
);
CREATE TABLE db_movies_colombia.paises_produccion (
    pais_id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre varchar(45)
);
CREATE TABLE db_movies_colombia.peliculas_paises_produccion(
    pelicula_pais_produccion_id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    pelicula_id int(11), FOREIGN KEY (pelicula_id) REFERENCES peliculas(pelicula_id),
    pais_id int(11), FOREIGN KEY (pais_id) REFERENCES paises_produccion(pais_id)
);
CREATE TABLE db_movies_colombia.generos (
    genero_id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    descripcion varchar(45)
);
CREATE TABLE db_movies_colombia.peliculas_generos(
    pelicula_genero_id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    pelicula_id int(11), FOREIGN KEY(pelicula_id) REFERENCES peliculas(pelicula_id),
    genero_id int(11), FOREIGN KEY(genero_id) REFERENCES generos(genero_id)
);
CREATE TABLE db_movies_colombia.idiomas (
    idioma_id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    descripcion varchar(45)
);
CREATE TABLE db_movies_colombia.peliculas_idiomas(
    pelicula_idioma_id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    pelicula_id int(11), FOREIGN KEY(pelicula_id) REFERENCES peliculas(pelicula_id),
    idioma_id int(11), FOREIGN KEY(idioma_id) REFERENCES idiomas(idioma_id)
);
CREATE TABLE db_movies_colombia.reservas (
    reserva_id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    usuario_id int(11), FOREIGN KEY(usuario_id) REFERENCES usuarios(usuario_id),
    pelicula_id int(11), FOREIGN KEY(pelicula_id) REFERENCES peliculas(pelicula_id),
    fecha_reserva date DEFAULT '2017-11-20'
);