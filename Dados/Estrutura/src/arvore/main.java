package arvore;

public class main {
    public static void main(String[] args) {
        AVL l1 = new AVL(9);
        
        l1.insere(6);
        l1.insere(15);
        l1.insere(7);
        //l1.sucessor(9);
        l1.insere(12);
        l1.insere(10);
        l1.insere(5);
        l1.insere(11);
        //l1.sucessor(10);
        l1.insere(13);
        l1.insere(14);
        l1.insere(15);
//-------------------------------------
        l1.remove(12);
        System.out.println("altura: " + l1.altura());
        System.out.println(l1.preOrdem());
        // l1.remover(9);
        // l1.remover(6);
        // l1.remover(15);
        // l1.remover(7);
        // l1.remover(10);
        // l1.remover(5);
        // l1.remover(11);
        // l1.remover(13);
        // l1.remover(14);
        // l1.PreOrdem();
//--------------------------------------
        // l1.insere(12);
        // l1.insere(10);
        // l1.insere(5);
        // l1.insere(11);
        // l1.PreOrdem();
//--------------------------------------
        l1.remove(12);
        l1.remove(10);
        l1.remove(5);
        l1.remove(11);
        System.out.println(l1.preOrdem());

        //if(l1.buscar(5) == null) {
        //    System.out.println("nó não existe");
        //}else{
        //    System.out.println("nó encontrado: " + l1.buscar(12).getInfo());
        //}
       
    }
}

