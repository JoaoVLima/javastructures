public class Fila {
    private final int tamanho;
    private int inicio;
    private int fim;
    private int[] dados;
    private boolean vazia;

    Fila(int tamanho) {
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
            throw new Exception("Fila Cheia");
        }
        this.dados[this.fim] = valor;
        this.fim = (this.fim + 1) % this.tamanho;
        this.vazia = false;
    }

    int remove() throws Exception {
        if (this.is_vazio()) {
            throw new Exception("Fila Vazia");
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
            inicio++;
        }
        for (int i = inicio; i != this.fim; i = (i + 1) % this.tamanho) {
            if (i != inicio){
                System.out.print(", ");
            }
            System.out.print(this.dados[i]);
        }
        System.out.println("]");
    }
}