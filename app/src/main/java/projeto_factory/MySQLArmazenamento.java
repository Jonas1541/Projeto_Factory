package projeto_factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class MySQLArmazenamento implements iArmazenamento {

    @Override
    public void adicionarEstudante(Estudante estudante) {
        try (Connection connection = App.getConnection()) {
            // Primeiro, insira os detalhes do aluno na tabela 'estudantes'
            String sql = "INSERT INTO estudantes (nome, disciplinas) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, estudante.getNome());

                // Converte a lista de disciplinas em formato JSON
                Gson gson = new Gson();
                String disciplinasJSON = gson.toJson(estudante.getList());

                statement.setString(2, disciplinasJSON);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Estudante> listarEstudante() {
        List<Estudante> estudantes = new ArrayList<>();
        try (Connection connection = App.getConnection()) {
            String sql = "SELECT * FROM estudantes";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String nome = resultSet.getString("nome");

                        // Recupera a lista de disciplinas em formato JSON
                        String disciplinasJSON = resultSet.getString("disciplinas");

                        // Converte o JSON de disciplinas de volta para uma lista de disciplinas
                        Gson gson = new Gson();
                        List<Disciplina> disciplinas = gson.fromJson(disciplinasJSON, List.class);

                        Estudante estudante = new Estudante(nome);
                        estudante.setList(disciplinas);
                        estudantes.add(estudante);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudantes;
    }
}
