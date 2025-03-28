package models;

// Os chamados possuem um identificador único e uma descrição que será read-only, depois de definida.
public class Chamado {
    private static int idCounter = 1;
    private final int id;
    private final String titulo;
    private final String descricao;
    private ChamadoState state;

    public Chamado(String titulo, String descricao) {
        this.id = idCounter++;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public void setState(ChamadoState state) {
        this.state = state;
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
