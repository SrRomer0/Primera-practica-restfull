package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.jpa.repository;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.CategoriaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CategoriaJpaRepositoryImp implements CategoriaRepository {
    
    private final CategoriaRepositoryJpa categoriaRepositoryJpa;

}
