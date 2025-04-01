import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {
    private List<Jogo> itens = new ArrayList<>();
    private String cupom;

    public void adicionarItem(Jogo jogo){
        itens.add(jogo);
        System.out.println(jogo.getTitulo() + " adicionado ao carrinho!");
    }

    public double calcularTotal(Promocao promocao) {
        double total = 0;
        for (Jogo jogo : itens) {
            total += jogo.getPreco();
        }
        if (cupom != null && promocao.validaCupom(cupom)) {
            total = promocao.descontoCupom(total, cupom);
        }
        return total;
    }

    public void aplicarCupom(String cupom){
        this.cupom = cupom;
        System.out.println("Cupom: " + cupom + " aplicado!");
    }

    public List<Jogo> getItens() {
        return new ArrayList<>(itens);
    }

}
