package projeto_factory;

public class CursoFactory {
    public iCurso getCurso(String tipoCurso) {
        if(tipoCurso.equalsIgnoreCase("Tecnico")) {
            return new Tecnico();
        }
        if(tipoCurso.equalsIgnoreCase("Bacharelado")) {
            return new BachareladoDecorator(new Tecnico());
        }
        if(tipoCurso.equalsIgnoreCase("Mestrado")) {
            return new MestradoDecorator(new BachareladoDecorator(new Tecnico()));
        }
        return null;
    }
}
