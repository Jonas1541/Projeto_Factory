package projeto_factory;

import java.util.ArrayList;
import java.util.List;

public class Estudante {
    String nome;
    iCurso curso;

    List<Disciplina> list = new ArrayList<>();

    public Estudante(String nome, iCurso curso) {
        this.nome = nome;
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public iCurso getCurso() {
        return curso;
    }

    public void setCurso(iCurso curso) {
        this.curso = curso;
    }

    public List<Disciplina> getList() {
        return list;
    }

    public void setList(Disciplina disciplina) {
        list.add(disciplina);
    }

}
