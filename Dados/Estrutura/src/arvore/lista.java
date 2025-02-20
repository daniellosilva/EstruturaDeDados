package arvore;

public class lista {

    private No raiz;

    public lista(int info) {
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

    public void insere(int info){
        No novo = new No(info);
        if(ArvoreVazia()){
            this.raiz = novo;
            return;
        }
        insere(info, raiz);
    }   
        
    private void insere(int info, No raiz){
        No novo = new No(info);
               
        if(raiz.getInfo() < novo.getInfo()){
            if(raiz.getProxDir() == null){
                raiz.setProxDir(novo);
            }
            else{
                insere(info, raiz.getProxDir());
            }
        }else{
            if(raiz.getInfo() > novo.getInfo()){
                if(raiz.getProxEsq() == null){
                    raiz.setProxEsq(novo);
                }
                else{
                    insere(info, raiz.getProxEsq());
                }
            }
        }
    }
    public void remover(int info){
        raiz = remover(raiz, info);
    }

    private No remover(No raiz, int info){
        if(raiz == null) return null;

        if(info < raiz.getInfo()){
            raiz.setProxEsq(remover(raiz.getProxEsq(), info));
        } else if(info > raiz.getInfo()){
            raiz.setProxDir(remover(raiz.getProxDir(), info));
        } else { 
            if(raiz.getProxEsq() == null && raiz.getProxDir() == null){
                return null;
            }

            // Caso 2: Nó com um filho
            if(raiz.getProxEsq() == null){
                return raiz.getProxDir();
            }
            if(raiz.getProxDir() == null){
                return raiz.getProxEsq();
            }

            // Caso 3: Nó com dois filhos
            No sucessor = minimo(raiz.getProxDir());
            raiz.setInfo(sucessor.getInfo());
            raiz.setProxDir(remover(raiz.getProxDir(), sucessor.getInfo()));
        }
        return raiz;
    }
    public int altura(){
        return altura(raiz);
    }

    private No insere(No raiz, int info) {
        // Inserção padrão da árvore binária de busca
        if (raiz == null) {
            return new No(info);
        }
        if (info < raiz.getInfo()) {
            raiz.setProxEsq(insere(raiz.getProxEsq(), info));
        } else if (info > raiz.getInfo()) {
            raiz.setProxDir(insere(raiz.getProxDir(), info));
        } else {
            return raiz; // Não permite duplicatas
        }

        // Atualiza a altura do nó
        raiz.setAltura(1 + maior(altura(raiz.getProxEsq()), altura(raiz.getProxDir())));

        // Calcula o fator de balanceamento
        int balance = fatorBalanceamento(raiz);

        // Rotação simples à direita (LL)
        if (balance > 1 && info < raiz.getProxEsq().getInfo()) {
            return rotacaoDireita(raiz);
        }

        // Rotação simples à esquerda (RR)
        if (balance < -1 && info > raiz.getProxDir().getInfo()) {
            return rotacaoEsquerda(raiz);
        }

        // Rotação dupla à esquerda-direita (LR)
        if (balance > 1 && info > raiz.getProxEsq().getInfo()) {
            raiz.setProxEsq(rotacaoEsquerda(raiz.getProxEsq()));
            return rotacaoDireita(raiz);
        }

        // Rotação dupla à direita-esquerda (RL)
        if (balance < -1 && info < raiz.getProxDir().getInfo()) {
            raiz.setProxDir(rotacaoDireita(raiz.getProxDir()));
            return rotacaoEsquerda(raiz);
        }

        return raiz;
    }

    // Rotação simples à direita (LL)
    private No rotacaoDireita(No y) {
        No x = y.getProxEsq();
        No T2 = x.getProxDir();

        x.setProxDir(y);
        y.setProxEsq(T2);

        // Atualiza alturas
        y.setAltura(1 + maior(altura(y.getProxEsq()), altura(y.getProxDir())));
        x.setAltura(1 + maior(altura(x.getProxEsq()), altura(x.getProxDir())));

        return x;
    }

    // Rotação simples à esquerda (RR)
    private No rotacaoEsquerda(No x) {
        No y = x.getProxDir();
        No T2 = y.getProxEsq();

        y.setProxEsq(x);
        x.setProxDir(T2);

        // Atualiza alturas
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

    // public void sucessor(int info) {

    //     No buscado = buscar(info);
    //     // if(buscado.getInfo() == maximo().getInfo()){
    //     //     System.out.println("nao existe sucessor para esse no");
    //     // }
    //     if (buscado == null) {
    //         System.out.println("nó não encontrado");
    //         return;
    //     } 
    //     if (buscado.getInfo() == this.raiz.getInfo()) {
    //         System.out.println("sucessor: " + this.raiz.getProxDir().getInfo());
    //         return;
    //     }
    //     if (buscado == this.maximo(this.raiz.getProxEsq())) {
    //         System.out.println("sucessor: " + this.raiz.getInfo());
    //         return;
    //     }
    //     if (buscado.getProxDir() == null) {
            
    //         if (buscado.getInfo() > this.raiz.getInfo()) {
    //             sucessor(this.raiz.getProxDir(), info);
    //             return;
    //         }
    //         sucessor(this.raiz.getProxEsq(), info);
    //     }
    // }

    // private void sucessor(No atual, int info) {
    //     No buscado = buscar(info);
    //     if (atual.getProxEsq() == buscado) {
    //         System.out.println("sucessor: " + atual.getInfo());
    //         return;
    //     }
    // }

    public void PreOrdem(){
        if(raiz == null){
            System.out.println("arvore vazia");  
        }
        PreOrdem(raiz);
        System.out.println("==============================");
    }

    private void PreOrdem(No raiz){
        if(raiz == null){
            return;
        }
        System.out.print(raiz.getInfo() + " ");
        PreOrdem(raiz.getProxEsq());
        PreOrdem(raiz.getProxDir());
        
        return;
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