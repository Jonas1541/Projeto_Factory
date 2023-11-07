package projeto_factory;

public class BachareladoDecorator extends CursoDecorator{

    public BachareladoDecorator(iCurso curso) {
        super(curso); //Vai receber uma instãncia de Técnico.
    }

    @Override
    public String Avaliacao(Estudante estudante) {
        boolean aprovadoEmTodas = true; // Assume que o estudante está aprovado até o final da verificação.

        for (Disciplina disciplina : estudante.getList()) {
            if ("Bacharelado".equalsIgnoreCase(disciplina.getTipoCurso())) { // Verifica se a disciplina é do tipo 'Bacharelado'.
                if (Double.parseDouble(disciplina.getNota()) < 6.0) {
                    disciplina.setStatus(false); // Atualiza o status para reprovado.
                    aprovadoEmTodas = false; // Marca que o estudante não está aprovado em todas as disciplinas.
                } else {
                    disciplina.setStatus(true); // Atualiza o status para aprovado.
                }
            }
        }

        // Depois de verificar todas as disciplinas, retorna o resultado.
        if (aprovadoEmTodas) {
            return "Aprovado no Curso de Bacharelado e" + curso.Avaliacao(estudante);
        } else {
            return "Reprovado no Curso de Bacharelado e " + curso.Avaliacao(estudante);
        }
    }
    
}
