# controller — Endpoints REST

Capa de presentación: expone la API REST de carreras.

- `CarreraController`: endpoints `GET`, `POST`, `PUT`, `DELETE` sobre `/api/carreras`, más `POST /api/carreras/{id}/publicar`.
- Inyecta `CarreraService` (no accede directamente a la base de datos): el flujo es controller → service → repository.
- `@CrossOrigin(origins = "http://localhost:5173")` habilita las llamadas del frontend en desarrollo.
- Respuestas: `200` (OK), `201` (creada), `204` (eliminada), `404` (recurso inexistente).

## Construcción

```bash
./mvnw compile        # compilar
./mvnw spring-boot:run  # ejecutar en http://localhost:8081
```
