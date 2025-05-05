public class PagamentoPix implements PagamentoStrategy {
    @Override
    public boolean processarPagamento(double total) {
        System.out.printf("[PIX] Pagamento de R$ %.2f aprovado!\n", total);
        return true;
    }
}