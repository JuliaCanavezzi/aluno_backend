package aluno_backend.aluno_backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aluno_backend.aluno_backend.dtos.AlunoRequest;
import aluno_backend.aluno_backend.entities.Aluno;
import aluno_backend.aluno_backend.mappers.AlunoMapper;
import aluno_backend.aluno_backend.repositories.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service //indica que essa classe é um serviço, e pode ser injetado em qualquer lugar
public class AlunoService {

    @Autowired // sping cria e injeta AlunoRepository dentro do Controller
    private AlunoRepository repository;
    
    public List<Aluno> getAlunos(){
        return repository.findAll();
        
    }

    public Aluno getAlunoById(int id ){
        return repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Aluno não cadastrado")
        );
    }

    public Aluno save(AlunoRequest dtoRequestAluno){
        return repository.save(AlunoMapper.toEntity(dtoRequestAluno));
    }

    public void deleteByid(int id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Aluno não cadastrado");
        }
    }

    public void update(int id, AlunoRequest dtoRequestAluno){
        Aluno aux = repository.getReferenceById(id);
        aux.setName(dtoRequestAluno.name());
        aux.setPeriod(dtoRequestAluno.period());
        aux.setActive(dtoRequestAluno.active());
        repository.save(aux);
    }
}
