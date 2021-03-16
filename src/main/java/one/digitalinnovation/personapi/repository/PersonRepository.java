package one.digitalinnovation.personapi.repository;

import one.digitalinnovation.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> { // Extendemos a JpaRepository, passando person como a entidade que queremos gerenciar e o tipo dela (id) como long.
} // Isso nos dá todas as operações básicas do banco de dados.
