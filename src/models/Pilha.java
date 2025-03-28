package models;

import javax.swing.*;

public class Pilha {
    //Declarando os atributos da classe
    private int topo;
    public final int tamanho;
    private final Object[] vetor;

    public Pilha(int tam) {
        topo = -1; //Marca que a pilha está vazia
        tamanho = tam;
        vetor = new Object[tam];
    }

    public boolean vazia() {
        return topo == -1;
    }

    public boolean cheia() {
        return topo == tamanho - 1;
    }

    public void empilhar(Object elem) {
        if (!cheia()) {
            topo++;
            vetor[topo] = elem;
        } else {
            JOptionPane.showMessageDialog(null,
                    "PILHA CHEIA!");
        }
    }

    public Object desempilhar() {
        Object valorDesempilhado;
        if (vazia()) {
            valorDesempilhado = "Pilha Vazia";
        } else {
            valorDesempilhado = vetor[topo];
            topo--;
        }
        return valorDesempilhado;
    }

    public String ExibePilha() {
        StringBuilder builder = new StringBuilder();
        if (!vazia()) {
            for (int i = topo; i >= 0; i--) {
                builder.append(vetor[i]).append("\n");
            }
        }
        return builder.toString();
    }
}