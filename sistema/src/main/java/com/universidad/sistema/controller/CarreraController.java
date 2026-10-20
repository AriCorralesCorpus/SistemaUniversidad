package com.universidad.sistema.controller;

import com.universidad.sistema.entity.Carrera;
import com.universidad.sistema.repository.CarreraRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carreras")
@CrossOrigin(origins = "http://localhost:5173")
public class CarreraController {

    private final CarreraRepository repo;

    public CarreraController(CarreraRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Carrera> listar(@RequestParam(required = false) String estado) {
        if (estado != null && !estado.isBlank()) {
            return repo.findByEstado(estado);
        }
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrera> obtener(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Carrera> crear(@RequestBody Carrera carrera) {
        if (carrera.getEstado() == null || carrera.getEstado().isBlank()) {
            carrera.setEstado("BORRADOR");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(carrera));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrera> actualizar(@PathVariable Long id, @RequestBody Carrera datos) {
        Carrera carrera = repo.findById(id).orElse(null);
        if (carrera == null) {
            return ResponseEntity.notFound().build();
        }
        if (datos.getNombre() != null) carrera.setNombre(datos.getNombre());
        if (datos.getFacultad() != null) carrera.setFacultad(datos.getFacultad());
        if (datos.getDescripcion() != null) carrera.setDescripcion(datos.getDescripcion());
        if (datos.getEstado() != null) carrera.setEstado(datos.getEstado());
        return ResponseEntity.ok(repo.save(carrera));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/publicar")
    public ResponseEntity<Carrera> publicar(@PathVariable Long id) {
        Carrera carrera = repo.findById(id).orElse(null);
        if (carrera == null) {
            return ResponseEntity.notFound().build();
        }
        carrera.setEstado("PUBLICADA");
        return ResponseEntity.ok(repo.save(carrera));
    }
}
