package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.java.rest.restfull.productos.application.services.CreateProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.services.DeleteProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.services.EditProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.services.FindProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.CreateProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.DeleteProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.EditProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.FindProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.repository.mock.ProductoRepositoryMockImpl;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ProductoConfig {

    // Para el POST
    @Bean
    public CreateProductoUseCase createProductoUseCase() {
        return new CreateProductoUseCase(new ProductoRepositoryMockImpl());
    }

    @Bean
    public CreateProductoService createProductoService() {
        return new CreateProductoService(createProductoUseCase());
    }

    // Para el GET
    @Bean
    public FindProductoUseCase findProductoUseCase() {
        return new FindProductoUseCase();
    }

    @Bean
    public FindProductoService findProductoService() {
        return new FindProductoService(findProductoUseCase());
    }

    // Para el DELETE
    @Bean
    public DeleteProductoUseCase deleteProductoUseCase() {
        return new DeleteProductoUseCase();
    }

    @Bean
    public DeleteProductoService deleteProductoService() {
        return new DeleteProductoService();
    }

    // Para el PUT
    @Bean
    public EditProductoUseCase editProdcutoUseCase() {
        return new EditProductoUseCase();
    }

    @Bean
    public EditProductoService editProdcutoService() {
        return new EditProductoService(editProdcutoUseCase());
    }
}
