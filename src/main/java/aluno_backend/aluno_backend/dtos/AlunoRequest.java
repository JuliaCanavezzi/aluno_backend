package aluno_backend.aluno_backend.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AlunoRequest(

    @NotBlank(message = "Nome não pode ser em branco")
    @Size(min=3, message = "Tamanho mínimo para o nome é 3")
    String name,

    @NotNull(message = "Ativo não pode ser nulo")
    Boolean active,

    @NotBlank(message = "Período não pode ser em branco")
    @Size(min=3, message = "Tamanho mínimo para o período é 3")
    String period
) {

}
