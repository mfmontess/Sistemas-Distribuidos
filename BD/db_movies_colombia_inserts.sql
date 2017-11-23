INSERT INTO db_movies_colombia.usuarios (nombre,contraseña)
VALUES ('michael','W654321*'),('prueba','1234');

INSERT INTO db_movies_colombia.estados_pelicula (descripcion)
VALUES ('Disponible'),('Reservada');
----
INSERT INTO db_movies_colombia.peliculas (titulo,fecha_estreno,resumen,duracion_minutos,director,estado_pelicula_id)
VALUES('THOR - RAGNAROK', '2017-10-26', 
	'En THOR - RAGNAROK, de Marvel Studios, Asgard es amenazada, pero Thor se encuentra atrapado en el otro extremo del universo sin su martillo y para escapar y salvar a su planeta deberá enfrentarse a su antiguo aliado y compañero Vengador… ¡El increíble Hulk!',
    130, 'Taika Waititi',1), ('La mélodie', '2017-10-23', 
	'Con casi cincuenta años, Simon es un violinista que se encuentra en un momento delicado de su carrera y de su vida. Aterrizó en clase de sexto en un colegio de París, dirigido por el Sr. Farid. Sus métodos de enseñanza rígidos hacen que tenga un comienzo difícil',
    102, 'Rachid Hami',1), ('Coco de DisneyPixar', '2017-10-23', 
	'En COCO, la nueva película de Disney-Pixar, Miguel, un aspirante a músico se une al simpático timador Héctor (voz original de Gael Garcia Bernal) en una extraordinaria aventura en la Tierra de los Muertos',
    130, 'Lee Unkrich',1);

INSERT INTO db_movies_colombia.paises_produccion (nombre) 
VALUES('Francia'),('Estados Unidos'),('Alemania'),('Rusia'),('Bélgica');

INSERT INTO db_movies_colombia.peliculas_paises_produccion(pelicula_id,pais_id)
VALUES(1,2),(2,1),(3,2);

INSERT INTO db_movies_colombia.generos (descripcion)
VALUES('Comedia dramática'),('Acción'),('Aventura'),('Animado'),('Comedia'),('DC Comics'),('Fantástico'),('Drama'),('Suspenso'),('Biografía'),('Thriller');

INSERT INTO db_movies_colombia.peliculas_generos(pelicula_id,genero_id)
VALUES(1,2),(2,1),(3,3),(3,4),(3,5);

INSERT INTO db_movies_colombia.idiomas (descripcion)
VALUES('Francés'),('Inglés'),('Alemán'),('Ruso'),('Armenio');

INSERT INTO db_movies_colombia.peliculas_idiomas(pelicula_id,idioma_id)
VALUES(1,2),(2,1),(3,1);