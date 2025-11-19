package es.etg.daw.dawes.java.rest.restfull.productos.application.services.categoria;

import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.categoria.DeleteCategoriaUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.CategoriaId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteCategoriaService {

    private final DeleteCategoriaUseCase deleteCategoriaUseCase;

    public void delete(CategoriaId id) { //Lo cambiamos
        deleteCategoriaUseCase.delete(id);
    }
}
