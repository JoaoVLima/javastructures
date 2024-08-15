import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha a estrutura de dados: ");
        System.out.println("1 - Pilha");
        System.out.println("2 - Fila");
        System.out.println("3 - Lista Encadeada");
        System.out.println("4 - Lista Circular");
        int opcao = scanner.nextInt();
        if (opcao == 1) {
            Pilha pilha = new Pilha(5);
            pilha.menu();
        }else if (opcao == 2) {
            Fila fila = new Fila(5);
            fila.menu();
        }else if (opcao == 3) {
            ListaEncadeada lista_encadeada = new ListaEncadeada();
            lista_encadeada.menu();
        }else if (opcao == 4) {

        }
    }
}