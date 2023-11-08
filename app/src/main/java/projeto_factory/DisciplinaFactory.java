package projeto_factory;

public class DisciplinaFactory {
    
    public Disciplina criarDisciplina(String nome, String nota, String tipoCurso) {
        if (!tipoCurso.equalsIgnoreCase("tecnico") &&
            !tipoCurso.equalsIgnoreCase("bacharelado") &&
            !tipoCurso.equalsIgnoreCase("mestrado")) {
            throw new IllegalArgumentException("Tipo de curso inválido: " + tipoCurso);
        }
        return new Disciplina(nome, nota, tipoCurso);
    }
}
