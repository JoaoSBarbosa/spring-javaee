package br.com.spring.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "nota_entrada_itens")
public class NotaEntradaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    @NotNull
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "nota_entrada_id")
    @NotNull
    private NotaEntrada notaEntrada;

    @NotNull(message = "Informe a quantidade")
    private Integer quantidade;
    @NotNull(message = "Informe o valor unitário")
    private Float valorUnitario;
    private float valorTotal;

    // Getter e Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public NotaEntrada getNotaEntrada() {
        return notaEntrada;
    }

    public void setNotaEntrada(NotaEntrada notaEntrada) {
        this.notaEntrada = notaEntrada;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
}
