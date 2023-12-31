/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package projeto_factory;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) {

        // Instanciar a fábrica de escola
        EscolaFactory escolaFactory = new EscolaFactory();

        // Instanciar a fábrica de disciplinas
        DisciplinaFactory disciplinaFactory = new DisciplinaFactory();

        // Utilizar o método criarDisciplina da fábrica de disciplinas para criar as
        // disciplinas
        Disciplina matematica = disciplinaFactory.criarDisciplina("Matematica", "5.0", "Tecnico");
        Disciplina historia = disciplinaFactory.criarDisciplina("Historia", "8.0", "Bacharelado");

        // Utilizar o método criarEstudanteComCursoEDisciplinas para criar o estudante
        // com curso e disciplinas
        // Note que você deve passar o tipo de curso e as disciplinas como argumentos
        Estudante estudante = escolaFactory.criarEstudanteComCursoEDisciplinas("Testador", "Bacharelado", matematica,
                historia);

        // A avaliação do estudante agora é feita dentro do método
        // criarEstudanteComCursoEDisciplinas,
        // portanto, não é necessária uma chamada explícita aqui. Se precisar do
        // resultado da avaliação,
        // deve-se ajustar o método Avaliacao para retornar algum valor e capturá-lo
        // após a criação do estudante.

        // Armazenamento de estudantes no MongoDB
        try {
            DBFactory.Armazenar("MongoDB", estudante);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Armazenamento de estudantes no MySQL
        try {
            DBFactory.Armazenar("MySQL", estudante);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Exibir estudantes do MongoDB
        try {
            DBFactory.ExibirEstudantes("MongoDB");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Exibir estudantes do MySQL
        try {
            DBFactory.ExibirEstudantes("MySQL");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
