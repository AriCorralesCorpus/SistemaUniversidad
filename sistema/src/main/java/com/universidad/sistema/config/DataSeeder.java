package com.universidad.sistema.config;

import com.universidad.sistema.entity.Carrera;
import com.universidad.sistema.repository.CarreraRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final CarreraRepository repo;

    public DataSeeder(CarreraRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        if (repo.count() > 0) {
            return;
        }
        Carrera c1 = new Carrera();
        c1.setNombre("Ingeniería en Software");
        c1.setFacultad("Tecnologías de la Información");
        c1.setDescripcion("Aprende desarrollo web, móvil, bases de datos y arquitectura de sistemas.");
        c1.setEstado("BORRADOR");
        repo.save(c1);

        Carrera c2 = new Carrera();
        c2.setNombre("Licenciatura en Negocios");
        c2.setFacultad("Administración");
        c2.setDescripcion("Formación integral en gestión empresarial y finanzas corporativas.");
        c2.setEstado("PUBLICADA");
        repo.save(c2);
    }
}
