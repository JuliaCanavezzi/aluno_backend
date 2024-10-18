package aluno_backend.aluno_backend.mappers;

import aluno_backend.aluno_backend.dtos.AlunoRequest;
import aluno_backend.aluno_backend.entities.Aluno;

public class AlunoMapper {
    
    public static Aluno toEntity(AlunoRequest request){
        Aluno aluno = new Aluno();
        aluno.setActive(request.active());
        aluno.setName(request.name());
        aluno.setPeriod(request.period());
        return aluno;
    }
}