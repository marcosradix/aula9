package io.spring.boot.aula.config;

/*
*
* Aula com Nataniel Paiva
*
* Esse projeto poderá ser distribuído da forma que você achar melhor
* O importante é que você aprenda de verdade!
*
 */
import io.spring.boot.aula.entity.Aluno;
import io.spring.boot.aula.entity.Modulo;
import io.spring.boot.aula.repository.AlunoRepository;
import io.spring.boot.aula.repository.DiarioRepository;
import io.spring.boot.aula.repository.ModuloRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author Nataniel Paiva <nataniel.paiva@gmail.com>
 */
@Component
public class CargaInicial implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    ModuloRepository moduloRepository;

    @Autowired
    DiarioRepository diarioRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {

        List<Aluno> alunos = alunoRepository.findAll();

        if (alunos.size() == 0) {
            try {
                this.criarAluno("Nataniel", "1991-04-10");
                this.criarAluno("Fulano", "1991-04-10");
                this.criarAluno("Ciclano", "1991-04-10");
                this.criarAluno("João", "1991-04-10");
                this.criarAluno("Maria", "1991-04-10");
            } catch (ParseException ex) {
                Logger.getLogger(CargaInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        List<Modulo> modulos = moduloRepository.findAll();

        if (modulos.size() == 0) {
            this.criarModulo("Modulo 1");
            this.criarModulo("Modulo 2");
        }

    }

    private void criarModulo(String nome) {
        Modulo modulo = new Modulo();

        modulo.setNome(nome);

        moduloRepository.save(modulo);
    }

    private void criarAluno(String nome, String dataNascimento) throws ParseException {
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date data = formato.parse(dataNascimento);
        aluno.setDtNascimento(data);

        alunoRepository.save(aluno);

    }

}
