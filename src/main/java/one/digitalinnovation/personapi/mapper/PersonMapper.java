package one.digitalinnovation.personapi.mapper;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    // Essa interface faz nosso DTO virar um objeto do banco de dados e vice-versa
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy") // Como os formatos das datas são diferentes, vamos alterar aqui para a forma que está no banco de dados.
    Person toModel(PersonDTO personDTO); // Repare que precisamos desse toModel, é uma convenção do Mapstruct

    PersonDTO toDTO(Person person);
}
