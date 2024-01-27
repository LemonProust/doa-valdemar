package ulht.doa.DTO;

import java.time.LocalDate;
import io.micronaut.serde.annotation.Serdeable;
import ulht.doa.entities.Cliente;

@Serdeable
public class ClienteDTO {

    private Long id;

    private String nome;
    private String email;
    private String cpf;
    private String endereco;
    private String dataNascimento;




    // Construtor vazio
    public ClienteDTO() {
    }

    // getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ClienteDTO{" +
                "Cliente id=" + id +
                ", Cpf='" + cpf + '\'' +
                ", Nome='" + nome + '\'' +
                ", Endereco='" + endereco + '\'' +
                ", Data de Nascimento=" + dataNascimento +
                ", Email='" + email + '\'' +
                '}';
    }
}
