package main;

import models.*;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Fila pendentes = new Fila(10);
        ListaEncadeada emAtendimento = new ListaEncadeada();
        Pilha resolvidos = new Pilha(10);

        int opcao = 0;

        while (opcao != 5) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("""
                    1 - Criar chamado\s
                    2 - Atender chamado
                    3 - Resolver chamado
                    4 - Exibir todos os chamados
                    5 - Sair"""));

            switch (opcao) {
                case 1 -> {
                    if (pendentes.cheia()) {
                        JOptionPane.showMessageDialog(null, "Fila de chamados pendentes cheia!");
                        break;
                    }
                    String titulo = JOptionPane.showInputDialog("Digite o título do chamado");
                    String descricao = JOptionPane.showInputDialog("Digite a descrição do chamado");

                    Chamado novoChamado = new Chamado(titulo, descricao);

                    novoChamado.setState(ChamadoState.ABERTO);
                    JOptionPane.showMessageDialog(null, "Chamado nº " + novoChamado.getId() + " criado com sucesso!");
                    pendentes.enfileirar(novoChamado);
                }
                case 2 -> {
                    if (pendentes.vazia()) {
                        JOptionPane.showMessageDialog(null, "Não há chamados pendentes!");
                        break;
                    }
                    Chamado chamado = pendentes.desenfileirar();

                    chamado.setState(ChamadoState.EM_ATENDIMENTO);
                    emAtendimento.insereNo_fim(new NoSimples(chamado));
                    JOptionPane.showMessageDialog(null, "Chamado nº " + chamado.getId() + " em atendimento!");
                    JOptionPane.showMessageDialog(null, "Título: " + chamado.getTitulo() + "\nDescrição: " + chamado.getDescricao());
                }
                case 3 -> {
                    if (emAtendimento.contarNos() == 0) {
                        JOptionPane.showMessageDialog(null, "Não há chamados em atendimento!");
                        break;
                    }

                    NoSimples noChamado = emAtendimento.buscaNo(Integer.parseInt(JOptionPane.showInputDialog("Digite o número do chamado a ser resolvido:")));
                    Chamado chamado = null;
                    if (noChamado == null) {
                        JOptionPane.showMessageDialog(null, "O chamado informado não existe ou não está em atendimento!");
                        break;
                    } else {
                        chamado = noChamado.getValor();
                    }

                    chamado.setState(ChamadoState.RESOLVIDO);
                    emAtendimento.excluiNo(chamado);
                    resolvidos.empilhar(chamado);
                    JOptionPane.showMessageDialog(null, "Chamado nº " + chamado.getId() + " resolvido!");
                }
                case 4 -> {
                    StringBuilder builder = new StringBuilder();
                    builder.append("PENDENTES:\n\n\n");
                    builder.append(pendentes.exibeFila());
                    builder.append("\nEM ATENDIMENTO:\n\n\n");
                    builder.append(emAtendimento.exibeLista());
                    builder.append("\nRESOLVIDOS:\n\n\n");
                    builder.append(resolvidos.ExibePilha());
                    JOptionPane.showMessageDialog(null, builder.toString());
                }
                case 5 -> JOptionPane.showMessageDialog(null, "Saindo...");
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }

    }
}
