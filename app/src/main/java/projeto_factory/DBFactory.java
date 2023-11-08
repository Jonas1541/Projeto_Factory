package projeto_factory;

import java.util.List;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBFactory {

    public static void Armazenar(String dbType, Estudante estudante) throws SQLException {
        iArmazenamento armazenamento = getArmazenamento(dbType);
        Armazenador armazenador = new Armazenador(armazenamento);
        armazenador.adicionarEstudante(estudante);
    }

    public static void ExibirEstudantes(String dbType) throws SQLException {
        iArmazenamento armazenamento = getArmazenamento(dbType);
        Armazenador armazenador = new Armazenador(armazenamento);
        List<Estudante> estudantes = armazenador.listarEstudantes();

        System.out.println("------------------------------------------------------------");
        System.out.println("Estudantes Cadastrados:");
        for (Estudante estudante : estudantes) {
            System.out.println("Nome: " + estudante.getNome());
        }
        System.out.println("------------------------------------------------------------");
    }

    private static iArmazenamento getArmazenamento(String dbType) throws SQLException {
        if (dbType.equalsIgnoreCase("MongoDB")) {
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase database = mongoClient.getDatabase("estudantesDB");
            MongoCollection<Document> collection = database.getCollection("estudantesCollection");
            return new MongoDBArmazenamento(collection);
        } else if (dbType.equalsIgnoreCase("MySQL")) {
            Connection connection = getConnection();
            return new MySQLArmazenamento(connection);
        } else {
            throw new IllegalArgumentException("Tipo de banco de dados não suportado.");
        }
    }

    private static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/SQLdb";
        String user = "root";
        String password = "nova_senha";
        return DriverManager.getConnection(url, user, password);
    }
}
