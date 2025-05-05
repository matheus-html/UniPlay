import java.util.List;

public class ControladorCompra {
    private Catalogo catalogo;
    private PagamentoStrategy pagamentoStrategy;

    public ControladorCompra(){
        this.catalogo = new Catalogo();
    }

    public void setPagamentoStrategy(PagamentoStrategy pagamentoStrategy) {
        this.pagamentoStrategy = pagamentoStrategy;
    }

    public List<Jogo> listarJogos(){
        return catalogo.getJogos();
    }

    public void registrarCompra(List<Jogo> jogos) {
        System.out.println("Jogos comprados: ");
        for (int i = 0; i < jogos.size(); i++) {
            Jogo jogo = jogos.get(i);
            System.out.println((i+1) + ". " + jogo.getTitulo());
        }
        System.out.println("Obrigado por comprar na UniPlay!\n");
    }

    public boolean processarCompra(Usuario usuario, CarrinhoCompras carrinho, int formaPagamento){
        if(carrinho.getItens().isEmpty()){
            System.out.println("Carrinho vazio!");
            return false;
        }

        for (Jogo jogo : carrinho.getItens()) {
            if (jogo instanceof JogoFisico) {
                JogoFisico jogoFisico = (JogoFisico) jogo;
                if (jogoFisico.getQntEstoque() <= 0) {
                    System.out.println("Jogo " + jogoFisico.getTitulo() + " sem estoque disponível!");
                    return false;
                }
            }
        }

        for (Jogo jogo : carrinho.getItens()) {
            if (jogo instanceof JogoFisico) {
                ((JogoFisico) jogo).reduzirEstoque();
            }
        }

        double total = carrinho.calcularTotal();
        System.out.println("-----Resumo da Compra-----\n");
        System.out.println("Cliente: " + usuario.getNome());
        System.out.println("Email: " + usuario.getEmail());

        if (formaPagamento == 1) {
            setPagamentoStrategy(new PagamentoCartao());
            System.out.println("Forma de pagamento: Cartão");
        } else if (formaPagamento == 2) {
            setPagamentoStrategy(new PagamentoPix());
            System.out.println("Forma de pagamento: PIX");
        } else {
            System.out.println("Forma de pagamento inválida!");
            return false;
        }

        System.out.printf("Total: R$ %.2f%n", total);

        if (pagamentoStrategy == null || !pagamentoStrategy.processarPagamento(total)) {
            return false;
        }

        registrarCompra(carrinho.getItens());
        return true;
    }
}
