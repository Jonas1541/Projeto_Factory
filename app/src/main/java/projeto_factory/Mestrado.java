package projeto_factory;

public class Mestrado implements iCurso{

    @Override
    public String Avaliacao(Estudante estudante) {
        for (Disciplina disciplina : estudante.getList()) {
            if (disciplina.getNota().equalsIgnoreCase("D")) {
                return "Reprovado";
            }
        }
        return "Aprovado";
    }
    
}
