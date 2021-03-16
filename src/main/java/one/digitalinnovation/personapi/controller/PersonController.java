package one.digitalinnovation.personapi.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.exception.PersonNotFoundException;
import one.digitalinnovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController //É um controlador através da api Rest.
@RequestMapping("/api/v1/people") //Esse é o nosso caminho de acesso principal da nossa api. O v1 é o versionamento da api.
@AllArgsConstructor(onConstructor = @__(@Autowired)) // O @Autowired faz com que o spring injete uma implementação do tipo repository. Injetando dentro de um construtor, facilitamos nossos testes.
public class PersonController { //Esse é o nosso ponto de entrada do projeto

    private PersonService personService; // Fizemos a injeção de dependência do personService.

    @PostMapping // Isso nos permite fazer a criação de um usuário.
    @ResponseStatus(HttpStatus.CREATED) // Isso é do próprio spring, já nos fornece o código 201.
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) { // O @RequestBody nos indica que esse dado é adquirido através de uma requisição do tipo pessoas.
        return personService.createPerson(personDTO);
    }

    @GetMapping //Toda nossa requisição no browser acontece através do get.
    public List<PersonDTO> listAll() {
        return personService.listAll();
    } // Aqui vamos ter o retorno de todos os dados

    @GetMapping("/{id}") // Com esse /{id} nós vamos especificar pelo id qual usuário queremos
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException { // O PathVariable funciona como um request body post, aqui em uma requisição HTTP mostramos que estamos passando como variável o id da pessoa
        return personService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
        return personService.updateById(id, personDTO); // Aqui vamos fazer a atualização através do id
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException { // Lançamos uma exceção caso não encontre o usuário
        personService.delete(id);
    }
}
