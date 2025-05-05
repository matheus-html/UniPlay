public class DescontoGamer10 implements DescontoStrategy {
    @Override
    public double aplicarDesconto(double valor) {
        return valor * 0.9;
    }

    @Override
    public boolean cupomValido(String cupom) {
        return "GAMER10".equals(cupom);
    }
}