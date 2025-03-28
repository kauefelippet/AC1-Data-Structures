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
    private final int tamanho;
    private int inicio;
    private int fim;
    private int total;
    private final Chamado[] vetor;

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
            JOptionPane.showMessageDialog(null, "Fila de chamados pendentes cheia!");
        }
    }

    // Modificado para retornar o próprio chamado em vez de uma String.
    public Chamado desenfileirar() {
        Chamado chamado;
        if (!vazia()) {
            chamado = vetor[inicio];
            inicio++;
            if (inicio >= tamanho)
                inicio = 0;
            total--;
        } else {
            JOptionPane.showMessageDialog(null, "Não há chamados pendentes!");
            return null;
        }
        return chamado;
    }

    // Modificado para retornar uma String em vez de utilizar SOUT.
    public String exibeFila() {
        StringBuilder builder = new StringBuilder();
        for (int i = inicio; i < fim; i++) {
            builder.append(vetor[i]).append("\n");
        }
        return builder.toString();
    }
}
