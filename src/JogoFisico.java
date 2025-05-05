public class JogoFisico extends Jogo{
    private int qntEstoque;

    public JogoFisico(String titulo, String genero, double preco, int qntEstoque) {
       super(titulo, genero, preco);
       this.qntEstoque = qntEstoque;
    }

    @Override
    public String getDetalhes(){
        return "Estoque: " + qntEstoque + " unidades";
    }

    public void reduzirEstoque() {
        if (qntEstoque > 0) {
            qntEstoque--;
            System.out.println("Estoque de " + getTitulo() + " reduzido para: " + qntEstoque);
        } else {
            System.out.println("Estoque esgotado para " + getTitulo());
        }
    }

    public int getQntEstoque() {
        return qntEstoque;
    }
}
