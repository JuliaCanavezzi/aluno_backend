package aluno_backend.aluno_backend.resources;

import org.springframework.web.bind.annotation.RestController;
import aluno_backend.aluno_backend.entities.Aluno;
import aluno_backend.aluno_backend.repositories.AlunoRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController // anotação do spring framework dizendo que essa classe através dessa anotação atende chamadas http
public class AlunoController {

        @Autowired // sping cria e injeta AlunoRepository
        private AlunoRepository repository;

        @GetMapping("hello")
        public String hello(){ // esse método chama hello, devolve uma string.
            return "Hello from Aluno Backend";
        }
        
        @GetMapping("students")
        public List<Aluno> getAlunos(){
            return repository.findAll(); //devolve a lista
        }
}
