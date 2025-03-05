package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int uid;

    @Column(unique = true, nullable = false, name = "email")
    private String email;

    @Column(nullable = false, name = "displayName")
    private String displayName;
}
