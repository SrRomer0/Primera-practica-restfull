package es.etg.daw.dawes.java.rest.restfull.productos.domain.model;

import java.time.LocalDateTime;

import es.etg.daw.dawes.java.rest.restfull.common.domain.model.CategoriaId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Categoria {
    private CategoriaId id;
    private String nombre;
    private LocalDateTime createdAt;
}