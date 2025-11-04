package es.etg.daw.dawes.java.rest.restfull.productos.application.services.producto;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.producto.EditProductoCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.producto.EditProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EditProductoService {

    private final EditProductoUseCase editProductoUseCase;

    public Producto update(EditProductoCommand command) {
        Producto producto = editProductoUseCase.update(command);
        return producto;
    }
}
