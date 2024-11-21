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

    public void insereAuxiliar(int info, No raiz){
        No novo = new No();
        System.out.println("1");
        if(raiz.getInfo() < novo.getInfo()){
            System.out.println("ola");
            if(raiz.getProxDir() == null){
                raiz.setProxDir(novo);
                return;
            }
        }
        
        if(raiz.getInfo() > novo.getInfo()){
            if(raiz.getProxEsq() == null){
                raiz.setProxEsq(novo);
                return;
            }
        }
    }

    public void insere(int info){
        No novo = new No(info);
        if(ArvoreVazia()){
            this.raiz = novo;
            return;
        }
        if(raiz.getInfo() < info){
            raiz.setProxDir(novo);
            return;
        }     
        if(raiz.getInfo() > info){
            raiz.setProxEsq(novo);
            return;
        }
        if(raiz.getProxDir() != null){
            System.out.println("1");
            insereAuxiliar(info, raiz.getProxDir());
            return;
        }
        if(raiz.getProxDir() != null){
            insereAuxiliar(info, raiz.getProxEsq());
            return;
        }
        
    }

    public void PreOrdem(No raiz){
        if(raiz == null){
            return;
        }
        System.out.print(raiz.getInfo() + " ");
        PreOrdem(raiz.getProxEsq());
        PreOrdem(raiz.getProxDir());
        return;
    }

    public void EmOrdem(No raiz){
        if(raiz == null){
            return;
        }
        EmOrdem(raiz.getProxEsq());
        System.out.println(raiz.getInfo() + " ");
        EmOrdem(raiz.getProxDir());
        return;
    }

    public void PosOrdem(No raiz){
        if(raiz == null){
            return;
        }
        PosOrdem(raiz.getProxEsq());
        PosOrdem(raiz.getProxDir());
        System.out.println(raiz.getInfo()+ " ");
        return;
    }
}