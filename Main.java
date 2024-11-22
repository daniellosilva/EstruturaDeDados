package arvore;

public class Main {
    public static void main(String[] args) {
        lista l1 = new lista();
        l1.insere(5);
        l1.insere(6);
        l1.insere(4);
        l1.insere(7);
        l1.insere(3);
        l1.insere(10);
        l1.insere(27);
        l1.PreOrdem(l1.getRaiz());
    }
}
