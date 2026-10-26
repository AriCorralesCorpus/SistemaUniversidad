package com.universidad.sistema.controller;

import com.universidad.sistema.dto.DivisionRequest;
import com.universidad.sistema.dto.DivisionResponse;
import com.universidad.sistema.service.DivisionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Rutas de la API para la administración de divisiones.
 * Solo delega la lógica al servicio; no consulta la base de datos.
 */
@RestController
@RequestMapping("/api/divisiones")
@CrossOrigin(origins = "http://localhost:5173")
public class DivisionController {

    private final DivisionService service;

    public DivisionController(DivisionService service) {
        this.service = service;
    }

    @GetMapping
    public List<DivisionResponse> listar() {
        return service.listarDivisiones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DivisionResponse> obtener(@PathVariable Long id) {
        return service.obtenerDivision(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DivisionResponse> crear(@RequestBody DivisionRequest datos) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crearDivision(datos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DivisionResponse> actualizar(@PathVariable Long id,
                                                        @RequestBody DivisionRequest datos) {
        return service.actualizarDivision(id, datos)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!service.eliminarDivision(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(DivisionService.DivisionConCarrerasException.class)
    public ResponseEntity<Map<String, String>> divisionConCarreras(
            DivisionService.DivisionConCarrerasException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("error", ex.getMessage()));
    }
}
