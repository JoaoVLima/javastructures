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
        if(this.inicio == null){
            this.inicio = novo_no;
        }

        while(){

        }
    }

    int remove(){
        return 1;
    }
}

public class No {
    private int dado;
    private No proximo;

    No(int dado){
        this.dado = dado;
    }

    void encadear(No no){
        this.proximo = no;
    }

    No desencadear(){
        No no = this.proximo;
        this.proximo = null;
        return no;
    }
}
