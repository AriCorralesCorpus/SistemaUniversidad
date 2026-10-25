# repository — Acceso a datos

Capa de persistencia con Spring Data JPA.

- `CarreraRepository`: extiende `JpaRepository<Carrera, Long>`.
  - Hereda el CRUD completo: `save`, `findById`, `findAll`, `delete`, etc.
  - Consulta personalizada: `findByEstado(String estado)` para filtrar carreras `BORRADOR` o `PUBLICADA`.

No contiene lógica de negocio: solo acceso a la base de datos.

## Construcción

```bash
./mvnw compile        # compila el repository junto con el resto del proyecto
./mvnw spring-boot:run  # la interfaz se resuelve en tiempo de ejecución sobre H2 en memoria
```
