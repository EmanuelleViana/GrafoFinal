/**
 * @author Emanuelle
 *
 * 19 de nov de 2016
 */
package utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import agm.Kruskal;
import agm.Prim;
import graph.Grafo;
import graph.Grafo.Aresta;

/**
 * @author Emanuelle
 *
 */
public class AutonomiaBateria {
public static final int A = 0, B = 1, C = 2, D = 3, E = 4, F = 5, G = 6, H = 7,
						I = 8, J = 9, K = 10, L = 11, M = 12;

public static void autonomiaBateria() throws Exception{
    Grafo g = new Grafo(13,false);
    System.out.println("\nGrafo Original");
    g.inserirAresta(A,C,10);
    g.inserirAresta(A,B,2);
    g.inserirAresta(A,D,15);
    g.inserirAresta(B,L,3);
    g.inserirAresta(L,M,10);
    g.inserirAresta(L,D,6);
    g.inserirAresta(C,D,5);
    g.inserirAresta(D,K,12);
    g.inserirAresta(C,E,3);
    g.inserirAresta(F,E,1);
    g.inserirAresta(E,G,2);
    g.inserirAresta(G,H,8);
    g.inserirAresta(I,H,7);
    g.inserirAresta(I,J,11);
    g.inserirAresta(J,M,15);
    g.inserirAresta(M,I,12);
    g.inserirAresta(D,I,9);
    g.imprimir();
   System.out.println("\nAlgoritmo de Prim");
    Grafo agm = Prim.alPrim(g);   
    System.out.println("\nAlgoritmo de Kruskal");
    Grafo agmK = Kruskal.kruskal(g);
    System.out.println("Para uma bateria ter autonomia minima devera ser capaz de \numa cidade a outra chegar, a partir do maior caminho da arvore geradora minima acima");
    System.out.println("\nA solução da autonomia minima e: "+agm.maiorPeso()+" - via algoritmo de Prim ");
    System.out.println("\nA solução da autonomia minima e: "+agmK.maiorPeso()+" - via algoritmo de Kruskal\n ");
}


}
