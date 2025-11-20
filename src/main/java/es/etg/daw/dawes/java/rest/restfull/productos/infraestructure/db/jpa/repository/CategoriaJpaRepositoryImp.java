package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.jpa.repository;

import java.util.List;
import java.util.Optional;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Categoria;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.CategoriaId;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.CategoriaRepository;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.jpa.entity.CategoriaEntity;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.mapper.CategoriaMapper;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CategoriaJpaRepositoryImp implements CategoriaRepository {
    
    private final CategoriaRepositoryJpa repository;

    @Override
    public Categoria save(Categoria t) {

        CategoriaEntity cat = CategoriaMapper.toEntity(t);
        return CategoriaMapper.toDomain(repository.save(cat));
    }

    @Override
    public List<Categoria> getAll() {
        return CategoriaMapper.toDomain(repository.findAll());
    }

    @Override
    public Optional<Categoria> getById(CategoriaId id) {
        Optional<Categoria> Categoria = null;
        Optional<CategoriaEntity> ce = repository.findById(id.getValue());

        if(ce.isEmpty()){
            Categoria = Optional.empty();
        }else{
            Categoria = Optional.of(CategoriaMapper.toDomain(ce.get()));
        }

        return Categoria;
    }

    @Override
    public void deleteById(CategoriaId id) {
        repository.deleteById(id.getValue());
    }

    @Override
    public Optional<Categoria> getByName(String name) {
        CategoriaEntity cat = repository.findByNombre(name);
        if(cat!=null)
            return Optional.of(CategoriaMapper.toDomain(cat));
        else
            return Optional.empty() ;
    }

    // Hereda automáticamente métodos como: save(), findById(), findAll(), delete(), etc.

}
