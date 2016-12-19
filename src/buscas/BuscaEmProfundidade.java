/**
 * @author Emanuelle
 *
 * 19 de nov de 2016
 */
package buscas;
import java.util.LinkedList;

import graph.Grafo;

/**
 * @author Emanuelle
 *
 */
public class BuscaEmProfundidade {
	public static final int branco = 0, cinza = 1, preto = 2;

	private static int[] tDescoberta;
	private static int[] tTermino;
	private static int[] pais;
	
	/**
	 * Buscar um caminho de um vertice ate qualquer outro vertice.
	 * @param grafo
	 * @return pais vetor de pais.
	 */
	public static int[] buscaEmProfundidade(Grafo g,int o) {
		int num_vertices = g.contVertices();
		int[] cores = new int[num_vertices];
		tDescoberta = new int[num_vertices];
		tTermino = new int[num_vertices];
		pais = new int[num_vertices];

		//inicializacoes
		int tempo = 0;
	//	System.out.println(tDescoberta.length);
		for (int i = 0; i < num_vertices; i++) {
			cores[i] = branco;
			tDescoberta[i] = -1;
			tTermino[i] = -1;
			pais[i] = -1;
		}
		//para cada vertice visita em profundidade os vizinhos nao visitados
		for (int u = o; u < num_vertices; u++) {
			if (cores[u] == branco) {
				tempo = visitaDFS(u, tempo, cores,g);
			} else if (cores[u] == cinza) {
				System.out.println("Aresta de retorno:" + u);
			}//fim if
		}//fim for

		return pais;
	}//fim BuscaEmProfundidade()

	/*
	 * Faz a busca em profundidade.
	 * @param u vertice pai.
	 * @param tempo do vertice.
	 * @param cores vetor com as cores.
	 * @param g grafo considerado.
	 * @return tempo do vertice.
	 */
	private static int visitaDFS(int u, int tempo, int[] cores, Grafo g) {
		int branco = 0, cinza = 1, preto = 2;
		int v;
		tempo++;
		tDescoberta[u] = tempo;
		cores[u] = cinza;

		for (int k = 0; k < g.getAdjacentes(u).size(); k++) {
			v = g.getAdjacentes(u).get(k);
			if (cores[v] == branco) {
				pais[v] = u;
				tempo = visitaDFS(v, tempo, cores,g);
			} else if (cores[v] == cinza) {
				System.out.println("*Aresta de retorno: (" + u + "," + v + ")");
			}
		}//fim for
		cores[u] = preto;
		tempo++;
		tTermino[u] = tempo;

		return tempo;
	}//fim visitaDFS
	
	/**
	 * Mostrar o  caminho a partir de um vertice origem ate outro.
	 * Por Busca em Largura.
	 * @param grafo
	 * @param o vertice origem.
	 * @param x vertice destino.
	 */
	public static void showCaminho(Grafo grafo,int x) {
		int[] caminho = buscaEmProfundidade(grafo, x);
		String way = "";
		int indice = x;
		while (caminho[indice] != -1) {
			way = caminho[indice] + way;
			indice = caminho[indice];
		}//fim while
		System.out.println("Caminho \n" + way);
	}//fim showCaminho()
	/**
	 * Busca em Profundidade de um source para um terminal.
	 * @param grafo
	 * @param s saida do fluxo.
	 * @param t chegada do fluxo.
	 * @param pais.
	 * @return
	 */
	  public static boolean buscaEmFluxo(Grafo grafo, int s, int t,int[]pais){
	    	int grafoR[][] = grafo.toMatriz();
	       //inicializacoes
	       //marcar todos os vertices como nao visitados
	    	int num_vertices = grafo.contVertices();
	        boolean visitados[] = new boolean[num_vertices];

	        for(int i = 0; i < num_vertices; ++i)
	        	visitados[i]=false;	 
	        //visita o primeiro vertice que corresponde ao source
	        LinkedList<Integer> fila = new LinkedList<Integer>();
	        fila.add(s);
	        visitados[s] = true;
	        pais[s]=-1;	

	        //retirar da fila 
	        while (fila.size()!=0){
	        	int u = fila.poll();
	        	for (int i = 0; i < num_vertices; i++)
	        	{
	        		if (visitados[i] == false && grafoR[u][i] > 0){ 
	        			fila.add(i);	//adiciona na fila
	        			pais[i] = u;	//encontra o pai
	        			visitados[i] = true;	//coloca como visitado
	        		}//fim if
	        	}//fim for
	        }//fim while	 	      	
	 	  return (visitados[t] == true);
	    }//fim bfs()
	 
}
