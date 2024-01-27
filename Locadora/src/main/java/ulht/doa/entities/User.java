package ulht.doa.entities;

import io.micronaut.core.annotation.Introspected;
import jakarta.persistence.*;

@Introspected
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String loginName;
    private String email;
    private String passwd;

    public User(Long id, String name, String loginName, String email, String passwd) {
        this.id = id;
        this.name = name;
        this.loginName = loginName;
        this.email = email;
        this.passwd = passwd;
    }

    public User() {}

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
