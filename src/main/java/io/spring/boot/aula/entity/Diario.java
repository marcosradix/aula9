package io.spring.boot.aula.entity;

import java.util.Date;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 *
 * @author Nataniel Paiva <nataniel.paiva@gmail.com>
 */
public class Diario extends EntidadeGenerica {

    private Date data;

    @DBRef
    private Aluno aluno;
    
    @DBRef
    private Modulo modulo;

    private boolean presenca;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public boolean isPresenca() {
        return presenca;
    }

    public void setPresenca(boolean presenca) {
        this.presenca = presenca;
    }

}
