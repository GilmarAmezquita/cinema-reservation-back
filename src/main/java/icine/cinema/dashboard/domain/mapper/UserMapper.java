package icine.cinema.dashboard.domain.mapper;

import icine.cinema.dashboard.domain.dto.request.UserRequestDTO;
import icine.cinema.dashboard.domain.dto.response.UserResponseDTO;
import icine.cinema.dashboard.infrastructure.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserRequestDTO userRequestDTO);
    UserResponseDTO toDTO(User user);
}
