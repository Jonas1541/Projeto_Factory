package projeto_factory;

public abstract class CursoDecorator implements iCurso{
    iCurso curso;

    public CursoDecorator(iCurso curso) {
        this.curso = curso;
    }
}
