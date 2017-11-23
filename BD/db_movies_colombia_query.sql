
SELECT p.titulo, e.descripcion as estado, reserva_id, u.nombre as usuario_reserva, fecha_reserva
FROM db_movies_colombia.peliculas p
INNER JOIN db_movies_colombia.estados_pelicula e
ON p.estado_pelicula_id = e.estado_pelicula_id
LEFT JOIN db_movies_colombia.reservas r
ON r.pelicula_id = r.pelicula_id
LEFT JOIN db_movies_colombia.usuarios u
ON r.usuario_id = u.usuario_id;
