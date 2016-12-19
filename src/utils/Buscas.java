/**
 * @author Emanuelle
 *
 * 20 de nov de 2016
 */
package utils;

import java.util.ArrayList;
import java.util.Scanner;

import buscas.BuscaEmLargura;
import buscas.BuscaEmProfundidade;
import graph.Grafo;
import graph.LerGrafos;

/**
 * @author Emanuelle
 *
 */
public class Buscas {

public static void buscas(int op) throws Exception{
	System.out.println("Qual arquivo sera lido?");
	Scanner arq = new Scanner(System.in);

	String nome = arq.nextLine();
	ArrayList<Grafo> listGraphs = LerGrafos.fromArchive(nome);
	System.out.println(listGraphs.size()+" grafo(s) lidos.");
	for (int i = 0; i < listGraphs.size(); i++) {
	System.out.println("Grafo " + i);
	Grafo g = listGraphs.get(i);
	g.imprimir();
	
	System.out.println("Grafo "+(g.isDirecionado()?"direcionado":"nao direcionado")+","+
			(g.isCompleto()?"completo":"nao completo")+ " ,com "+g.contArestas() +" arestas.");
	
	int v = 0;
	while(v != g.contVertices()){
		if(op == 1){
		BuscaEmProfundidade.showCaminho(g, v);
		}
		else {
			BuscaEmLargura.showCaminho(g, v,5);

		}
		v++;
		
		}//fim while


	}//fim for				
}
	
}
