package projeto_factory;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public class MongoDBArmazenamento implements iArmazenamento {

    private MongoCollection<Document> estudantesCollection;

    public MongoDBArmazenamento(MongoCollection<Document> estudantesCollection) {
        this.estudantesCollection = estudantesCollection;
    }

    @Override
    public void adicionarEstudante(Estudante estudante) {
        // Crie um documento para representar o estudante
        Document documentoEstudante = new Document("nome", estudante.getNome())
                .append("disciplinas", converterDisciplinasParaDocument(estudante.getList()));

        // Insira o documento na coleção
        estudantesCollection.insertOne(documentoEstudante);
    }

    @Override
    public List<Estudante> listarEstudante() {
        List<Estudante> estudantes = new ArrayList<>();

        // Consulta no banco de dados MongoDB para encontrar todos os documentos
        MongoCursor<Document> cursor = estudantesCollection.find().iterator();

        while (cursor.hasNext()) {
            Document documento = cursor.next();
            // Crie um objeto Estudante com os dados do documento
            String nome = documento.getString("nome");
            List<Disciplina> disciplinas = converterDocumentParaDisciplinas(documento.get("disciplinas", List.class));
            Estudante estudante = new Estudante(nome);
            estudante.setList(disciplinas);
            estudantes.add(estudante);
        }

        return estudantes;
    }

    // Método para converter uma lista de objetos Disciplina para uma lista de Document
    private List<Document> converterDisciplinasParaDocument(List<Disciplina> disciplinas) {
        List<Document> documentosDisciplinas = new ArrayList<>();
        for (Disciplina disciplina : disciplinas) {
            Document documentoDisciplina = new Document()
                .append("nome", disciplina.getNome())
                .append("nota", disciplina.getNota())
                .append("tipoCurso", disciplina.getTipoCurso())
                .append("status", disciplina.isStatus());
            documentosDisciplinas.add(documentoDisciplina);
        }
        return documentosDisciplinas;
    }

    // Método para converter uma lista de Document para uma lista de objetos Disciplina
    private List<Disciplina> converterDocumentParaDisciplinas(List<Document> documentos) {
        List<Disciplina> disciplinas = new ArrayList<>();
        for (Document documento : documentos) {
            String nome = documento.getString("nome");
            String nota = documento.getString("nota");
            String tipoCurso = documento.getString("tipoCurso");
            boolean status = documento.getBoolean("status");
            Disciplina disciplina = new Disciplina(nome, nota, tipoCurso);
            disciplina.setStatus(status);
            disciplinas.add(disciplina);
        }
        return disciplinas;
    }
}
