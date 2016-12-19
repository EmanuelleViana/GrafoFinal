/**
 * @author Emanuelle
 *
 * 19 de nov de 2016
 */
package utils;

import java.util.ArrayList;
import java.util.Scanner;

import fluxo.FluxoMaximo;
import graph.Grafo;
import graph.LerGrafos;


/**
 * @author Emanuelle
 *
 */
public class Fluxo {
	Grafo grafo;
	
	public static void fluxoMaximo() throws Exception{
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
	   	System.out.println("\n");
	   	g.imprimir();
		
		System.out.println("O fluxo maximo posivel e " + FluxoMaximo.fluxoMaximo(g, 0, 5));
	
	
	}

}
