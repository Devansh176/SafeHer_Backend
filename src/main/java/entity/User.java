package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "uuid")
    private UUID uid;

    @Column(unique = true, nullable = false, name = "email")
    private String email;

    @Column(nullable = false, name = "display_name")
    private String displayName;

    @Column(name = "password")
    private String password;

    public User() {}

    public User(String email, String displayName, String password) {
        this.email = email;
        this.displayName = displayName;
        this.password = password;
    }
}
