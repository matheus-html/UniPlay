public class PagamentoCartao implements PagamentoStrategy {
    @Override
    public boolean processarPagamento(double total) {
        System.out.printf("[Cartão] Pagamento de R$ %.2f aprovado!\n", total);
        return true;
    }
}