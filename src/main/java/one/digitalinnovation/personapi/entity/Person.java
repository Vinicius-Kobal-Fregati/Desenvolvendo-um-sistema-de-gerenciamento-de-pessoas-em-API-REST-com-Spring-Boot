package one.digitalinnovation.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id // Basicamente mesma coisa que no arquivo Phone.java.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true) // Com o unique = true, dizemos que o cpf tem que ser único.
    private String cpf;

    private LocalDate birthDate; // Esse é o único não obrigatório.

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}) // Aqui temos o relacionamento das tabelas, esse faz com que uma pessoa possa ter vários números de telefone. Lazy é utilizado para performance o cascade insere uma pessoa já com o telefone relacionado, com essa opção podemos criar só a pessoa no momento de fazer o persist, merfe e remove.
    private List<Phone> phones;
}
