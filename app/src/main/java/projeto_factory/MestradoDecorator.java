package projeto_factory;

public class MestradoDecorator extends CursoDecorator{

    public MestradoDecorator(iCurso curso) {
        super(curso); //Vai receber uma instância de BachareladoDecorator
    }

    @Override
    public String Avaliacao(Estudante estudante) {
        boolean aprovadoEmTodas = true; // Assume que o estudante está aprovado até encontrar uma disciplina com conceito D.

        for (Disciplina disciplina : estudante.getList()) {
            if ("mestrado".equalsIgnoreCase(disciplina.getTipoCurso())) { // Verifica se a disciplina é do tipo 'Mestrado'.
                if (disciplina.getNota().equalsIgnoreCase("D")) {
                    disciplina.setStatus(false); // Atualiza o status para reprovado.
                    aprovadoEmTodas = false; // Marca que o estudante não está aprovado em todas as disciplinas.
                } else {
                    disciplina.setStatus(true); // Atualiza o status para aprovado.
                }
            }
        }

        // Depois de verificar todas as disciplinas, retorna o resultado.
        if (aprovadoEmTodas) {
            return "Aprovado no Curso de Mestrado e" + curso.Avaliacao(estudante);
        } else {
            return "Reprovado no Curso de Mestrado e" + curso.Avaliacao(estudante);
        }
    }
    
}
