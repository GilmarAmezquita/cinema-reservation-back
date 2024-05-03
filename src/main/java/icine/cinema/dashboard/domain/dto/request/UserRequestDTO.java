package icine.cinema.dashboard.domain.dto.request;

public record UserRequestDTO(
        long id,
        String email,
        String password,
        String address,
        String firstName,
        String lastName) {
}
