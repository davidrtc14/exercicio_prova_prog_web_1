package com.davidrtc14.exercicio1.controller;

import com.davidrtc14.exercicio1.model.Pedido;
import com.davidrtc14.exercicio1.model.Produto;
import com.davidrtc14.exercicio1.utils.ListaProdutos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.LinkedHashMap;
import java.util.Map;


@Controller
public class ProdutoController {
    private ListaProdutos listaProdutos = new ListaProdutos();

    private void carregarDados(Model model) {
        Map<String, String> grupos = new LinkedHashMap<>();
        grupos.put("1 a 10", "R$ 10,00");
        grupos.put("11 a 20", "R$ 15,00");
        grupos.put("21 a 30", "R$ 20,00");
        grupos.put("31 a 40", "R$ 30,00");

        Map<String, String> descontos = new LinkedHashMap<>();
        descontos.put("Até 250,00", "5%");
        descontos.put("Entre 250,00 e 500,00", "10%");
        descontos.put("Acima de 500,00", "15%");

        model.addAttribute("grupos", grupos);
        model.addAttribute("descontos", descontos);
    }

    private void inicializarListaProdutos(){
        for (int i = 1; i <= 10; i++){
            listaProdutos.adicionarProdutos(new Produto(i, 10.0));
        }
        for (int i = 11; i <= 20; i++){
            listaProdutos.adicionarProdutos(new Produto(i, 15.0));
        }
        for (int i = 21; i <= 30; i++){
            listaProdutos.adicionarProdutos(new Produto(i, 20.0));
        }
        for (int i = 31; i <= 40; i++){
            listaProdutos.adicionarProdutos(new Produto(i, 30.0));
        }
    }

    @GetMapping("/produtos")
    public String produtos(Model model){
        if(listaProdutos.getProdutos().isEmpty()){
            inicializarListaProdutos();
        }

        carregarDados(model);
        model.addAttribute("produtos", listaProdutos.getProdutos());

        return "produtos";
    }

    @PostMapping("/pedido")
    public String finalizarCompra(Pedido pedido, Model model){
        if(listaProdutos.getProdutos().isEmpty()){
            inicializarListaProdutos();
        }

        if(pedido.getCodigo() <= 0 || pedido.getCodigo() > 40){
            model.addAttribute("erro", "Código Inválido");
            return "produtos";
        }

        var indiceProduto = pedido.getCodigo() - 1;

        var produto = listaProdutos.getProduto(indiceProduto);

        if (produto == null) {
            model.addAttribute("erro", "Produto não encontrado");
            return "produtos";
        }

        pedido.setPrecoUnitario(produto.getPreco());

        pedido.calcular();

        carregarDados(model);
        model.addAttribute("pedido", pedido);

        return "produtos";
    }
}
