package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.rest.integracion;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.repository.mock.categoria.CategoriaFactory;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.rest.CategoriaController;

@SpringBootTest
public class CategoriaControllerTestIT {
    
    //Le decimos que nos inyecte el controlador (no hay new())
    @Autowired
    private CategoriaController controller;

    @Test
    public void When_AllCategoria_Expect_Lista(){

        int numCategoria = CategoriaFactory.getDemoData().values().size();

        var lista = controller.allCategorias();

         assertAll(
                () -> assertNotNull(lista),
                () -> assertEquals(numCategoria, lista.size())
        );

    }

}