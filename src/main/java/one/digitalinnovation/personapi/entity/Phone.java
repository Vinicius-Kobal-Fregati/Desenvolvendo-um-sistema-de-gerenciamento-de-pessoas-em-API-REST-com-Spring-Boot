package one.digitalinnovation.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.enums.PhoneType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Isso torna a classe uma entidade.
@Data //Automaticamente insere um get e set para nós, através do lombok.
@Builder //Nos permite verificar um padrão para a construção de objetos.
@AllArgsConstructor //Insere os construtores para nós.
@NoArgsConstructor
public class Phone {

    @Id // Por ser uma entidade, precisa do id.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Essa é a estratégia de geração. Esse tipo faz com que toda vez que adicionarmos um dado, ele seja incremental.
    private Long id;

    @Enumerated(EnumType.STRING)  // Como o PhoneType é um enum, precisamos colocar este arroba.
    @Column(nullable = false) // Aqui criamos uma regra no nosso banco de dados. Nesse caso, esse dado é definido como obrigatório.
    private PhoneType type;

    @Column(nullable = false)
    private String number;


}
