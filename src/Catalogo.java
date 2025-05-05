import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Jogo> jogos = new ArrayList<>();

    public Catalogo() {

        jogos.add(new JogoDigital("Cyberpunk 2077", "RPG", 199.90, 70.5));
        jogos.add(new JogoFisico("Assassin's Creed Shadows", "RPG", 249.90, 15));
        jogos.add(new JogoDigital("The Witcher 3","RPG",  79.90, 45.0));
        jogos.add(new JogoDigital("Animal Crossing","Simulator",  399.90, 7.0));
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public Jogo jogoIndex(int index) {
        if (index >= 0 && index < jogos.size()) {
            return jogos.get(index);
        } else {
            return null;
        }
    }
}
