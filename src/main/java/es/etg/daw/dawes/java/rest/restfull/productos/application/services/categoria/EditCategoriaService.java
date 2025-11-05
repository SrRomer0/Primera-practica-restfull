package es.etg.daw.dawes.java.rest.restfull.productos.application.services.categoria;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.categoria.EditCategoriaCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.categoria.EditCategoriaUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Categoria;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EditCategoriaService {

    private final EditCategoriaUseCase editCategoriaUseCase;

    public Categoria update(EditCategoriaCommand command) {
        Categoria categoria = editCategoriaUseCase.update(command);
        return categoria;
    }
}
