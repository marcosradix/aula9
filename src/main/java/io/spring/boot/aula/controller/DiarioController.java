package io.spring.boot.aula.controller;

import io.spring.boot.aula.entity.Aluno;
import io.spring.boot.aula.entity.Diario;
import io.spring.boot.aula.entity.Modulo;
import io.spring.boot.aula.repository.AlunoRepository;
import io.spring.boot.aula.repository.DiarioRepository;
import io.spring.boot.aula.repository.ModuloRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nataniel Paiva <nataniel.paiva@gmail.com>
 */
@RestController
public class DiarioController {

    @Autowired
    DiarioRepository repository;

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    ModuloRepository moduloRepository;

    @RequestMapping(value = "/diario", method = RequestMethod.GET)
    public List<Diario> list() {
        return repository.findAll();
    }

    @RequestMapping(value = "/diario/{idAluno}/aluno", method = RequestMethod.GET)
    public List<Diario> findByAluno(@PathVariable String idAluno) {
        Aluno aluno = alunoRepository.findOne(idAluno);

        return repository.findByAluno(aluno);
    }

    @RequestMapping(value = "/diario/{idModulo}/modulo", method = RequestMethod.GET)
    public List<Diario> findByModulo(@PathVariable String idModulo) {
        Modulo modulo = moduloRepository.findOne(idModulo);

        return repository.findByModulo(modulo);
    }

    @RequestMapping(value = "/diario/{de}/{ate}", method = RequestMethod.GET)
    public List<Diario> list(@PathVariable String de, @PathVariable String ate) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date dataDe = formato.parse(de);
        Date dataAte = formato.parse(ate);

        return repository.findByDataBetween(dataDe, dataAte);
    }

    @RequestMapping(value = "/diario", method = RequestMethod.POST)
    public Diario save(@RequestBody Diario diario) {
        return repository.save(diario);
    }

    @RequestMapping(value = "/diario", method = RequestMethod.PUT)
    public Diario edit(@RequestBody Diario diario) {
        return repository.save(diario);
    }

    @RequestMapping(value = "/diario/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        repository.delete(id);
    }

}
