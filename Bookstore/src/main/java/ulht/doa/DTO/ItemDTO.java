package ulht.doa.DTO;

import io.micronaut.serde.annotation.Serdeable;
import ulht.doa.entities.Item;

import java.util.Date;

@Serdeable

public class ItemDTO {
    private Long idFilme;
    private Double preco;
    private String tipoMidia;
    private Date dataLocacao;
    private Date dataDevolucao;
    //private Filme filme;
    //private Cliente cliente;

    // Construtor vazio
    public ItemDTO() {
    }

    // Getters e setters


    public Long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getTipoMidia() {
        return tipoMidia;
    }

    public void setTipoMidia(String tipoMidia) {
        this.tipoMidia = tipoMidia;
    }

    public Date getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(Date dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "idFilme=" + idFilme +
                ", preco=" + preco +
                ", tipoMidia='" + tipoMidia + '\'' +
                ", dataLocacao=" + dataLocacao +
                ", dataDevolucao=" + dataDevolucao +
                '}';
    }
}
