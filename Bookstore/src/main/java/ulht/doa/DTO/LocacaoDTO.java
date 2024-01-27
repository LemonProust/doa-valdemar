package ulht.doa.DTO;

import java.time.LocalDate;
import io.micronaut.serde.annotation.Serdeable;
import ulht.doa.entities.Locacao;

@Serdeable

public class LocacaoDTO {
    private Long idCliente;
    private Long idItem;
    private LocalDate dataLocacao;
    private LocalDate dataDevolucao;
    private Double preco;


    // Exemplo de construtor
    public LocacaoDTO() {
    }

    // Getters e setters
    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public LocalDate getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(LocalDate dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "LocacaoDTO{" +
                "idCliente=" + idCliente +
                ", idItem=" + idItem +
                ", dataLocacao=" + dataLocacao +
                ", dataDevolucao=" + dataDevolucao +
                ", preco=" + preco +
                '}';
    }
}
