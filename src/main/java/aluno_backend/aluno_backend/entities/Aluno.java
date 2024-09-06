package aluno_backend.aluno_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //essa classe possui algum relacionamento com alguma tabela do banco de dados
public class Aluno {

    @Id //chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //chave primária vai ser gerada pelo banco
    private Integer id;

    private String name;
    private Boolean active;
    private String period;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public String getPeriod() {
        return period;
    }
    public void setPeriod(String period) {
        this.period = period;
    }
    
}
