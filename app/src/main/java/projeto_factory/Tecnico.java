package projeto_factory;

public class Tecnico implements iCurso {

    @Override
    public String Avaliacao(Estudante estudante) {
        for (Disciplina disciplina : estudante.getList()) {
            if (disciplina.getNota() < 7.0) {
                return "Reprovado";
            }
        }
        return "Aprovado";
    }

}
