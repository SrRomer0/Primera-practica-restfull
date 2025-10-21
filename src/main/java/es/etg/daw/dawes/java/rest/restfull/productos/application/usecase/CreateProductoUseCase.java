package es.etg.daw.dawes.java.rest.restfull.productos.application.usecase;

import java.time.LocalDateTime;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.CreateProductoCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.ProductoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateProductoUseCase {

    // Atributos
    private final ProductoRepository productoRepository;

    public Producto create(CreateProductoCommand comando) {

        Producto producto = Producto.builder() // Se puede usar comando.id() y no getId() por usar @Accessors(fluent = true) en la clase CreateProductoCommand
                .nombre(comando.nombre())
                .precio(comando.precio())
                .createdAt(LocalDateTime.now()).build();

        productoRepository.save(producto);
        // TODO Faltaría la lógica sobre el producto, por ejemplo, almacenarlo en una base de datos.
        return producto;

    }
}
