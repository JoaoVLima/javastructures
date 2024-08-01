public class Pilha {
    private final int tamanho;
    private int topo;
    private int[] dados;

    Pilha(int tamanho) {
        this.tamanho = tamanho;
        this.topo = -1;
        this.dados = new int[tamanho];
    }

    boolean is_cheio() {
        return (this.topo == this.tamanho - 1);
    }

    boolean is_vazio() {
        return (this.topo == -1);
    }

    void insere(int valor) throws Exception {
        if (this.is_cheio()) {
            throw new Exception("Pilha Cheia");
        }
        topo += 1;
        this.dados[topo] = valor;
    }

    int remove() throws Exception {
        if (this.is_vazio()) {
            throw new Exception("Pilha Vazia");
        }
        int valor_removido = this.dados[topo];
        topo -= 1;
        return valor_removido;
    }

    void imprime() {
        System.out.print("[");
        for (int i = 0; i < this.topo + 1; i++) {
            System.out.print(this.dados[i]);
            if (i + 1 < this.topo + 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}