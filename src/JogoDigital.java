public class JogoDigital extends Jogo {
    private double tamanhoGB;

    public JogoDigital(String titulo, String genero, double preco, double tamanhoGB) {
        super(titulo, genero, preco);
        this.tamanhoGB = tamanhoGB;
    }
}
