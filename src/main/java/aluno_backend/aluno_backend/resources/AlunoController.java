package aluno_backend.aluno_backend.resources;

import org.springframework.web.bind.annotation.RestController;
import aluno_backend.aluno_backend.entities.Aluno;
import aluno_backend.aluno_backend.services.AlunoService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController // anotação do spring framework dizendo que essa classe através dessa anotação atende chamadas http
public class AlunoController {

        @Autowired
        private AlunoService service;

        
        @GetMapping("students")
        public List<Aluno> getAlunos(){
            return service.getAlunos(); //chama o serviço, devolve os alunos
        }
}
