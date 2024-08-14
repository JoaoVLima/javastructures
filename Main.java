import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ListaEncadeada lista_input = new ListaEncadeada();
        
        while(true){
            System.out.println("1 - Inserir");
            System.out.println("2 - Excluir");
            System.out.println("0 - Parar");

            int opcao = scanner.nextInt();
            if (opcao == 0) {
                lista_input.imprime();
                break;
            } else if (opcao == 1) {
                System.out.print("Digite o valor para inserir: ");
                int valor = scanner.nextInt();
                lista_input.insere(valor);
                lista_input.imprime();
            } else if (opcao == 2) {
                System.out.print("Digite a posição do nó para excluir: ");
                int posicao = scanner.nextInt();
                lista_input.remove(posicao);
                lista_input.imprime();
            } else {
                System.out.println("Opção inválida");
            }
        }
        
    }
}