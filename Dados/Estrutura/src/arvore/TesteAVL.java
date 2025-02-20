package arvore;

import static org.junit.Assert.assertEquals;
import org.junit.*;

public class TesteAVL {

    //1-inserções simples que não requeiram balanceamento (0,5)
    @Test
    public void test() {
        AVL avl = new AVL(10);
        avl.insere(5);
        avl.insere(16);
        avl.insere(1);
        avl.insere(12);
        avl.insere(20);

        assertEquals("10(0)5(1)1(0)16(0)12(0)20(0)", avl.preOrdem().replace(" ", "").replace(",", ""));
    }

    //2-remoção de nó sem filhos (0,5)
    @Test
    public void test2() {
        AVL avl = new AVL(10);
        avl.insere(5);
        avl.insere(16);
        avl.insere(1);
        avl.insere(12);
        avl.insere(20);
        avl.remove(12);
        assertEquals("10(0)5(1)1(0)16(-1)20(0)", avl.preOrdem().replace(" ", "").replace(",", ""));
    }

    //3-remoção de nó com 1 filho à direita (0,5)
    @Test
    public void test3() {
        AVL avl = new AVL(10);
        avl.insere(5);
        avl.insere(16);
        avl.insere(7);
        avl.insere(12);
        avl.insere(20);
        avl.remove(5);
        assertEquals("10(-1)7(0)16(0)12(0)20(0)", avl.preOrdem().replace(" ", "").replace(",", ""));
    }

    //4-remoção de nó com 1 filho à esquerda (0,5)
    @Test
    public void test4() {
        AVL avl = new AVL(10);
        avl.insere(5);
        avl.insere(16);
        avl.insere(1);
        avl.insere(12);
        avl.insere(20);
        avl.remove(5);
        assertEquals("10(-1)1(0)16(0)12(0)20(0)",avl.preOrdem().replace(" ", "").replace(",", ""));
    }

    //5-remoção de nó com 2 filhos, e que seja um filho à direita (0,5)
    @Test
    public void test5() {
        AVL avl = new AVL(10);
        avl.insere(5);
        avl.insere(16);
        avl.insere(1);
        avl.insere(12);
        avl.insere(20);
        avl.remove(16);
        assertEquals("10(0)5(1)1(0)20(1)12(0)",avl.preOrdem().replace(" ", "").replace(",", ""));
    }

    //6- inserção requer rotação simples à esquerda
    @Test
    public void test6() {
        AVL avl = new AVL(10);
        avl.insere(20);
        avl.insere(30);
        assertEquals("20(0)10(0)30(0)", avl.preOrdem().replace(" ", "").replace(",", ""));
    }

    //7- inserção requer rotação simples à direita
    @Test
    public void test7() {
        AVL avl = new AVL(5);
        avl.insere(7);
        avl.insere(9);
        assertEquals("7(0)5(0)9(0)", avl.preOrdem().replace(" ", "").replace(",", ""));
    }

    //8- inserção requer rotação dupla dupla à direita
    @Test
    public void test8() {
        AVL avl = new AVL(10);
        avl.insere(5);
        avl.insere(7);
        assertEquals("7(0)5(0)10(0)", avl.preOrdem().replace(" ", "").replace(",", ""));
    }

    //9- inserção requer rotação dupla à esquerda
    @Test
    public void test9() {
        AVL avl = new AVL(10);
        avl.insere(30);
        avl.insere(20);
        assertEquals("20(0)10(0)30(0)", avl.preOrdem().replace(" ", "").replace(",", ""));
    }

    //10- remoção que requer rotação balanceamento (rotação simples dir)
    @Test
    public void test10() {
        AVL avl = new AVL(30);
        avl.insere(20);
        avl.insere(10);
        avl.remove(30);
        assertEquals("20(1)10(0)", avl.preOrdem().replace(" ", "").replace(",", ""));
    }

    //11- remoção que requer balanceamento (rotação simples esq)
    @Test
    public void test11() {
        AVL avl = new AVL(10);
        avl.insere(20);
        avl.insere(30);
        avl.remove(10);
        assertEquals("20(-1)30(0)", avl.preOrdem().replace(" ", "").replace(",", ""));
    }

    //12- inserção que requer balanceamento seguido de remoção que também requer balanceamento
    @Test
    public void test12() {
        AVL avl = new AVL(10);
        avl.insere(20);
        avl.insere(30);
        avl.remove(30);
        assertEquals("20(1)10(0)", avl.preOrdem().replace(" ", "").replace(",", ""));
    }

    //esvaziar AVL e reinserir elementos
    @Test
    public void test13() {
        AVL avl = new AVL(10);
        avl.insere(40);
        avl.insere(50);
        avl.insere(7);
        assertEquals("40(1)10(1)7(0)50(0)", avl.preOrdem().replace(" ", "").replace(",", ""));
        avl.remove(40);
        avl.remove(10);
        avl.remove(50);
        avl.remove(7);
        assertEquals("", avl.preOrdem().replace(" ", "").replace(",", ""));
        avl.insere(2);
        avl.insere(1);
        avl.insere(3);
        assertEquals("2(0)1(0)3(0)", avl.preOrdem().replace(" ", "").replace(",", ""));
    }
}