package projeto_factory;

public class Tecnico implements iCurso {

    @Override
    public String Avaliacao(Estudante estudante) {
        for (Disciplina disciplina : estudante.getList()) {
            if (Double.parseDouble(disciplina.getNota()) < 7.0) {
                return "Reprovado no Curso Técnico.";
            }
        }
        return "Aprovado no Curso Técnico.";
    }

}
