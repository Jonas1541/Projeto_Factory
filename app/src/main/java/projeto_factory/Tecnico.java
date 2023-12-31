package projeto_factory;

public class Tecnico implements iCurso {

    @Override
    public String Avaliacao(Estudante estudante) {
        boolean aprovadoEmTodas = true; // Assume que o estudante está aprovado até o final da verificação.

        for (Disciplina disciplina : estudante.getList()) {
            if ("Tecnico".equals(disciplina.getTipoCurso())) { // Verifica se a disciplina é do tipo 'Tecnico'.
                if (Double.parseDouble(disciplina.getNota()) < 7.0) {
                    disciplina.setStatus(false); // Atualiza o status para reprovado.
                    aprovadoEmTodas = false; // Marca que o estudante não está aprovado em todas as disciplinas.
                } else {
                    disciplina.setStatus(true); // Atualiza o status para aprovado.
                }
            }
        }

        // Depois de verificar todas as disciplinas, retorna o resultado.
        if (aprovadoEmTodas) {
            return "Aprovado no Curso Técnico.";
        } else {
            return "Reprovado no Curso Técnico.";
        }
    }
}
