/**
 * @author Emanuelle
 *
 * 19 de nov de 2016
 */
package buscas;

import java.util.LinkedList;

import agm.Kruskal;
import agm.Prim;
import graph.Grafo;


/**
 * @author Emanuelle
 *
 */
public class Testes {
	  
		  
	  public void t(Grafo g){
			BuscaEmLargura.showCaminho(g,0,4);

	  }
	  
	/**
	 * @throws Exception 
	 * 
	 */
	public static void main(String[]args) throws Exception {

		
	    Grafo g = new Grafo(13,false);
	    g.inserirAresta(0,2,10);
	    g.inserirAresta(0,1,2);
	    g.inserirAresta(0,3,15);
	    g.inserirAresta(1,11,3);
	    g.inserirAresta(11,12,10);
	    g.inserirAresta(11,3,6);
	    g.inserirAresta(2,3,5);
	    g.inserirAresta(3,10,12);
	    g.inserirAresta(2,4,3);
	    g.inserirAresta(5,4,1);
	    g.inserirAresta(4,6,2);
	    g.inserirAresta(6,7,8);
	    g.inserirAresta(8,7,7);
	    g.inserirAresta(8,9,11);
	    g.inserirAresta(9,12,15);
	    g.inserirAresta(12,8,12);
	    g.inserirAresta(3,8,9);
	    System.out.println(g.contArestas());
	    g.imprimir();
	    Kruskal.kruskal(g);

		/*Grafo g = new Grafo(4,false);
	    g.inserirAresta(0,1,10);
	    g.inserirAresta(0,3,5);
	    g.inserirAresta(0,2,6);
	    g.inserirAresta(1,3,15);
	    g.inserirAresta(2,3,4);
	    System.out.println("KRUSKAL");
	    Kruskal.kruskal(g);
	    */
	    
		
		/*
	Grafo g = new Grafo(6,true);
	g.inserirAresta(0,1,16);
	g.inserirAresta(0,2,13);
	g.inserirAresta(1,2,10);
	g.inserirAresta(1,3,12);
	g.inserirAresta(2,4,14);
	g.inserirAresta(3,2,9);
	g.inserirAresta(3,5,20);
	g.inserirAresta(4,3,7);
	g.inserirAresta(4,5,4);
	//bfs(g,0,5);
   	System.out.println("\n");

	
	BuscaEmLargura.showCaminho(g,1,4);

	//fluxo
//	System.out.println("O fluxo maximo posivel e " + fordFulkerson(g, 0, 5));
*/
	      
	        
	}
	
	
	
	

}
