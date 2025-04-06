public class Pagamento {
    public boolean processarPagamento(double total){
        if (total <= 0) {
            System.out.println("Valor inválido para pagamento.");
            return false;
        }

        System.out.printf("Pagamento de R$ %.2f processado com sucesso!\n", total);
        System.out.println("Transação aprovada.");
        return true;
    }
}
