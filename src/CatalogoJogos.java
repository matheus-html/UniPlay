import java.util.ArrayList;
import java.util.List;

public class CatalogoJogos {
    private List<Jogo> jogos = new ArrayList<>();

    public void adicionarJogo(Jogo jogo) {
        jogos.add(jogo);
    }

    public List<Jogo> getTodosJogos() {
        return new ArrayList<>(jogos);
    }
}
