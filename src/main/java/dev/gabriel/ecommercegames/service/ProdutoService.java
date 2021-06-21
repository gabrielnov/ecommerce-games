package dev.gabriel.ecommercegames.service;

import dev.gabriel.ecommercegames.model.Produto;
import dev.gabriel.ecommercegames.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public void salvarProduto(Produto produto){
        produtoRepository.save(produto);
    }
}
