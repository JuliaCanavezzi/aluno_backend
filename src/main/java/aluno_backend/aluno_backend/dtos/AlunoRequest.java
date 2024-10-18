package aluno_backend.aluno_backend.dtos;

public record AlunoRequest(
    String name,
    Boolean active,
    String period
) {

}
