/* Testando o Maven. Oq é?
O Maven é uma ferramenta de automação de build e gerenciamento de projetos,
amplamente utilizada em projetos Java, para automatizar tarefas como a compilação do código,
o gerenciamento de dependências e a criação de pacotes.
Ele simplifica o processo de desenvolvimento, oferecendo uma estrutura padronizada
 */
import br.com.dio.DTO.UserDTO;
import mapper.UserMapper;
import model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.time.LocalDate;

public class Main {

    private static UserMapper mapper= Mappers.getMapper(UserMapper.class);

    public static void main(String[] args) {

        var model = new UserModel();
        model.setCode(1);
        model.setUserName("Joao");
        model.setBirthday(LocalDate.now().minusYears(20));
        var dto = new UserDTO();
        System.out.println(mapper.toDTO(model));
        dto.setId(2);
        dto.setName("Maria");
        dto.setBirthday(LocalDate.now().minusYears(30));
        System.out.println(mapper.toModel(dto));
    }
}
