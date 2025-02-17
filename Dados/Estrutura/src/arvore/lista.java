package arvore;

public class lista {

    private No raiz;

    public lista() {
        this.raiz = null;
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
        if(raiz.getInfo() == info){
            if(raiz.getProxDir() != null && raiz.getProxEsq() == null){
                this.raiz = raiz.getProxDir();
                return;
            }
            if(raiz.getProxDir() == null && raiz.getProxEsq() != null){
                this.raiz = raiz.getProxEsq();
                return;
            }
            else{
                remover(raiz.getProxDir(),info);
                return;
            }

            
        }

        if(raiz.getInfo() > info){
            remover(raiz.getProxDir(), info);
            return;
        }
        remover(raiz.getProxDir(), info);
        return;
    }

    private void remover(No raiz, int info){
        
        if(raiz.getInfo() > info){
            if(raiz.getProxEsq().getInfo() == info){
                if(raiz.getProxEsq().getProxDir() == null && raiz.getProxEsq().getProxEsq() == null){
                    raiz.setProxEsq(null);
                    return;
                }
            }else{
                remover(raiz.getProxEsq(), info);
            }
        }
        if(raiz.getInfo() < info){
            if(raiz.getProxDir().getInfo() == info){
                if(raiz.getProxDir().getProxDir() == null && raiz.getProxDir().getProxEsq() == null){
                    raiz.setProxDir(null);
                    return;
                }
            }else{
                remover(raiz.getProxDir(), info);
            }
        }
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