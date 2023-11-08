package projeto_factory;

public class CursoFactory {
    public iCurso getCurso(String tipoCurso) {
        if(tipoCurso.equalsIgnoreCase("Tecnico")) {
            return new Tecnico();
        }
        else if(tipoCurso.equalsIgnoreCase("Bacharelado")) {
            return new BachareladoDecorator(new Tecnico());
        }
        else if(tipoCurso.equalsIgnoreCase("Mestrado")) {
            return new MestradoDecorator(new BachareladoDecorator(new Tecnico()));
        }
        else {
            throw new IllegalArgumentException("Tipo de curso não suportado: " + tipoCurso);
        }
    }
}
