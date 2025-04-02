import java.util.List;

public class ControladorCompra {
    private Catalogo catalogo;
    private Promocao promocao;
    private Pagamento pagamento;

    public ControladorCompra(){
        this.catalogo = new Catalogo();
        this.promocao = new Promocao();
        this.pagamento = new Pagamento();
    }

    public List<Jogo> listarJogos(){
        return catalogo.getJogos();
    }

    public boolean processarCompra(Usuario usuario, CarrinhoCompras carrinho, int formaPagamento){
        if(carrinho.getItens().isEmpty()){
            System.out.println("Carrinho vazio!");
            return false;
        }

/*        for (Jogo jogo : carrinho.getItens()) {
            if (jogo instanceof JogoFisico) {
                ((JogoFisico) jogo).reduzirEstoque();
            }
        }*/

        double total = carrinho.calcularTotal(promocao);
        System.out.println("-----Resumo da Compra-----\n");
        System.out.println("Cliente: " + usuario.getNome());
        System.out.println("Email: " + usuario.getEmail());
        if(formaPagamento == 1){
            System.out.println("Forma de pagamento: Cartão" );
        } else {
            System.out.println("Forma de pagamento: PIX" );
        }
        System.out.printf("Total: R$ %.2f%n", total);

        if(!pagamento.processarPagamento(total)){
            return false;
        }

        catalogo.registrarCompra(carrinho.getItens());
        return true;
    }
}
