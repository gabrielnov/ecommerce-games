package dev.gabriel.ecommercegames.controller;

import dev.gabriel.ecommercegames.dto.ItemDto;
import dev.gabriel.ecommercegames.dto.CarrinhoDto;
import dev.gabriel.ecommercegames.model.Produto;
import dev.gabriel.ecommercegames.service.CarrinhoService;
import dev.gabriel.ecommercegames.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommerceController {

    @Autowired
    CarrinhoService carrinhoService;
    @Autowired
    ProdutoService produtoService;

    @PostMapping("/adicionarItem")
    public ResponseEntity adicionarProduto(@RequestBody ItemDto itemDto){
        return carrinhoService.adicionarItem(itemDto);
    }

    @GetMapping("/checkout")
    public ResponseEntity<CarrinhoDto> checkout(){
        return ResponseEntity.ok().body(carrinhoService.checkout());
    }

    @PostMapping("/cadastrarProduto")
    public ResponseEntity cadastrarProduto(@RequestBody Produto produto){
        produtoService.salvarProduto(produto);
        return ResponseEntity.ok().build();
    }

}
