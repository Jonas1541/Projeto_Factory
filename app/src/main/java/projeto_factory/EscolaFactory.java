package projeto_factory;

import java.util.ArrayList;
import java.util.List;

public class EscolaFactory {

    private CursoFactory cursoFactory;

    public EscolaFactory() {
        this.cursoFactory = new CursoFactory();
    }

    public Estudante criarEstudanteComCursoEDisciplinas(String nomeEstudante, String tipoCurso, Disciplina... disciplinas) {
        Estudante estudante = new Estudante(nomeEstudante);
        iCurso curso = cursoFactory.getCurso(tipoCurso);

        if (curso == null) {
            throw new IllegalArgumentException("Tipo de curso inválido: " + tipoCurso);
        }

        List<Disciplina> listaDisciplinas = new ArrayList<>();
        for (Disciplina disciplina : disciplinas) {
            listaDisciplinas.add(disciplina);
        }

        for (Disciplina disciplina : listaDisciplinas) {
            estudante.addDisciplina(disciplina);
        }

        curso.Avaliacao(estudante);

        return estudante;
    }
}
