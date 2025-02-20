package arvore;

public class main {
    public static void main(String[] args) {
        lista l1 = new lista(9);
        
        l1.insere(6);
        l1.insere(15);
        l1.insere(7);
        //l1.sucessor(9);
        l1.insere(12);
        l1.insere(10);
        l1.insere(5);
        l1.insere(11);
        l1.EmOrdem();
        //l1.sucessor(10);
        l1.insere(13);
        l1.EmOrdem();
        l1.insere(14);
//-------------------------------------
        l1.remover(12);
        System.out.println("altura: " + l1.altura());

        l1.EmOrdem();
        l1.remover(9);
        l1.remover(6);
        l1.remover(15);
        l1.remover(7);
        l1.remover(10);
        l1.remover(5);
        l1.remover(11);
        l1.remover(13);
        l1.remover(14);
        l1.EmOrdem();
        l1.insere(12);
        l1.insere(10);
        l1.insere(5);
        l1.insere(11);
        l1.EmOrdem();
        
        l1.remover(12);
        l1.remover(10);
        l1.remover(5);
        l1.remover(11);
        l1.EmOrdem();

        //if(l1.buscar(5) == null) {
        //    System.out.println("nó não existe");
        //}else{
        //    System.out.println("nó encontrado: " + l1.buscar(12).getInfo());
        //}
       
    }
}

