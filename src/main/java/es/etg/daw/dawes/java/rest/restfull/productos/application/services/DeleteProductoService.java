package es.etg.daw.dawes.java.rest.restfull.productos.application.services;

import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.DeleteProductoUseCase;

public class DeleteProductoService {

    private DeleteProductoUseCase deleteProductoUseCase;

    public void delete(int id) {
        deleteProductoUseCase.delete(id);
    }

}
