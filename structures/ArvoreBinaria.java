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

    void remove_maior() {
        remove_maior_recursao(this.inicio);
    }

    private Node remove_maior_recursao(Node no) {
        if (no == null)
            return null;

        if (no.direita == null)
            return no.esquerda;

        no.direita = remove_maior_recursao(no.direita);
        return no;
    }


    void remove_menor() {
        remove_menor_recursao(this.inicio);
    }

    private Node remove_menor_recursao(Node no) {
        if (no == null)
            return null;

        if (no.esquerda == null)
            return no.direita;

        no.esquerda = remove_menor_recursao(no.esquerda);
        return no;
    }

    public void remove(int info) {
        remove_recursao(this.inicio, info);
    }

    private Node remove_recursao(Node no, int info) {
        if (no == null)
            return no;

        if (info < no.info)
            no.esquerda = remove_recursao(no.esquerda, info);
        else if (info > no.info)
            no.direita = remove_recursao(no.direita, info);
        else {
            // Caso 1: Nó sem filhos (folha)
            if (no.esquerda == null && no.direita == null)
                return null;

            // Caso 2: Nó com um filho
            if (no.esquerda == null)
                return no.direita;
            else if (no.direita == null)
                return no.esquerda;

            // Caso 3: Nó com dois filhos
            no.info = min_info(no.direita);
            no.direita = remove_recursao(no.direita, no.info);
        }
        return no;
    }

    private int min_info(Node no) {
        int min = no.info;
        while (no.esquerda != null) {
            min = no.esquerda.info;
            no = no.esquerda;
        }
        return min;
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
            System.out.println("2 - Excluir Maior");
            System.out.println("3 - Excluir Menor");
            System.out.println("4 - Excluir Valor");
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
                this.remove_maior();
                this.imprime();
            } else if (opcao == 3) {
                this.remove_menor();
                this.imprime();
            } else if (opcao == 4) {
                System.out.print("Digite o valor do nó para excluir: ");
                int info = scanner.nextInt();
                this.remove(info);
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

