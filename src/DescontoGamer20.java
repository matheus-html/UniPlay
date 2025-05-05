public class DescontoGamer20 implements DescontoStrategy {
    @Override
    public double aplicarDesconto(double valor) {
        return valor * 0.8;
    }

    @Override
    public boolean cupomValido(String cupom) {
        return "GAMER20".equals(cupom);
    }
}