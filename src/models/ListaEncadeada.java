package models;

import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class ListaEncadeada {
    NoSimples primeiro, ultimo;
    int numero_nos = 0;

    ListaEncadeada() {
        primeiro = ultimo = null;
    }

    void insereNo_fim(NoSimples novoNo) {
        novoNo.prox = null;
        if (primeiro == null)
            primeiro = novoNo;
        if (ultimo != null)
            ultimo.prox = novoNo;
        ultimo = novoNo;
        numero_nos++;
    }

    void insereNo_inicio(NoSimples novoNo) {
        novoNo.prox = primeiro;
        if (primeiro == null && ultimo == null) {
            ultimo = novoNo;
        }
        primeiro = novoNo;
        numero_nos++;
    }

    int ContarNos() {
        int tamanho = 0;
        NoSimples temp_no = primeiro;
        while (temp_no != null) {
            tamanho++;
            temp_no = temp_no.prox;
        }
        return tamanho;
    }

    void insereNo_posicao(NoSimples novoNo, int posicao) {
        NoSimples temp_no = primeiro;
        int numero_nos = ContarNos();
        int pos_aux;
        if (posicao == 0) {
            if (posicao <= numero_nos) {
                pos_aux = 1;
                while (temp_no != null && posicao > pos_aux) {
                    temp_no = temp_no.prox;
                    pos_aux++;
                }
                novoNo.prox = temp_no.prox;
                temp_no.prox = novoNo;
            } else {
                if (posicao > numero_nos) {
                    ultimo.prox = novoNo;
                    ultimo = novoNo;
                }
            }
        }
    }

    NoSimples buscaNo(Object buscaValor) {
        int i = 0;
        NoSimples temp_no = primeiro;
        while (temp_no != null) {
            if (temp_no.valor.equals(buscaValor)) {
                JOptionPane.showMessageDialog(null, "No " + temp_no.valor + " posição " + i);
                return temp_no;
            }
            i++;
            temp_no = temp_no.prox;
        }
        return null;
    }

    void excluiNo(Object valor) {
        NoSimples temp_no = primeiro;
        NoSimples anterior_no = null;
        while (temp_no != null && !temp_no.valor.equals(valor)) {
            anterior_no = temp_no;
            temp_no = temp_no.prox;
        }
        if (temp_no == primeiro) {
            if (temp_no.prox != null)
                primeiro = temp_no.prox;
            else
                primeiro = null;
        } else {
            anterior_no.prox = temp_no.prox;
        }

        if (ultimo == temp_no)
            ultimo = anterior_no;
    }

    void exibeLista() {
        NoSimples temp_no = primeiro;
        int i = 0;
        while (temp_no != null) {
            System.out.println("Saida - Valor " + temp_no.valor + " posição " + i);
            temp_no = temp_no.prox;
            i++;
        }
    }
}
