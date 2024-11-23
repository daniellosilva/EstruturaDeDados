package arvore;

public class Main {
    public static void main(String[] args) {
        lista l1 = new lista();
        l1.insere(9);
        l1.insere(6);
        l1.insere(11);
        l1.insere(7);
        l1.insere(12);
        l1.insere(10);
        l1.insere(5);
        l1.EmOrdem(l1.getRaiz());


        l1.buscar(20);
        }
    }

