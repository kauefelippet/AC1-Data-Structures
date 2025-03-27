package models;

// Os chamados possuem um identificador único e uma descrição que será read-only, depois de definida.
public class Chamado {
    private static int idCounter = 0;
    private final int id;
    private final String titulo;
    private final String descricao;

    public Chamado(String titulo, String descricao) {
        this.id = idCounter++;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Chamado " + id + ": " + titulo + "\n";
    }
}
