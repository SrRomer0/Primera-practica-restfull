package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.etg.daw.dawes.java.rest.restfull.common.domain.model.CategoriaId;
import es.etg.daw.dawes.java.rest.restfull.productos.application.command.categoria.CreateCategoriaCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.application.command.categoria.EditCategoriaCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.application.services.categoria.CreateCategoriaService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.services.categoria.DeleteCategoriaService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.services.categoria.EditCategoriaService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.services.categoria.FindCategoriaService;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Categoria;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.mapper.CategoriaMapper;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.categoria.CategoriaRequest;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.categoria.CategoriaResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categorias") // La url será /productos
@RequiredArgsConstructor
public class CategoriaController {

    private final CreateCategoriaService createCategoriaService;
    private final FindCategoriaService findCategoriaService;
    private final DeleteCategoriaService deleteCategoriaService;
    private final EditCategoriaService editCategoriaService;

    @PostMapping //Método Post
    public ResponseEntity<CategoriaResponse> createCategoria(
              // Indicamos que valide los datos de la request
            @Valid
            @RequestBody 
                CategoriaRequest categoriaRequest) {
        CreateCategoriaCommand comando = CategoriaMapper.toCommand(categoriaRequest); 
        Categoria categoria = createCategoriaService.createCategoria(comando);
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoriaMapper.toResponse(categoria)); //Respuesta
    }

    @GetMapping
    public List<CategoriaResponse> allCategorias() {

        // if(true) throw new NullPointerException(); //Prueba de excepcion nullPointer
        return findCategoriaService.findAll().stream() // Convierte la lista en un flujo
                .map(CategoriaMapper::toResponse) // Mapeamos/Convertimos cada elemento del flujo (Producto) en un objeto
                // de
                // Respuesta (ProductoResponse)
                .toList(); // Lo devuelve como una lista.
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?>  deleteCategoria(@PathVariable int id) {
        deleteCategoriaService.delete(new CategoriaId(id)); //convertimos id en CategoriaId
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public CategoriaResponse editCategoria(@PathVariable int id, @RequestBody CategoriaRequest categoriaRequest){
        EditCategoriaCommand comando = CategoriaMapper.toCommand(id, categoriaRequest);
        Categoria categoria = editCategoriaService.update(comando);
        return  CategoriaMapper.toResponse(categoria); //Respuesta
    }
}
