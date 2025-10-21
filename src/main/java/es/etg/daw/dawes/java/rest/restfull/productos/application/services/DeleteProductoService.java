package es.etg.daw.dawes.java.rest.restfull.productos.application.services;

import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.DeleteProductoUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteProductoService {

    private final DeleteProductoUseCase deleteProductoUseCase;

    public void delete(int id) {
        deleteProductoUseCase.delete(id);
    }

}
