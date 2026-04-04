package com.davidrtc14.exercicio1.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Pedido {

    private int codigo;
    private int quantidade;

    private double precoUnitario;
    private double precoTotal;
    private double desconto;
    private double valorDesconto;
    private double precoFinal;

    public void calcular() {
        this.precoTotal = precoUnitario * quantidade;

        if (precoTotal <= 250.0) {
            desconto = 5;
        } else if (precoTotal <= 500.0) {
            desconto = 10;
        } else {
            desconto = 15;
        }

        valorDesconto = precoTotal * desconto / 100;
        precoFinal = precoTotal - valorDesconto;
    }
}