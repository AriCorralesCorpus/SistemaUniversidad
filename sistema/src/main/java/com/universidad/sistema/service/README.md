# service — Lógica de negocio

Capa de servicios: contiene las operaciones de negocio y delega la persistencia al repository.

- `CarreraService`:
  - `listar(String estado)`: todas las carreras o filtradas por estado (`BORRADOR` / `PUBLICADA`). `@Transactional(readOnly = true)`.
  - `obtener(Long id)`: devuelve `Optional<Carrera>`; vacío si no existe. `@Transactional(readOnly = true)`.
  - `crear(Carrera)`: guarda una nueva carrera; el estado inicial es `BORRADOR`. `@Transactional`.
  - `actualizar(Long id, Carrera datos)`: aplica los datos sobre la carrera existente; devuelve `null` si no existe. `@Transactional`.
  - `eliminar(Long id)`: borra la carrera; devuelve `false` si no existe. `@Transactional`.
  - `publicar(Long id)`: cambia el estado de `BORRADOR` a `PUBLICADA`; devuelve `null` si no existe. `@Transactional`.

El controller inyecta este servicio; el servicio inyecta `CarreraRepository`.

## Construcción

```bash
./mvnw compile        # compila la capa de servicio
./mvnw spring-boot:run  # el servicio se activa con el arranque de la app en http://localhost:8081
```
