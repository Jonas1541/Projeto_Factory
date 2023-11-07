package projeto_factory;

public class Disciplina {
    String nome;
    String nota;
    String tipoCurso;
    boolean status;

    public Disciplina(String nome, String nota, String tipoCurso) {
        this.nome = nome;
        this.nota = nota;
        this.tipoCurso = tipoCurso;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(String tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
}
