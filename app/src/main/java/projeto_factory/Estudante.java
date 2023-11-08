package projeto_factory;

import java.util.ArrayList;
import java.util.List;

public class Estudante {
    String nome;

    List<Disciplina> list = new ArrayList<>();

    public Estudante(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getList() {
        return list;
    }

    public void addDisciplina(Disciplina disciplina) {
        list.add(disciplina);
    }

}
