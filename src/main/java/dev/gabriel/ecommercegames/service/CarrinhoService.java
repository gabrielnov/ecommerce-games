package dev.gabriel.ecommercegames.service;

import dev.gabriel.ecommercegames.dto.ItemDto;
import dev.gabriel.ecommercegames.model.ItemCarrinho;
import dev.gabriel.ecommercegames.model.CarrinhoDto;
import dev.gabriel.ecommercegames.model.Produto;
import dev.gabriel.ecommercegames.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoService {

    List<ItemCarrinho> carrinhoDeCompras = new ArrayList<>();

    @Autowired
    ProdutoRepository produtoRepository;

    public ResponseEntity adicionarItem(ItemDto itemDto) {

        System.out.print("Id do produto: " + itemDto.getIdProduto());
        System.out.print("Quantidade do produto: " + itemDto.getQuantidade());

        Optional<Produto> produto = produtoRepository.findById((long) 1);


        if(produto.isPresent()){
            ItemCarrinho itemCarrinho = new ItemCarrinho(produto.get(), itemDto.getQuantidade());
            carrinhoDeCompras.add(itemCarrinho);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    public CarrinhoDto checkout(){

        System.out.println(carrinhoDeCompras.get(0).getProduto().getPrecoProduto());
        System.out.println(carrinhoDeCompras.get(0).getQuantidade());

        BigDecimal subtotal = calcularSubTotal();
        BigDecimal frete = calcularFrete(subtotal);
        BigDecimal total = calcularTotal(subtotal, frete);

        return new CarrinhoDto(frete, subtotal, total);
    }


    private BigDecimal calcularFrete(BigDecimal subtotal) {

        if(temFreteGratis(subtotal)){
            return new BigDecimal("0");
        }

        BigDecimal frete = new BigDecimal("0");
        carrinhoDeCompras.forEach(item -> frete.add(new BigDecimal("10")));

        return frete;
    }

    private BigDecimal calcularSubTotal() {
        BigDecimal subtotal = new BigDecimal("0");

        for(ItemCarrinho item : carrinhoDeCompras){
            subtotal.add(item.getProduto().getPrecoProduto().multiply(BigDecimal.valueOf(item.getQuantidade())));
        }

        return subtotal;
    }

    public boolean temFreteGratis(BigDecimal subtotal){
        if(subtotal.compareTo(new BigDecimal("250")) > 0){
            return true;
        }
        return false;
    }

    private BigDecimal calcularTotal(BigDecimal subtotal, BigDecimal frete) {
        BigDecimal valorTotal = subtotal.add(frete);
        return valorTotal;
    }

}
