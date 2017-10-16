package io.spring.boot.aula.entity;

import org.springframework.data.mongodb.core.index.TextIndexed;

/**
 *
 * @author Nataniel Paiva <nataniel.paiva@gmail.com>
 */
public class Usuario extends EntidadeGenerica {

    @TextIndexed
    private String nome;

    @TextIndexed
    private String sobrenome;
    
    private String foto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    

}
