package listacircular;

class main{
    public static void main(String[] args) {
        Lista l1 = new Lista();
        l1.insere(1);
        l1.insere(2);
        l1.insere(0);
        l1.insere(2);
        l1.insere(1);
        l1.insere(1);
        l1.insere(1);
        l1.insere(1);
        System.out.println(l1.imprime());
        l1.remove(1, false);
        l1.remove(1, true);
        System.out.println(l1.imprime());
        l1.remove(0, false);
        System.out.println(l1.imprime());
        l1.remove(2, true);
        System.out.println(l1.imprime());
        l1.insere(0);
        System.out.println(l1.imprime());
        l1.insere(0);
        l1.insere(0);
        l1.insere(0);
        l1.insere(0);
        System.out.println(l1.imprime());
        l1.insere(3);
        l1.insere(4);
        System.out.println(l1.imprime());
        l1.remove(3, true);
        System.out.println(l1.imprime());
        l1.remove(4, false);
        System.out.println(l1.imprime());
        l1.remove(0, true);
        System.out.println(l1.imprime());
        
    }
}