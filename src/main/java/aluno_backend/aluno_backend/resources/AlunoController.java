package aluno_backend.aluno_backend.resources;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import aluno_backend.aluno_backend.entities.Aluno;
import aluno_backend.aluno_backend.services.AlunoService;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController // anotação do spring framework dizendo que essa classe através dessa anotação atende chamadas http
public class AlunoController {

        @Autowired
        private AlunoService service;

        
        @GetMapping("students")
        public ResponseEntity <List<Aluno>> getAlunos(){
            return ResponseEntity.ok(service.getAlunos()); //chama o serviço, devolve os alunos
        }

        @GetMapping("students/{id}")
        public ResponseEntity <Aluno> getAlunoById(@PathVariable int id){
            return ResponseEntity.ok(service.getAlunoById(id)); 
        }

        @PostMapping("students")
        public ResponseEntity <Aluno> save (@RequestBody Aluno aluno){
            Aluno novoAluno = service.save(aluno);

            URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(novoAluno.getId())
                            .toUri();

            return ResponseEntity.created(location).body(novoAluno);
        }

        @DeleteMapping("students/{id}")
        public void deleteById(@PathVariable int id){
            service.deleteByid(id);
        }

        @PutMapping("students/{id}")
        public void update(@PathVariable int id, 
                           @RequestBody Aluno aluno){
            service.update(id, aluno);
        }  
}
