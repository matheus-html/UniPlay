public interface DescontoStrategy {
    double aplicarDesconto(double valor);
    boolean cupomValido(String cupom);
}


