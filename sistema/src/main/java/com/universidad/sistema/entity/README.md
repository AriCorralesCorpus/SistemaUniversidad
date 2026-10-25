# entity — Modelo de datos

Clases JPA que representan las tablas de la base de datos H2.

- `Carrera`: entidad de la oferta académica.
  - `id` (Long, generado por la BD)
  - `nombre` (String)
  - `facultad` (String)
  - `descripcion` (String, máximo 1000 caracteres)
  - `estado` (String: `BORRADOR` o `PUBLICADA`)

## Construcción

```bash
./mvnw compile        # compila la entidad junto con el resto del proyecto
./mvnw spring-boot:run  # la BD H2 en memoria (jdbc:h2:mem:alumnos) se crea al arrancar
```
