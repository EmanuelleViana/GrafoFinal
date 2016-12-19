/**
 * @author Emanuelle
 *
 * 21 de nov de 2016
 */
package utils;

import java.util.Scanner;

import graph.Grafo;

/**
 * @author Emanuelle
 *
 */
public class Caixeiro {

	/**
	 * @throws Exception 
	 * 
	 */
	public static void caminhoCaixeiro(Grafo g1) throws Exception {
		Grafo g = new Grafo(5,false);
	    g.inserirAresta(0,1,10);
	    g.inserirAresta(1,2,0);
	    g.inserirAresta(1,3,11);

	    System.out.println("Posicao Inicial : ");
		Scanner ler = new Scanner(System.in);
		int v1 = ler.nextInt();
		aplicacoes.CaixeiroViajante.VizinhoProximo(g1, v1);
		aplicacoes.CaixeiroViajante.PrintCaminho();	}

}
