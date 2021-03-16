package one.digitalinnovation.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

// A pasta dto é responsável por receber todos dados, nesse caso da pessoa e telefone.
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String lastName;

    @NotEmpty
    @CPF // Aqui ele já faz a validação do CPF
    private String cpf;

    private String birthDate;

    @Valid // Aqui mostra que cada membro da lista precisa ser validado, através dos atributos que passamos.
    @NotEmpty
    private List<PhoneDTO> phones;
}
