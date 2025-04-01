public abstract class Jogo {
    private String titulo;
    private String genero;
    private double preco;

    public Jogo(String titulo, String genero, double preco) {
        this.titulo = titulo;
        this.genero = genero;
        this.preco = preco;
    }
    public String getTitulo() {
        return titulo;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        String infoJogo = titulo + " (" + genero + ") - " + "R$ " + preco;
        return infoJogo;
    }
}
