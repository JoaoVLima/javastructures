import structures.Fila;
import structures.ListaCircular;
import structures.ListaEncadeada;
import structures.ListaDuplamenteEncadeada;
import structures.Pilha;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha a estrutura de dados: ");
        System.out.println("1 - Pilha");
        System.out.println("2 - Fila");
        System.out.println("3 - Lista Encadeada");
        System.out.println("4 - Lista Circular");
        System.out.println("5 - Lista Duplamente Encadeada");
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
            ListaCircular lista_circular = new ListaCircular();
            lista_circular.menu();
        }else if (opcao == 5) {
            ListaDuplamenteEncadeada lista_duplamente_encadeada = new ListaDuplamenteEncadeada();
            lista_duplamente_encadeada.menu();
        }
    }
}
