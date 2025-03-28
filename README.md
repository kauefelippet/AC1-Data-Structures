# Avaliação Continuada 1: Estrutura de Dados

## **Desafio Proposto: Sistema de Gerenciamento de Chamados de Suporte em T.I.**

## Objetivo
Implementar um sistema simples de gerenciamento de chamados de suporte, aplicando os conceitos de Pilha, Fila, e Lista Encadeada para organizar os chamados em diferentes estágios.

## Descrição do Desafio
Os grupos (mínimo de 4 e máximo de 6 integrantes) devem desenvolver um sistema de gerenciamento de chamados. O sistema deve permitir registrar chamados, acompanhar o andamento, e organizar os chamados em três estados: **pendentes**, **em atendimento**, e **resolvidos**.

## Regras e Funcionalidades

### Registrar um novo chamado:
- O usuário poderá adicionar um chamado por meio de um texto informativo sobre o problema enfrentado.
- O chamado será inicialmente adicionado à fila de chamados pendentes (ordem de chegada).

### Mover um chamado para "em atendimento":
- O chamado mais antigo (do início da fila de pendentes) será removido e adicionado a uma lista encadeada de chamados em atendimento (adicionar no final da lista).

### Resolver um chamado:
- O usuário poderá resolver qualquer chamado que esteja na lista de "em atendimento".
- O chamado será removido da lista de atendimento e adicionado à pilha de chamados resolvidos (último resolvido no topo da pilha).

### Visualizar chamados:
- Todos os chamados **pendentes**.
- Todos os chamados **em atendimento**.
- Todos os chamados **resolvidos** (na ordem disposta na pilha).

## Estruturas de Dados Utilizadas
- **Fila**: Para armazenar chamados pendentes, garantindo que sejam atendidos na ordem de chegada.
- **Lista Encadeada**: Para armazenar chamados em atendimento, permitindo manipulação dinâmica e flexível.
- **Pilha**: Para armazenar chamados resolvidos, com os mais recentes no topo.

## Passo a Passo de Implementação

### 1. Adaptar as classes das estruturas de dados utilizadas:
- Garantir que as classes permitam a manipulação de strings para os elementos a serem inseridos, removidos e listados.
- Modificar e utilizar as classes para as estruturas de dados disponibilizadas em sala (não será permitida a utilização de outros recursos):
  - **Fila**: Métodos para adicionar, remover e listar os chamados pendentes.
  - **Lista Encadeada**: Métodos para adicionar, remover e listar os chamados em atendimento.
  - **Pilha**: Métodos para empilhar, desempilhar e listar os chamados resolvidos.

### 2. Criar as funcionalidades:
- **Adicionar chamado**: Adiciona o chamado à fila de pendentes.
- **Mover para atendimento**: Remove o chamado do início da fila e insere na lista encadeada.
- **Resolver chamado**: Remove o chamado da lista encadeada e o adiciona na pilha.
- **Visualizar chamados**: 
  - Listar os chamados pendentes (utilizando a Fila).
  - Listar os chamados em atendimento (utilizando a lista encadeada).
  - Listar os chamados resolvidos (utilizando a Pilha).
  
### 3. Criar um menu interativo com JOptionPane.

## Critérios de Avaliação (para conhecimento)

### 1. Uso correto e adaptado das estruturas de dados e dos arquivos disponibilizados (4 pontos):
- Fila para chamados pendentes (1 ponto).
- Lista encadeada para chamados em atendimento (1 ponto).
- Pilha para chamados resolvidos (1 ponto).
- Operações de inserção, remoção e listagem corretamente implementadas (1 ponto).

### 2. Funcionalidades básicas (4 pontos):
- Adicionar chamado (1 ponto).
- Mover para atendimento (1 ponto).
- Resolver chamado (1 ponto).
- Visualizar todos os chamados (1 ponto).

### 3. Código organizado/funcional/bem estruturado (2 pontos):
- Código limpo, organizado, comentado e bem estruturado.

### 4. Apresentação do trabalho (obrigatório para atribuição de nota):
- Como cada estrutura foi utilizada.
- Os fluxos principais: adicionar, mover e resolver chamados.
- Resultados visíveis no sistema.

### 5. O grupo deve demonstrar:
- Exemplo de Fluxo (para entendimento da dinâmica do problema tratado):
  - Um chamado é registrado: "Impressora não funciona".
  - Vai para a fila de pendentes.
  - Chamado é movido para atendimento.
  - Removido da fila e adicionado à lista encadeada de atendimento.
  - Chamado é resolvido.
  - Removido da lista encadeada e empilhado na pilha de resolvidos.

## Implementação
Foram feitas alterações nas estruturas de dados base. A implementação envolve a criação de uma classe Chamado, com a definição de seu status pelo Enum ChamadoState. 

---
Projeto desenvolvido por Kauê Felippe Tiburcio na disciplina de Estrutura de Dados durante a formação de Tecnologia em Análise e Desenvolvimento de Sistemas na Facens, em Sorocaba - SP.

