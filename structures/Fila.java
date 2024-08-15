package structures;

import java.util.Scanner;

public class Fila {
    private final int tamanho;
    private int inicio;
    private int fim;
    private int[] dados;
    private boolean vazia;

    public Fila(int tamanho) {
        this.tamanho = tamanho;
        this.inicio = 0;
        this.fim = 0;
        this.dados = new int[tamanho];
        this.vazia = true;
    }

    boolean is_cheio() {
        return (this.inicio == this.fim && !this.vazia);
    }

    boolean is_vazio() {
        return this.vazia;
    }

    void insere(int valor) throws Exception {
        if (this.is_cheio()) {
            throw new Exception("structures.Fila Cheia");
        }
        this.dados[this.fim] = valor;
        this.fim = (this.fim + 1) % this.tamanho;
        this.vazia = false;
    }

    int remove() throws Exception {
        if (this.is_vazio()) {
            throw new Exception("structures.Fila Vazia");
        }
        int valor = this.dados[inicio];
        this.inicio = (this.inicio + 1) % this.tamanho;
        this.vazia = this.inicio == this.fim;
        return valor;
    }

    void imprime() {
        System.out.print("[");
        int inicio = this.inicio;
        if (this.is_cheio()) {
            System.out.print(this.dados[this.inicio]);
            System.out.print(",");
            inicio++;
        }
        for (int i = inicio; i != this.fim; i = (i + 1) % this.tamanho) {
            if (i != inicio){
                System.out.print(",");
            }
            System.out.print(this.dados[i]);
        }
        System.out.println("]");
    }

    public void menu() throws Exception {
        Scanner scanner = new Scanner(System.in);
        this.imprime();
        while(true){
            System.out.println("1 - Inserir");
            System.out.println("2 - Excluir");
            System.out.println("0 - Parar");

            int opcao = scanner.nextInt();
            if (opcao == 0) {
                this.imprime();
                break;
            } else if (opcao == 1) {
                System.out.print("Digite o valor para inserir: ");
                int valor = scanner.nextInt();
                this.insere(valor);
                this.imprime();
            } else if (opcao == 2) {
                this.remove();
                this.imprime();
            } else {
                System.out.println("Opção inválida");
            }
        }
    }
}
