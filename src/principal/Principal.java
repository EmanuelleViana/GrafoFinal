/**
 * @author Emanuelle
 *
 * 19 de nov de 2016
 */
package principal;

import java.util.ArrayList;
import java.util.Scanner;

import aplicacoes.PasseioDoCavalo;
import graph.Grafo;
import graph.LerGrafos;
import utils.AutonomiaBateria;
import utils.Buscas;
import utils.Caixeiro;
import utils.Fluxo;
import utils.PasseioCavalo;
/**
 * @author Emanuelle
 *
 */
public class Principal {
	Grafo g = new Grafo();
	static ArrayList<Grafo> listGraphs1;

	public static void uiParte0() throws Exception{
		int opcao, newOpcao;
		int v1, v2;
		Grafo g;
		Scanner ler = new Scanner(System.in);
		ArrayList<Grafo> listGraphs;

		do {
			System.out.println("\tParte 00 (Base) (Escolha uma opcao)");
			System.out.println("0. Voltar");
			System.out.println("1. Ler grafos de arquivo");
			System.out.println("Opcao:");
			String nome ;

			opcao = ler.nextInt();
			switch(opcao){
			case 1: 
				System.out.println("Qual arquivo sera lido?");
				Scanner arq = new Scanner(System.in);

				nome = arq.nextLine();
				listGraphs = LerGrafos.fromArchive(nome);
				System.out.println(listGraphs.size()+" grafo(s) lidos.");
				for (int i = 0; i < listGraphs.size(); i++) {
				System.out.println("Grafo " + i);
				g =	listGraphs.get(i);
				g.imprimir();
				
				System.out.println("Grafo "+(g.isDirecionado()?"direcionado":"nao direcionado")+","+
						(g.isCompleto()?"completo":"nao completo")+ " ,com "+g.contArestas() +" arestas.");
				
				System.out.println("\nArestas e Pesos\n"+g.getAllArestas());
				int v = 0;
				while(v != g.contVertices()){
					System.out.println("Grau do Vertice "+v+" = "+g.getGrau(v));
					v++;
					}//fim while
				System.out.println("O complementar e ");
				g.getComplementar().imprimir();

				}//fim for				
				listGraphs1 = (ArrayList<Grafo>) listGraphs.clone();
				LerGrafos.pause();
				break;
			default:
				break;
			}
		} while (opcao != 0);
	}//fim uiParte1()
	
	
	public static void uiParte1() throws Exception{
		int opcao, newOpcao;
		int v1, v2;
		Grafo g;
		Scanner ler = new Scanner(System.in);
		
		do {
			System.out.println("\tParte 01 (Buscas) (Escolha uma opcao)");
			System.out.println("0. Voltar");
			System.out.println("1. Busca Em Profundidade");
			System.out.println("2. Busca Em Largura");
			System.out.println("Opcao:");

			opcao = ler.nextInt();
			switch(opcao){
			case 1: 
			Buscas.buscas(1);
			LerGrafos.pause();
				break;
			case 3:
				Buscas.buscas(2);
				LerGrafos.pause();
				break;
			default:
				break;
			}
		} while (opcao != 0);
	}//fim uiParte1()

	public static void uiParte2() throws Exception{
		int opcao, newOpcao;
		int v1, v2;
		Grafo g;
		Scanner ler = new Scanner(System.in);
		
		do {
			System.out.println("\tParte 02 (Aplicacoes) (Escolha uma opcao)");
			System.out.println("0. Voltar");
			System.out.println("1. Passeio do Cavalo");
			System.out.println("2. Caixeiro Viajante(Extra)");
			System.out.println("Opcao:");

			opcao = ler.nextInt();
			switch(opcao){
			case 1: 
				
				PasseioCavalo.tourCavalo();
				LerGrafos.pause();
				break;
			case 2:
				Caixeiro.caminhoCaixeiro(listGraphs1.get(0));
				LerGrafos.pause();
				break;
			default:
				break;
			}
		} while (opcao != 0);
	}//fim uiParte2()
	
	public static void uiParte3() throws Exception{
		int opcao, newOpcao;
		int v1, v2;
		Scanner ler = new Scanner(System.in);
		
		do {
			System.out.println("\tParte 03 (Aplicacoes) (Escolha uma opcao)");
			System.out.println("0. Voltar");
			System.out.println("1. Autonomia de Bateria");
			System.out.println("2. Fluxo Maximo (EXTRA)");
			System.out.println("Opcao:");

			opcao = ler.nextInt();
			switch(opcao){
			case 1: 
				AutonomiaBateria.autonomiaBateria();
				break;
			case 2:
				Fluxo.fluxoMaximo();
				break;
			default:
				break;
			}
		} while (opcao != 0);
	}//fim uiParte3()
	
	public static void main(String[] args) throws Exception {
		int opcao, newOpcao;
		Grafo g1 = new Grafo();
		int v1, v2;
		Scanner ler = new Scanner(System.in);
		
		do {
			System.out.println("\tGrafos (Escolha uma opcao)");
			System.out.println("4. Sair");
			System.out.println("0. Parte 00 (Base)");
			System.out.println("1. Parte 01 (Buscas)");
			System.out.println("2. Parte 02 (Aplicacoes)");
			System.out.println("3. Parte 03 (Aplicacoes)");
			System.out.println("Opcao:");
			
			//TODO Caixeiro Viajante e Passeio do Cavalo(extra)
			opcao = ler.nextInt();
			switch(opcao){
			case 0: uiParte0();
			break;
			case 1: uiParte1();
				break;
			case 2: uiParte2();
				break;
			case 3: uiParte3();
				break;
			default:
				break;
			}
		} while (opcao != 4);		
	}//fim main

}
