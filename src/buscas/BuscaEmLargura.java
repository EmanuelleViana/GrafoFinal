/**
 * @author Emanuelle
 *
 * 19 de nov de 2016
 */
package buscas;

import java.util.LinkedList;
import java.util.Queue;

import graph.Grafo;

/**
 * @author Emanuelle
 *
 */
public class BuscaEmLargura {
	public static final int  MAX_VALUE = -1;
	public static final int branco = 0, cinza = 1, preto = 2;

	private static int distancias[];
	private static int cores[];
	private static int pais[];

	/**
	 * Buscar o menor caminho de um vertice origem ate qualquer outro vertice.
	 * @param o vertice origem.
	 * @param grafo
	 * @return vetor de pais.
	 */
	public static int[] buscaEmLargura(int o,Grafo grafo) {
		int num_vertices = grafo.contVertices();
		pais = new int[num_vertices];

		cores = new int[num_vertices];
		//vetor de distancias
		distancias = new int[num_vertices];

		int u = 0;
		//inicializacoes
		for (u = 0; u < num_vertices; u++) {
			cores[u] = branco;
			distancias[u] = MAX_VALUE;
			pais[u] = MAX_VALUE;
		}
		//origem
		cores[o] = 1;
		distancias[0] = 0;

		Queue fila = new LinkedList();

		fila.add(o);

		while (!(fila.isEmpty())) {
			u = Integer.parseInt(fila.remove().toString());

			for (int i = 0; i < grafo.getAdjacentes(u).size(); i++) {
				int v = grafo.getAdjacentes(u).get(i);
				if (cores[v] == branco) {
					cores[v] = cinza;
					distancias[v] = distancias[u] + 1;
					pais[v] = u;
					fila.add(v);
				}//fim if
				cores[u] = preto;
			}//fim for
		}//fim while
		return pais;
	}

	/**
	 * Mostrar o menor caminho a partir de um vertice origem ate outro.
	 * Por Busca em Largura.
	 * @param grafo
	 * @param o vertice origem.
	 * @param x vertice destino.
	 */
	 public static void showCaminho(Grafo grafo,int o, int x) {
		int[] caminho = buscaEmLargura(o,grafo);
		String way = "";
		int indice = x;
		while (caminho[indice] != -1) {
			way = caminho[indice] + way;
			indice = caminho[indice];
		}//fim while

		if(way.length()!=0){
			way += x;
		}
		System.out.println("Caminho de " + o + " ate " + x + "\n" + way);
	}//fim showCaminho()

}
