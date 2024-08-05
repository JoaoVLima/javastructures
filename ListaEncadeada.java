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

    int remove() throws Exception {
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
}

class No {
    protected int dado;
    protected No proximo;

    No(int dado){
        this.dado = dado;
    }
}
