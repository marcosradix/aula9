package io.spring.boot.aula.repository;

import io.spring.boot.aula.entity.Aluno;
import io.spring.boot.aula.entity.Diario;
import io.spring.boot.aula.entity.Modulo;
import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Nataniel Paiva <nataniel.paiva@gmail.com>
 */
public interface DiarioRepository extends MongoRepository<Diario, String> {
    
    
    List<Diario> findByAluno(Aluno aluno);
    
    List<Diario> findByModulo(Modulo modulo);

    List<Diario> findByDataBetween(Date dataDe, Date dataAte);
    
}
