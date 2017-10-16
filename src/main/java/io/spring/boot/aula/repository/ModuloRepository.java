package io.spring.boot.aula.repository;

import io.spring.boot.aula.entity.Modulo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Nataniel Paiva <nataniel.paiva@gmail.com>
 */
public interface ModuloRepository extends MongoRepository<Modulo, String> {
    
}
