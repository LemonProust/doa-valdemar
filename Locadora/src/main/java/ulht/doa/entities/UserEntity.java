package ulht.doa.entities;

import io.micronaut.core.annotation.Introspected;
import jakarta.persistence.*;
import ulht.doa.DTO.UserDTO;

@Introspected
@Entity
@Table(name = "UserTB")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String loginName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String passwd;

    // Empty method constructor
    public UserEntity() {}

    // Method constructor
    public UserEntity(UserDTO userDTO) {
        this.id = id;
        this.name = name;
        this.loginName = loginName;
        this.email = email;
        this.passwd = passwd;
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
