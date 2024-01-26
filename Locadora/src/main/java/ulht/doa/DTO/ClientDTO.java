package ulht.doa.DTO;

import ulht.doa.entities.ClientEntity;
import ulht.doa.entities.ItemEntity;

import java.util.List;
import java.util.Objects;

public class ClientDTO {
    private Long id;
    private String name;
    private String cpf; String email;
    private String phone;
    private String birthDate;
    private String address;
    private List<ItemEntity> itemEntity;

    public ClientDTO(){}

    public ClientDTO(ClientEntity clientEntity, List<ItemEntity> itemEntity) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.address = address;
        this.itemEntity = itemEntity;
    }
    //Getters & Setters


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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ItemEntity> getItemEntity() {
        return itemEntity;
    }

    public void setItemEntity(List<ItemEntity> itemEntity) {
        this.itemEntity = itemEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDTO clientDTO = (ClientDTO) o;
        return Objects.equals(id, clientDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
