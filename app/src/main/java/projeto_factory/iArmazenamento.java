package projeto_factory;

import java.util.List;

public interface iArmazenamento {
    void adicionarEstudante(Estudante estudante);
    List<Estudante> listarEstudante();
}
