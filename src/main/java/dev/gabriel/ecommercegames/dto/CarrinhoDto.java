package dev.gabriel.ecommercegames.dto;

import java.math.BigDecimal;

public class CarrinhoDto {

    BigDecimal frete = new BigDecimal("0");
    BigDecimal subtotal = new BigDecimal("0");
    BigDecimal total = new BigDecimal("0");

    public CarrinhoDto(BigDecimal frete, BigDecimal subtotal, BigDecimal total) {
        this.frete = frete;
        this.subtotal = subtotal;
        this.total = total;
    }

    public BigDecimal getFrete() {
        return frete;
    }

    public void setFrete(BigDecimal frete) {
        this.frete = frete;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
