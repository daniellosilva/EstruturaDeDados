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

    private void remover(int info){
        if(raiz.getInfo() == info){
            return;
        }
        //if(raiz.getProxDir().getProxDir() == null || raiz.getProxDir().getProxEsq() == null || raiz.getProxEsq().getProxEsq() == null || raiz.getProxEsq().getProxDir() == null){
          //  raiz.s
        //}

        if(raiz.getProxDir().getInfo() == info){
            if(raiz.getProxDir().getProxEsq() == null || raiz.getProxDir().getProxDir() == null){
                raiz.setProxDir(null);
            }
        }else{
            if(raiz.getProxEsq().getProxEsq() == null || raiz.getProxEsq().getProxDir() == null){
                raiz.setProxEsq(null);
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

    public void sucessor(int info){
        No numeroB = buscar(info);
       
        if(numeroB == null) {
            System.out.println("nó não existe");
            return;
        }
        if(numeroB == maximo(raiz.getProxEsq())){
            System.out.println("sucessor: " + raiz.getInfo());
            return;
        }
        if(numeroB.getProxDir() == null){
            if(numeroB.getInfo() < raiz.getInfo()){
                sucessor(raiz.getProxEsq(), info);
                return;
            }
            sucessor(raiz.getProxDir(), info);
            return;
        }
    }

    private void sucessor(No raiz, int info){
        No numeroB = buscar(info);
        if(raiz.getProxEsq() == numeroB){
            System.out.println("sucessor sem proximo: " + raiz.getInfo());
            return;
        }
        if(raiz.getProxEsq() == null){
            System.out.println("sucessor: " + raiz.getInfo());
            return;
        }
        
        sucessor(raiz.getProxEsq(), info);
        return;
    }

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