package es.etg.daw.dawes.java.rest.restfull.productos.application.usecase;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.EditProductoCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;

public class EditProductoUseCase {

    public Producto update(EditProductoCommand command) {
        
        Producto producto = Producto.builder()
                                .id(command.id())
                                .nombre(command.nombre())
                                .precio(command.precio())
                .build();
        return producto;
    }
}
