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
        insereAuxiliar(info, raiz);
    }   
        
    public void insereAuxiliar(int info, No raiz){
        No novo = new No(info);
               
        if(raiz.getInfo() < novo.getInfo()){
            if(raiz.getProxDir() == null){
                raiz.setProxDir(novo);
            }
            else{
                insereAuxiliar(info, raiz.getProxDir());
            }
        }else{
            if(raiz.getInfo() > novo.getInfo()){
                if(raiz.getProxEsq() == null){
                    raiz.setProxEsq(novo);
                }
                else{
                    insereAuxiliar(info, raiz.getProxEsq());
                }
            }
        }
        
    }

    public No buscar(int info){
        if(raiz == null){
            System.out.println("null");
            return null;
        }
        return buscar(info, raiz);
    }

    private No buscar(int info, No raiz){
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