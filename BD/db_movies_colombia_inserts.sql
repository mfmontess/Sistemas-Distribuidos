INSERT INTO db_movies_colombia.usuarios (nombre,contraseña)
VALUES ('michael','W654321*'),('prueba','1234');

INSERT INTO db_movies_colombia.estados_pelicula (descripcion)
VALUES ('Disponible'),('Reservada');
----
INSERT INTO db_movies_colombia.peliculas (titulo,fecha_estreno,resumen,duracion_minutos,director,estado_pelicula_id)
VALUES('THOR - RAGNAROK', '2017-10-26', 
	'En THOR - RAGNAROK, de Marvel Studios, Asgard es amenazada, pero Thor se encuentra atrapado en el otro extremo del universo sin su martillo y para escapar y salvar a su planeta deberá enfrentarse a su antiguo aliado y compañero Vengador… ¡El increíble Hulk!',
    130, 'Taika Waititi',1);

INSERT INTO db_movies_colombia.paises_produccion (nombre) VALUES('Francia'),('Estados Unidos');

INSERT INTO db_movies_colombia.peliculas_paises_produccion(pelicula_id,pais_id) VALUES(1,2);

INSERT INTO db_movies_colombia.generos (descripcion) VALUES('Comedia dramática'),('Acción, Aventura');

INSERT INTO db_movies_colombia.peliculas_generos(pelicula_id,genero_id) VALUES(1,2);

INSERT INTO db_movies_colombia.idiomas (descripcion) VALUES('Frances'),('Inglés');

INSERT INTO db_movies_colombia.peliculas_idiomas(pelicula_id,idioma_id) VALUES(1,2);