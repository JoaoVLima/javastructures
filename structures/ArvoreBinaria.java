package structures;

import java.util.Scanner;

public class ArvoreBinaria {
    private Node inicio;

    public ArvoreBinaria() {
        this.inicio = null;
    }

    boolean is_vazio() {
        return (this.inicio == null);
    }

    void insere(int info){
        this.inicio = insere_recursao(this.inicio, info);
    }

    Node insere_recursao(Node no, int info){
        if(no == null){
            no = new Node(info);
            return no;
        }
        if (info < no.info) {
            no.esquerda = insere_recursao(no.esquerda, info);
        } else if (info > no.info) {
            no.direita = insere_recursao(no.direita, info);
        }
        return no;
    }

    int remove(int posicao) throws Exception {
        if (this.is_vazio()){
            throw new Exception("Lista Vazia");
        }

        if (posicao == 1){
            int valor_removido = this.inicio.info;
            this.inicio = this.inicio.direita;
            return valor_removido;
        }

        Node no = this.inicio;

        int contador = 2;
        while (no.direita.direita != null && contador < posicao) {
            no = no.direita;
            contador++;
        }

        if (posicao != contador) {
            throw new Exception("Nó na posição " + posicao + " não existe.");
        }

        int valor_removido = no.direita.info;
        no.direita = no.direita.direita;
        return valor_removido;
    }

    int tamanho(){
        return tamanho_recursao(this.inicio);
    }

    int tamanho_recursao(Node no) {
        if (no == null)
            return 0;
        else {
            int tamanho_esquerda = tamanho_recursao(no.esquerda);
            int tamanho_direita = tamanho_recursao(no.direita);

            if (tamanho_esquerda > tamanho_direita)
                return (tamanho_esquerda + 1);
            else
                return (tamanho_direita + 1);
        }
    }

    void nivel(Node no, int n) {
        if (no == null) {
            System.out.print("\t");
            return;
        }
        if (n == 1) {
            System.out.print(no.info+"\t\t");
        }
        else if (n > 1) {
            nivel(no.esquerda, n-1);
            nivel(no.direita, n-1);
        }
    }

    void nivel_ordem() {
        for (int i=1; i<=tamanho(); i++) {
            for(int j=i+1; j<=tamanho(); j++) {
                System.out.print("\t");
            }
            nivel(this.inicio, i);
            System.out.println();
        }
    }


    void in_ordem() {
        System.out.print("[");
        in_ordem_recursao(this.inicio);
        System.out.println("]");
    }

    void in_ordem_recursao(Node no) {
        if (no != null) {
            in_ordem_recursao(no.esquerda);
            System.out.print(no.info+",");
            in_ordem_recursao(no.direita);
        }
    }

    void pre_ordem() {
        System.out.print("[");
        pre_ordem_recursao(this.inicio);
        System.out.println("]");
    }

    void pre_ordem_recursao(Node no) {
        if (no != null) {
            System.out.print(no.info+",");
            pre_ordem_recursao(no.esquerda);
            pre_ordem_recursao(no.direita);
        }
    }

    void pos_ordem() {
        System.out.print("[");
        pos_ordem_recursao(this.inicio);
        System.out.println("]");
    }

    void pos_ordem_recursao(Node no) {
        if (no != null) {
            pos_ordem_recursao(no.esquerda);
            pos_ordem_recursao(no.direita);
            System.out.print(no.info+",");
        }
    }

    void imprime() {
        this.nivel_ordem();
        System.out.print("in_ordem: ");
        this.in_ordem();
        System.out.print("pre_ordem: ");
        this.pre_ordem();
        System.out.print("pos_ordem: ");
        this.pos_ordem();
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

class Node {
    protected int info;
    protected Node esquerda;
    protected Node direita;

    Node(int info){
        this.info = info;
    }
}

