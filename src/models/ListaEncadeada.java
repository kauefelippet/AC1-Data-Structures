package models;

import javax.swing.JOptionPane;

/**
 * @author bruno
 * Modificado para lidar com Chamados - Kauê (247721)
 */
public class ListaEncadeada {
    private NoSimples primeiro, ultimo;
    private int numero_nos = 0;

    public ListaEncadeada() {
        primeiro = ultimo = null;
    }

    public void insereNo_fim(NoSimples novoNo) {
        novoNo.prox = null;
        if (primeiro == null)
            primeiro = novoNo;
        if (ultimo != null)
            ultimo.prox = novoNo;
        ultimo = novoNo;
        numero_nos++;
    }

    public void insereNo_inicio(NoSimples novoNo) {
        novoNo.prox = primeiro;
        if (primeiro == null && ultimo == null) {
            ultimo = novoNo;
        }
        primeiro = novoNo;
        numero_nos++;
    }

    public int contarNos() {
        int tamanho = 0;
        NoSimples temp_no = primeiro;
        while (temp_no != null) {
            tamanho++;
            temp_no = temp_no.prox;
        }
        return tamanho;
    }

    public void insereNo_posicao(NoSimples novoNo, int posicao) {
        NoSimples temp_no = primeiro;
        int numero_nos = contarNos();
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

    public NoSimples buscaNo(int id) {
        int i = 0;
        NoSimples temp_no = primeiro;
        while (temp_no != null) {
            if (temp_no.valor.getId() == id) {
                return temp_no;
            }
            i++;
            temp_no = temp_no.prox;
        }
        return null;
    }

    public void excluiNo(Object valor) {
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

    // Modificado para retornar uma String em vez de utilizar SOUT.
    public String exibeLista() {
        StringBuilder builder = new StringBuilder();
        NoSimples temp_no = primeiro;
        int i = 0;
        while (temp_no != null) {
            builder.append(temp_no.valor.toString()).append("\n");
            temp_no = temp_no.prox;
            i++;
        }
        return builder.toString();
    }
}
