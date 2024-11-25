package listacircular;

public class Lista {
    private No ref;

    public Lista() {
        this.ref = null;
    }

    public boolean vazia(){
        if (ref == null){
            return true;
        }return false;
    }

    public void insere(int info){
        No novo = new No(info, ref);
        if(vazia()){
            this.ref = novo;
            ref.setProx(novo);
            return;
        }else{
            if(ref.getInfo() < novo.getInfo()){
                novo.setProx(ref.getProx());
                ref.setProx(novo);
                this.ref = novo;
                return;
            }
            if(ref.getProx().getInfo() >= novo.getInfo() ){
                novo.setProx(ref.getProx());
                ref.setProx(novo);
                return;
            }else{
                for(No aux = ref.getProx(); aux != ref; aux = aux.getProx()){
                    if(aux.getInfo() <= novo.getInfo() && aux.getProx().getInfo() >= novo.getInfo()){
                        novo.setProx(aux.getProx());
                        aux.setProx(novo);
                        return;
                    }   
                }    
            }    
        }
    }

    public void remove(int info, boolean duplicados){
        if(duplicados){
            if(vazia()){
                return;
            }
            if(info == ref.getProx().getInfo() && info == ref.getInfo()){
                this.ref = null;
                return;
            }

            if(info == ref.getProx().getInfo()){
                for(No aux = ref.getProx(); aux != ref; aux = aux.getProx()){
                    if(info != aux.getProx().getInfo()){
                        ref.setProx(aux.getProx());
                        return;
                    }
                }
            }
            for(No aux = ref.getProx(); aux != ref; aux = aux.getProx()){
                if (aux.getProx().getInfo() == info){
                    for(No atual = aux.getProx(); atual != ref.getProx(); atual = atual.getProx()){
                        if(ref.getInfo() == info){
                            aux.setProx(ref.getProx());
                            this.ref = aux;
                            return;
                        }
                        if(atual.getInfo() > aux.getProx().getInfo()){
                            aux.setProx(atual);
                            return;
                        }
                    }
                }
            }
        }
        else{
            if(vazia()){
                return;
            }
            
            if(ref == ref.getProx()){
                this.ref = null;
                return;
            }
    
            for(No aux = ref.getProx(); aux != ref; aux = aux.getProx()){
                if(aux.getProx() == ref){
                    if(info == ref.getInfo()){
                        aux.setProx(ref.getProx());
                        this.ref = aux;      
                        return;
                    }
                }
                
                if(info == ref.getProx().getInfo()){
                    ref.setProx(aux.getProx());
                    return;
                }
    
                if(aux.getProx().getInfo() == info){
                    aux.setProx(aux.getProx().getProx());
                    return;
                } 
            }
        }    
    }
          
    public String imprime(){
        String lista = "";
        if(vazia()){
            return "lista vazia";
        }
        else{
            for(No aux = ref.getProx(); aux != ref; aux = aux.getProx()){
                lista += aux.getInfo() + " ";
            }lista += ref.getInfo();
            return lista;
        }
    }
}