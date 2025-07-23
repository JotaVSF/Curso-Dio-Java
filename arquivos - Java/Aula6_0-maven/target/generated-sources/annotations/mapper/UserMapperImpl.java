package mapper;

import br.com.dio.DTO.UserDTO;
import javax.annotation.processing.Generated;
import model.UserModel;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-22T18:49:44-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserModel toModel(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setCode( dto.getId() );
        userModel.setUserName( dto.getName() );
        userModel.setBirthday( dto.getBirthday() );

        return userModel;
    }

    @Override
    public UserDTO toDTO(UserModel model) {
        if ( model == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( model.getCode() );
        userDTO.setName( model.getUserName() );
        userDTO.setBirthday( model.getBirthday() );

        return userDTO;
    }
}
