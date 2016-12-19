/**
 * @author Emanuelle
 *
 * 19 de nov de 2016
 */
package agm;
import java.util.ArrayList;
import java.util.PriorityQueue;

import graph.Grafo;
import graph.Grafo.Aresta;

/**
 * @author Emanuelle
 *
 */
public class Prim {
private static PriorityQueue  < Aresta < Integer > >  filaP = new PriorityQueue  < Aresta < Integer > > ();	

/**
 * Encontrar arvore geradora minima.
 * @param g grafo considerado.
 * @return agm arvore geradora minima.
 * @throws Exception
 */
	public static Grafo alPrim(Grafo g) throws Exception {
		int num_vertices = g.contVertices();
		Grafo agm = new Grafo(num_vertices,g.isDirecionado());
		ArrayList<Integer> visitados = new ArrayList<>();

		//inicializacoes
		int raiz = 0;
		visitados.add(0);
		
		//fila de prioridades recebe todas as arestas do vertice inicial
		addFila(g,raiz); 
		
		while(visitados.size()<num_vertices) {
			//retirar menor aresta da fila de prioridades
			Aresta removida = filaP.poll();
		
			int v1 = removida.getV1();
			int v2 = removida.getV2();
			//verifica se ja visitou o vertice da aresta minima
			if (visitados.contains(v1) && visitados.contains(v2)) {
				//nao faz nada, so deixa a aresta retirada
			} else if (!(visitados.contains(v1))) {
				visitados.add(removida.getV1());    //add nos inseridos
				agm.inserirAresta(removida);
				raiz = v1;				
				addFila(g,raiz);
			} else if (!(visitados.contains(v2))) {
				visitados.add(removida.getV2());    //add nos inseridos
				agm.inserirAresta(removida);
				raiz = v2;				
				addFila(g,raiz);
			}//fim if
		}//fim while
		agm.imprimir();

		return agm;
	}
	/*
	 * Adicionar arestas que saem de um vertice raiz na fila de prioridades.
	 * @param g grafo considerado.
	 * @param raiz vertice raiz.
	 */
	private static void addFila(Grafo g,int raiz)throws Exception{
		ArrayList<Integer> adjacentes = g.getAdjacentes(raiz);
		for (int i = 0; i < adjacentes.size(); i++) {
			int adj = adjacentes.get(i);
			int peso = g.getPeso(raiz,adjacentes.get(i));
			Grafo grafo = new Grafo();
			//coloca na fila a aresta
			filaP.offer(grafo.new Aresta<>(raiz, adj, peso));
		}
	}
}
