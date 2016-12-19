/**
 * @author Emanuelle
 *
 * 21 de nov de 2016
 */
package agm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import graph.Grafo;
import graph.Grafo.Aresta;
import graph.Grafo.subconjunto;

/**
 * @author Emanuelle
 *
 */
public class Kruskal {
	private static PriorityQueue  < Aresta < Integer > >  arestas = new PriorityQueue  < Aresta < Integer > > ();	

	/**
	 * @throws Exception 
	 * Encontrar arvore geradora minima pelo algoritmo de kruskal.
	 */
	public static Grafo kruskal(Grafo g) throws Exception {
		int num_vertices = g.contVertices();
		Grafo agm = new Grafo(num_vertices,g.isDirecionado());
		//cria um array de subgrafos	
		subconjunto subconjunto[] = new subconjunto[num_vertices];
		sortArestas(g);
		Grafo grafo = new Grafo();
		
		//alocar memoria para vetor de subconjuntos
		for(int i = 0;i < num_vertices;++i){
			subconjunto[i] = grafo.new subconjunto();
		}//fim for
		
		//inicializa subgrafos com um vertice cada um
		for(int i = 0; i < num_vertices;++i){
			subconjunto[i].pais = i;
			//seta rank (nao ha galhos na floresta ainda)
			subconjunto[i].rank = 0;  
		}//fim for
		int aresta = 0;
		while( aresta < (num_vertices - 1)) {
			Aresta prox = g.new Aresta();
			prox = arestas.poll();
			int u = g.encontrarRaiz(subconjunto,prox.getV1());
			int v = g.encontrarRaiz(subconjunto,prox.getV2());

			//se u e v estiverem em um componente diferente
			if(u != v){
				agm.inserirAresta(prox);
				aresta++;
				g.uniao(subconjunto, u, v);
			}//fim if	
		}//fim while
		agm.imprimir();		
		return agm;
	}//fim kruskal()
	
	/**
	 * Adicionar todas as arestas em uma fila de prioridades.
	 * @param g grafo considerado.
	 */
	private static void sortArestas(Grafo g){
		Grafo g1 = new Grafo();
		List<Aresta> aresta = g.getAllArestas();		
		for(int i = 0; i < aresta.size();i++){
		Aresta a = aresta.get(i);
		arestas.offer(g1.new Aresta<>(a.getV1(), a.getV2(), a.getPeso()));
		}//fim if
	}//fim sortArestas()

}
