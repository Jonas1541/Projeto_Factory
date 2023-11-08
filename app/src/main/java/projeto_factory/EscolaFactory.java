package projeto_factory;

import java.util.Arrays;
import java.util.List;

public class EscolaFactory {

    private CursoFactory cursoFactory;

    public EscolaFactory() {
        this.cursoFactory = new CursoFactory();
    }

    public Estudante criarEstudanteComCursoEDisciplinas(String nomeEstudante, String tipoCurso, Disciplina... disciplinas) {
        Estudante estudante = new Estudante(nomeEstudante);
        iCurso curso = cursoFactory.getCurso(tipoCurso);

        List<Disciplina> listaDisciplinas = Arrays.asList(disciplinas);
        for (Disciplina disciplina : listaDisciplinas) {
            estudante.addDisciplina(disciplina);
        }

        // Aqui você pode associar o curso ao estudante, se necessário
        // ...

        return estudante;
    }
}
