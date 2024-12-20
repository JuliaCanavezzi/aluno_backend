package aluno_backend.aluno_backend.resources;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import aluno_backend.aluno_backend.dtos.AlunoRequest;
import aluno_backend.aluno_backend.dtos.AlunoResponse;
import aluno_backend.aluno_backend.services.AlunoService;
import jakarta.validation.Valid;

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
        public ResponseEntity <List<AlunoResponse>> getAlunos(){
            return ResponseEntity.ok(service.getAlunos()); //chama o serviço, devolve os alunos
        }

        @GetMapping("students/{id}")
        public ResponseEntity <AlunoResponse> getAlunoById(@PathVariable int id){
            return ResponseEntity.ok(service.getAlunoById(id)); 
        }

        @PostMapping("students")
        public ResponseEntity <AlunoResponse> save(@Valid @RequestBody AlunoRequest aluno){
            AlunoResponse novoAluno = service.save(aluno);

            URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(novoAluno.id())
                            .toUri();

            return ResponseEntity.created(location).body(novoAluno);
        }

        @DeleteMapping("students/{id}")
        public ResponseEntity<Void> deleteById(@PathVariable int id){
            service.deleteByid(id);
           return ResponseEntity.noContent().build();
        }

        @PutMapping("students/{id}")
        public ResponseEntity<Void> update(@PathVariable int id, 
                           @RequestBody AlunoRequest aluno){
            service.update(id, aluno);
            return ResponseEntity.ok().build();
        }  
}
