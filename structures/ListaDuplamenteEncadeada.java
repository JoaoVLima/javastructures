package structures;

import java.util.Scanner;

public class ListaDuplamenteEncadeada {
    private NoDuplo inicio;

    public ListaDuplamenteEncadeada() {
        this.inicio = null;
    }

    boolean is_vazio() {
        return (this.inicio == null);
    }

    void insere(int dado){
        NoDuplo novo_no = new NoDuplo(dado);

        if (this.is_vazio()) {
            this.inicio = novo_no;
            return;
        }
        NoDuplo no = this.inicio;
        while (no.proximo != null) {
            no = no.proximo;
        }
        no.proximo = novo_no;
        novo_no.anterior = no;
    }

    int remove(int posicao) throws Exception {
        if (this.is_vazio()){
            throw new Exception("Lista Vazia");
        }

        if (posicao == 1){ // Remove the first element
            int valor_removido = this.inicio.dado;
            this.inicio = this.inicio.proximo;
            if(this.inicio != null){
                this.inicio.anterior = null;
            }
            return valor_removido;
        }

        NoDuplo no = this.inicio;

        int contador = 1;
        while (no.proximo != null && contador < posicao) {
            no = no.proximo;
            contador++;
        }

        if (posicao != contador) {
            throw new Exception("Nó na posição " + posicao + " não existe.");
        }

        int valor_removido = no.dado;
        no.anterior.proximo = no.proximo;
        return valor_removido;
    }

    void imprime() {
        System.out.print("[");

        if (this.is_vazio()){
            System.out.println("]");
            return;
        }

        NoDuplo no = this.inicio;
        while(no != null){
            System.out.print(no.dado);
            no = no.proximo;
            if(no != null){
                System.out.print(",");
            }
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
                System.out.print("Digite a posição do nó para excluir: ");
                int posicao = scanner.nextInt();
                this.remove(posicao);
                this.imprime();
            } else {
                System.out.println("Opção inválida");
            }
        }
    }
}

class NoDuplo{
    protected int dado;
    protected NoDuplo anterior;
    protected NoDuplo proximo;

    NoDuplo(int dado){
        this.dado = dado;
    }
}
