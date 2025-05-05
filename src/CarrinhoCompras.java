import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {
    private List<Jogo> itens = new ArrayList<>();
    private String cupom;
    private DescontoStrategy descontoStrategy;


    public void setDescontoStrategy(DescontoStrategy descontoStrategy) {
        this.descontoStrategy = descontoStrategy;
    }

    public void adicionarItem(Jogo jogo){
        itens.add(jogo);
        System.out.println(jogo.getTitulo() + " adicionado ao carrinho!");
    }

    public double calcularTotal() {
        double total = 0.0;
        for (int i = 0; i < itens.size(); i++) {
            total += itens.get(i).getPreco();
        }

        if (cupom != null && descontoStrategy != null && descontoStrategy.cupomValido(cupom)) {
            total = descontoStrategy.aplicarDesconto(total);
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
