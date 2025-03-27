/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import javax.swing.*;

/**
 * @author bruno
 */
public class Fila {
    int tamanho;
    int inicio;
    int fim;
    int total;
    Chamado[] vetor;

    public Fila(int tam) {
        inicio = 0;
        fim = 0;
        total = 0;
        tamanho = tam;
        vetor = new Chamado[tam];
    }

    public boolean vazia() {
        return total == 0;
    }

    public boolean cheia() {
        return total >= tamanho;
    }

    public void enfileirar(Chamado chamado) {
        if (!cheia()) {
            vetor[fim] = chamado;
            fim++;
            total++;
            if (fim >= tamanho)
                fim = 0;
        } else {
            JOptionPane.showMessageDialog(null, "Fila cheia.");
        }
    }

    public String desenfileirar() {
        String chamado;
        if (!vazia()) {
            chamado = vetor[inicio].toString();
            inicio++;
            if (inicio >= tamanho)
                inicio = 0;
            total--;
        } else
            chamado = "Fila vazia";
        return chamado;
    }

public String exibeFila() {
    StringBuilder builder = new StringBuilder();
    for (int i = inicio; i < fim; i++) {
        builder.append("posicao ").append(i).append(" valor ").append(vetor[i]).append("\n");
    }
    return builder.toString();
}

    public int getTamanho() {
        return tamanho;
    }
}
