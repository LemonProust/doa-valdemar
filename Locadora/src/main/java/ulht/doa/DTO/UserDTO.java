package ulht.doa.DTO;

import ulht.doa.entities.UserEntity;

import java.beans.BeanProperty;
import java.beans.Beans;
import java.util.Objects;

public class UserDTO {
    private Long id;
    private String name;
    private String loginName;
    private String email;
    private String passwd;

    public UserDTO(){}

    public UserDTO(UserEntity userEntity){
        this.id = userEntity.getId();
        this.name = userEntity.getName();
        this.loginName = userEntity.getLoginName();
        this.email = userEntity.getEmail();
        this.passwd = userEntity.getPasswd();
    }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(id, userDTO.id) && Objects.equals(name, userDTO.name) && Objects.equals(loginName, userDTO.loginName) && Objects.equals(email, userDTO.email) && Objects.equals(passwd, userDTO.passwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, loginName, email, passwd);
    }
}
