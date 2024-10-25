package aluno_backend.aluno_backend.dtos;

public record AlunoResponse(
    Integer id,
    String name,
    Boolean active,
    String period
) {
}
