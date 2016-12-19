/**
 * @author Emanuelle
 *
 * 19 de nov de 2016
 */
package fluxo;

import java.util.LinkedList;

import graph.Grafo;
import buscas.BuscaEmProfundidade;



/**
 * @author Emanuelle
 *
 */
public class FluxoMaximo {
	  
	   public static int fluxoMaximo(Grafo grafo, int source, int terminal) throws Exception
	    {
	        int v, w;	        
		    int num_vertices = grafo.contVertices();
		  //grafo para armazenar caminho residual
	        Grafo grafoR = new Grafo(num_vertices,true);	
	      //inicializa grafo residual com todos caminhos  
	        for (v = 0; v < num_vertices; v++)
	            for (w = 0; w < num_vertices; w++)
	                grafoR.inserirAresta(v, w, grafo.toMatriz()[v][w]);	
	   
	        int pais[] = new int[num_vertices];
	 
	        int fluxoMaximo = 0;  

	        while (BuscaEmProfundidade.buscaEmFluxo(grafoR,source,terminal,pais)){	//enquanto encontrar um caminho do source ate o terminal
	            int fluxoCaminho = Integer.MAX_VALUE;	//inicializa o fluxo naquele camiho
	            String way = "";
	            for (w = terminal; w != source; w = pais[w]){
	                v = pais[w];
	            	way = "("+pais[w]+","+ w+")"+way;

	                fluxoCaminho = Math.min(fluxoCaminho, grafoR.toMatriz()[v][w]);
	            }//fim for
	            way+="|Carga Transmitida:" + fluxoCaminho;
	   	            
            	System.out.println("->"+way);
	 
	            //atualizar a quantidade que pode adicionar nas arestas
	            for (w = terminal; w != source; w = pais[w]){
	                v = pais[w];
	                grafoR.toMatriz()[v][w] -= fluxoCaminho;	//subtrai o fluxo maximo
	                grafoR.toMatriz()[w][v] += fluxoCaminho;	
	            }
	      	   
	            fluxoMaximo += fluxoCaminho;	//adiciona o fluxo maximo no terminal
	        }	     	        
	        return fluxoMaximo;
	    }//fim fluxoMaximo()
}
	  
	  
	  
	  