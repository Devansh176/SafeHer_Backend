package payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthResponse {
    private String token;
    public AuthResponse() {}
    public AuthResponse(String token) {
        this.token = token;
    }
}
