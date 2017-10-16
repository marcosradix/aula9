package io.spring.boot.aula.repository;

import io.spring.boot.aula.entity.Usuario;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Nataniel Paiva <nataniel.paiva@gmail.com>
 */
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    public List<Usuario> findAllBy(TextCriteria criteria, Pageable pages);

    public List<Usuario> findByNomeLikeIgnoreCase(String nome);
    
}
