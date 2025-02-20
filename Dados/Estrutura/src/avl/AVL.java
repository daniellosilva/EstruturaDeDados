package avl;

public class AVL {

    private No raiz;

    public AVL(int info) {
        this.raiz = new No(info);
    }

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    public boolean ArvoreVazia(){
        return this.raiz == null;
    }

    public void insere(int info) {
        this.raiz = insere(this.raiz, info); 
    }

    private No insere(No raiz, int info) {
        if (raiz == null) {
            return new No(info);
        }

        if (info < raiz.getInfo()) {
            raiz.setProxEsq(insere(raiz.getProxEsq(), info));
        } else if (info > raiz.getInfo()) {
            raiz.setProxDir(insere(raiz.getProxDir(), info));
        } else {
            return raiz; 
        }

        raiz.setAltura(1 + maior(altura(raiz.getProxEsq()), altura(raiz.getProxDir())));

        int balance = fatorBalanceamento(raiz);

        if (balance > 1 && info < raiz.getProxEsq().getInfo()) {
            return rotacaoDireita(raiz);
        }

        if (balance < -1 && info > raiz.getProxDir().getInfo()) {
            return rotacaoEsquerda(raiz);
        }

        if (balance > 1 && info > raiz.getProxEsq().getInfo()) {
            raiz.setProxEsq(rotacaoEsquerda(raiz.getProxEsq()));
            return rotacaoDireita(raiz);
        }

        if (balance < -1 && info < raiz.getProxDir().getInfo()) {
            raiz.setProxDir(rotacaoDireita(raiz.getProxDir()));
            return rotacaoEsquerda(raiz);
        }

        return raiz;
    }
    
    public void remove(int info){
        raiz = remove(raiz, info);
    }

    private No remove(No raiz, int info){
        if(raiz == null) return null;

        if(info < raiz.getInfo()){
            raiz.setProxEsq(remove(raiz.getProxEsq(), info));
        } else if(info > raiz.getInfo()){
            raiz.setProxDir(remove(raiz.getProxDir(), info));
        } else { 
            if(raiz.getProxEsq() == null && raiz.getProxDir() == null){
                return null;
            }

            if(raiz.getProxEsq() == null){
                return raiz.getProxDir();
            }
            if(raiz.getProxDir() == null){
                return raiz.getProxEsq();
            }

            No sucessor = minimo(raiz.getProxDir());
            raiz.setInfo(sucessor.getInfo());
            raiz.setProxDir(remove(raiz.getProxDir(), sucessor.getInfo()));
        }
        return raiz;
    }
    public int altura(){
        return altura(raiz);
    }

    private No rotacaoDireita(No y) {
        No x = y.getProxEsq();
        No T2 = x.getProxDir();

        x.setProxDir(y);
        y.setProxEsq(T2);

        y.setAltura(1 + maior(altura(y.getProxEsq()), altura(y.getProxDir())));
        x.setAltura(1 + maior(altura(x.getProxEsq()), altura(x.getProxDir())));

        return x;
    }

    private No rotacaoEsquerda(No x) {
        No y = x.getProxDir();
        No T2 = y.getProxEsq();

        y.setProxEsq(x);
        x.setProxDir(T2);

        x.setAltura(1 + maior(altura(x.getProxEsq()), altura(x.getProxDir())));
        y.setAltura(1 + maior(altura(y.getProxEsq()), altura(y.getProxDir())));

        return y;
    }

    private int maior(int a, int b) {
        return (a > b) ? a : b;
    }

    private int altura(No raiz) {
        if (raiz == null) {
            return -1;
        }
        
        int alturaEsq = altura(raiz.getProxEsq());
        int alturaDir = altura(raiz.getProxDir());

        return 1 + (alturaEsq > alturaDir ? alturaEsq : alturaDir);
    }
    
    public int fatorBalanceamento(No raiz) {
        
        if (raiz == null) {
            return 0;
        }
        
        return altura(raiz.getProxEsq()) - altura(raiz.getProxDir());
    }
    
    public No buscar(int info){
        if(raiz == null){
            return null;
        }
        return buscar(info, raiz);
    }

    private No buscar(int info, No raiz){
        if(raiz == null){
            return null;
        }
        if(info == raiz.getInfo()){
            return raiz;
        }else{
            if(info > raiz.getInfo()){
                return buscar(info, raiz.getProxDir());
            }else{
                return buscar(info, raiz.getProxEsq());
            }
        }
    }

    public No maximo(){
        return maximo(raiz);
    }

    private No maximo(No raiz){
        if(raiz.getProxDir() == null){
            return raiz;
        }
        return maximo(raiz.getProxDir());
    }
    
    public No minimo(){
        return minimo(raiz);
    }

    private No minimo(No raiz){
        if(raiz.getProxEsq() == null){
            return raiz;
        }
        return minimo(raiz.getProxEsq());
    }

    public No sucessor(int info){
        No numeroB = buscar(info);

        if(numeroB == maximo()){
            System.out.println("nó nao tem sucessor!");
            return null;
        }
        if(numeroB == minimo()){
            sucessor(raiz.getProxEsq(), info);
            if(raiz.getProxEsq() == minimo()){
                System.out.println("sucessor: " + raiz.getInfo());
                return raiz;
            }
        }
        if(numeroB == null) {
            System.out.println("nó não existe");
            return null;
        }
        if(numeroB == maximo(raiz.getProxEsq())){
            System.out.println("sucessor: " + raiz.getInfo());
            return raiz;
        }
        if(numeroB.getProxDir() == null){
            if(numeroB.getInfo() < raiz.getInfo()){
                sucessor(raiz.getProxEsq(), info);
                return null;
            }
            sucessor(raiz.getProxDir(), info);
            return null;
        }
            System.out.println("sucessor: " + minimo(numeroB.getProxDir()).getInfo());
            return minimo(numeroB.getProxDir());
    }

    private No sucessor(No raiz, int info){
        No numeroB = buscar(info);
        if(raiz.getProxEsq() == numeroB){
            System.out.println("sucessor sem proximo: " + raiz.getInfo());
            return raiz;
        }
        if(raiz.getProxEsq() == null){
            System.out.println("sucessor: " + raiz.getInfo());
            return raiz;
        }
        sucessor(raiz.getProxEsq(), info);
        return raiz;
    }

    public String preOrdem() {
        StringBuilder sb = new StringBuilder();
        preOrdem(this.raiz, sb);
        return sb.toString();
    }

    private void preOrdem(No raiz, StringBuilder sb) {
        if (raiz == null) {
            return;
        }
        sb.append(raiz.getInfo()).append("(").append(fatorBalanceamento(raiz)).append(")");
        preOrdem(raiz.getProxEsq(), sb);
        preOrdem(raiz.getProxDir(), sb);
    }

    public void EmOrdem(){
        EmOrdem(raiz);
        System.out.println("=================================");
    }

    private void EmOrdem(No raiz){
        if(raiz == null){
            return;
        }
        EmOrdem(raiz.getProxEsq());
        System.out.println(raiz.getInfo() + " ");
        EmOrdem(raiz.getProxDir());
        return;
    }

    public void PosOrdem(){
        if(this.raiz == null){
            System.out.println("arvore vazia");
        }PosOrdem(raiz);
    }

    private void PosOrdem(No raiz){
        if(raiz == null){
            return;
        }
        PosOrdem(raiz.getProxEsq());
        PosOrdem(raiz.getProxDir());
        System.out.println(raiz.getInfo()+ " ");
        return;
    }
}