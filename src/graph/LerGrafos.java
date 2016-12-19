/**
 * @author Emanuelle
 *
 * 19 de nov de 2016
 */
package graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Emanuelle
 *
 */
public class LerGrafos {

	/*
	 * Ler varios grafos de um arquivo e armazena los em lista
	 */
public static	ArrayList<Grafo> fromArchive(String nome) throws Exception {

		String[] sv;
		String linha;
		ArrayList<Grafo> listaGrafos = new ArrayList<>();
		boolean direcionado = false;
		try {
			FileReader arquivo = new FileReader(nome);
			BufferedReader ler = new BufferedReader(arquivo);
			int i, j;

			linha = ler.readLine();
			while (linha != null) {

				//primeira linha diz se grafo ou digrafo
				if (linha.equals("1")) {
					 direcionado = true;
				}
				//segunda linha fornece o numero de vertices
				linha = ler.readLine();
				int num_vertices = Integer.parseInt(linha);

				Grafo g1;
				if (direcionado) {
					//cria um novo grafo
					g1 = new Grafo(num_vertices, true);
				} else {
					g1 = new Grafo(num_vertices, false);
				}
				listaGrafos.add((g1));
				for (i = 0; i < num_vertices; i++) {
					linha = ler.readLine();
					j = 0;
					sv = linha.split(",");
					while (j < num_vertices) {
						//System.out.println("i: " + i + " " + sv[j]);
						int bit = Integer.parseInt(sv[j]);
						if (bit > 0) {
							g1.inserirAresta(i, j,bit);
						}
						j++;
					}
				}
				linha = ler.readLine();

			}
		} catch (java.io.FileNotFoundException e) {
			System.out.println("ERRO.Nao foi possivel abrir o arquivo para leitura");
			pause();

			System.out.println("(Pressione 0 para voltar e abrir outro arquivo)");
			pause();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaGrafos;
	}
	
	

	public static void pause() {
		System.out.println("Pressione ENTER para continuar.");
		Scanner ler = new Scanner(System.in);
		String pause = ler.nextLine();
	}


	public Grafo fromTeclado() throws Exception{
		Grafo grafo ;

		int numV, opcao,dir;
		int v1, v2,peso;
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Quantidade de Vertices?");
		numV = ler.nextInt();
		
		System.out.println("Direcionado? 1-(SIM) 2-(NAO)");
		dir = ler.nextInt();

		grafo = new Grafo(numV,(dir==1));
		
		opcao = ler.nextInt();

		do {
			System.out.println("0.Voltar");
			System.out.println("1.Inserir Aresta");
			System.out.println("Opcao:");

			opcao = ler.nextInt();

			switch (opcao) {
			
			case 1: 
				v1 = ler.nextInt();
				v2 = ler.nextInt();
				peso = ler.nextInt();
				grafo.inserirAresta(v1,v2,peso);
				break;
			default:
				break;
			
			}
			}while(opcao!=0);
	return grafo;
	}
	

}
