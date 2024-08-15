package structures;

public class Arvore {
    private Folha inicio;

    Arvore() {
        this.inicio = null;
    }

    boolean is_vazio() {
        return (this.inicio == null);
    }

    void insere(int dado){
        Folha novo_no = new Folha(dado);

        if (this.is_vazio()){
            this.inicio = novo_no;
            return;
        }

        Folha no = this.inicio;
        while(no.proximo != null){
            no = no.proximo;
        }

        no.proximo = novo_no;
    }

    int remove() throws Exception {
        if (this.is_vazio()){
            throw new Exception("Lista Vazia");
        }

        Folha no = this.inicio;

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

        Folha no = this.inicio;
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

class Folha {
    protected int dado;
    protected Folha proximo;

    Folha(int dado){
        this.dado = dado;
    }
}
