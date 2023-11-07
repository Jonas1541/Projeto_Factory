package projeto_factory;

public class Bacharelado implements iCurso {

    @Override
    public String Avaliacao(Estudante estudante) {
        for (Disciplina disciplina : estudante.getList()) {
            if (Double.parseDouble(disciplina.getNota()) < 6.0) {
                return "Reprovado";
            }
        }
        return "Aprovado";
    }
}
