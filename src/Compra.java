import java.util.List;
import java.util.Scanner;

public class Compra {
    private static ControladorCompra controlador = new ControladorCompra();
    private static CarrinhoCompras carrinho = new CarrinhoCompras();
    private static Usuario usuario;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    List<Jogo> jogos = controlador.listarJogos();

                    for(int i=0; i<jogos.size(); i++){
                        Jogo jogo = jogos.get(i);
                        System.out.println((i+1) + ". " + jogo + " - " + jogo.getDetalhes());
                    }
                    break;
                case 2:
                    System.out.print("Digite o número do jogo: ");
                    int num = sc.nextInt() - 1;
                    sc.nextLine();

                    Jogo jogo = controlador.listarJogos().get(num);

                    if (jogo != null) {
                        carrinho.adicionarItem(jogo);
                    } else {
                        System.out.println("Jogo Indisponível");
                    }
                    break;
                case 3:
                    System.out.println("Digite o cupom (GAMER10, GAMER20): ");
                    String cupom = sc.nextLine();

                    if ("GAMER10".equals(cupom)) {
                        carrinho.setDescontoStrategy(new DescontoGamer10());
                    } else if ("GAMER20".equals(cupom)) {
                        carrinho.setDescontoStrategy(new DescontoGamer20());
                    }
                    carrinho.aplicarCupom(cupom);

                    break;
                case 4:
                    System.out.println("-----Carrinho-----");
                    List<Jogo> itens = carrinho.getItens();

                    if (itens.isEmpty()) {
                        System.out.println("Carrinho vazio.");
                    } else {
                        for (Jogo item : itens) {
                            System.out.println("- " + item.getTitulo() + " (" + item.getDetalhes() + ")");
                        }
                        double total = carrinho.calcularTotal();
                        System.out.printf("Total: R$ %.2f%n", total);
                    }
                    break;
                case 5:
                    System.out.println("Digite seu nome: ");
                    String nome = sc.nextLine();
                    System.out.println("Digite seu email: ");
                    String email = sc.nextLine();
                    usuario = new Usuario(nome, email);

                    System.out.println("Escolha a forma de pagamento: ");
                    System.out.println("1. Cartão de crédito");
                    System.out.println("2. PIX");
                    int pag = sc.nextInt();
                    sc.nextLine();

                    if (controlador.processarCompra(usuario, carrinho, pag)) {
                        carrinho = new CarrinhoCompras();
                    }
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção invalida.");
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("-----Menu-----\n");
        System.out.println("1. Listar jogos");
        System.out.println("2. Adicionar ao carrinho");
        System.out.println("3. Aplicar cupom");
        System.out.println("4. Ver carrinho");
        System.out.println("5. Finalizar compra");
        System.out.println("0. Sair");
        System.out.println("Escolha uma opção: ");
    }
}
