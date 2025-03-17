package payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GoogleLoginRequest {
    private String googleToken;

    public GoogleLoginRequest() {}

    public GoogleLoginRequest(String googleToken) {
        this.googleToken = googleToken;
    }
}
