package dev.gabriel.ecommercegames.model;

import javax.persistence.*;


public class ItemCarrinho {

    private Produto produto;
    private long quantidade;

    public ItemCarrinho(Produto produto, long quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
