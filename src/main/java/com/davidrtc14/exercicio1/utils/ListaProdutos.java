package com.davidrtc14.exercicio1.utils;

import com.davidrtc14.exercicio1.model.Produto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaProdutos {
    private List<Produto> produtos;

    public ListaProdutos(){
        this.produtos = new ArrayList<>();
    }

    public void adicionarProdutos(Produto produto){
        this.produtos.add(produto);
    }

    public Produto getProduto(int indice){
        return produtos.get(indice);
    }

    public List<Produto> getProdutos(){
        return Collections.unmodifiableList(produtos);
    }
}
