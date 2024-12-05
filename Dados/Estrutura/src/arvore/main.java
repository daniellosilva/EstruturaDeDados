package arvore;

public class main {
    public static void main(String[] args) {
        lista l1 = new lista();
        l1.insere(9);
        l1.insere(6);
        l1.insere(11);
        l1.insere(7);
        l1.insere(12);
        l1.insere(10);
        l1.insere(5);
        l1.EmOrdem();
        //if(l1.buscar(5) == null) {
        //    System.out.println("nó não existe");
        //}else{
        //    System.out.println("nó encontrado: " + l1.buscar(12).getInfo());
        //}
        l1.sucessor(11);
    }
}

