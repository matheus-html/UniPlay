public class JogoFisico extends Jogo{
    private int qntEstoque;

    public JogoFisico(String titulo, String genero, double preco, int qntEstoque) {
       super(titulo, genero, preco);
       this.qntEstoque = qntEstoque;
    }

    public int getQntEstoque() {
        return qntEstoque;
    }
}
