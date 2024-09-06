package aluno_backend.aluno_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import aluno_backend.aluno_backend.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno,Integer>{
    
}
