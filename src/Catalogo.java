import java.util.List;

public class Catalogo {
    private CatalogoJogos catalogo;

    public Catalogo() {
        catalogo = new CatalogoJogos();

        catalogo.adicionarJogo(new JogoDigital("Cyberpunk 2077", "RPG", 199.90, 70.5));
        catalogo.adicionarJogo(new JogoFisico("FIFA 23", "Esporte", 249.90, 15));
        catalogo.adicionarJogo(new JogoDigital("The Witcher 3","RPG",  79.90, 45.0));
    }

    public List<Jogo> getJogos() {
        return catalogo.getTodosJogos();
    }

    public Jogo jogoIndex(int index) {
        List<Jogo> jogos = catalogo.getTodosJogos();

        if (index >= 0 && index < jogos.size()) {
            return jogos.get(index);
        } else{
            return null;
        }
    }

    public void registrarCompra(List<Jogo> jogos){
        System.out.println("Pagamento efetuado com sucesso!");
        System.out.println("Jogos comprados: ");

        for(int i = 0; i<jogos.size(); i++){
            Jogo jogo = jogos.get(i);
            System.out.println((i+1) +"."+ jogo.getTitulo() + " ("+jogo.getDetalhes()+")");
            System.out.println("Obrigado por comprar na UniPlay!");
        }
        System.out.println(" ");
    }
}
