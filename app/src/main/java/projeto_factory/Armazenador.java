package projeto_factory;

import java.util.List;

public class Armazenador {
    private iArmazenamento armazenamento;
    
    public Armazenador(iArmazenamento armazenamento) {
        this.armazenamento = armazenamento;
    }

    public void adicionarEstudante(Estudante estudante) {
        armazenamento.adicionarEstudante(estudante);
    }

    public List<Estudante> listarEstudantes() {
        return armazenamento.listarEstudante();
    }
}
