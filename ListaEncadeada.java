import java.util.Scanner;

public class ListaEncadeada {
    private No inicio;

    ListaEncadeada() {
        this.inicio = null;
    }

    boolean is_vazio() {
        return (this.inicio == null);
    }

    void insere(int dado){
        No novo_no = new No(dado);

        if (this.is_vazio()){
            this.inicio = novo_no;
            return;
        }

        No no = this.inicio;
        while(no.proximo != null){
            no = no.proximo;
        }

        no.proximo = novo_no;
    }

    int remove_ultimo() throws Exception {
        if (this.is_vazio()){
            throw new Exception("Lista Vazia");
        }

        No no = this.inicio;

        if (no.proximo == null) {
            int valor_removido = this.inicio.dado;
            this.inicio = null;
            return valor_removido;
        }

        while(no.proximo.proximo != null){
            no = no.proximo;
        }
        int valor_removido = no.proximo.dado;
        no.proximo = null;
        return valor_removido;
    }

    int remove(int posicao) throws Exception {
        if (this.is_vazio()){
            throw new Exception("Lista Vazia");
        }

        if (posicao == 1){
            int valor_removido = this.inicio.dado;
            this.inicio = this.inicio.proximo;
            return valor_removido;
        }

        No no = this.inicio;

        int contador = 2;
        while (no.proximo.proximo != null && contador < posicao) {
            no = no.proximo;
            contador++;
        }

        if (posicao != contador) {
            throw new Exception("Nó na posição " + posicao + " não existe.");
        }

        int valor_removido = no.proximo.dado;
        no.proximo = no.proximo.proximo;
        return valor_removido;
    }

    void imprime() {
        System.out.print("[");

        if (this.is_vazio()){
            System.out.println("]");
            return;
        }

        No no = this.inicio;
        while(no != null){
            System.out.print(no.dado);
            no = no.proximo;
            if(no != null){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    void menu() throws Exception {
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

class No {
    protected int dado;
    protected No proximo;

    No(int dado){
        this.dado = dado;
    }
}
