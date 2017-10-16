package io.spring.boot.aula.repository;

import io.spring.boot.aula.entity.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Nataniel Paiva <nataniel.paiva@gmail.com>
 */
public interface AlunoRepository extends MongoRepository<Aluno, String> {
    
}
