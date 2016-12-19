package aplicacoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import graph.Grafo;

/**
 * 
 * @author luciano
 * 20/11/2016
 */
public class PasseioDoCavalo {
	private static int base = 12;//cria bordas no tabuleiro
	private static int[][] movimentos = {{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2}};//movimentos do cavalo
	private static int total;//tamanho do tabuleiro
	private static Grafo g;
	
	/**
	 * Fun��o booleana para testar se � poss�vel o movimento do cavalo pelo tabuleiro, ap�s inser��o da 
	 * posi��o inicial, e baseando em sua vizinha�a
	 * @param linha inicial para inserir o cavalo
	 * @param coluna inicial para inserir o cavalo
	 * @param cont contador inicial
	 * @return true caso possa movimentar
	 * @throws Exception
	 */
	private static boolean temSolucao(int linha,int coluna,int cont) throws Exception{
		//contador for maior que tamanho do tabuleiro
		if(cont > total)
			return true;
			//inclui os vizinhos iniciais
		List<int[]>vznhos = vizinhos(linha,coluna);
		//caso n�o tenham vizinhos pare o programa o passeio
		if(vznhos.isEmpty() && cont != total)
			return false;
		
		Collections.sort(vznhos,new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[2] - b[2];
			}
		});
		
		//Compara vizinhos e se � possivel andar para a regi�o adjacente
		for(int[]nb:vznhos){
			linha = nb[0];
			coluna = nb[1];
			g.inserirCasa(linha, coluna, cont);
			if(!orfaoDetectado(cont,linha,coluna) && temSolucao(linha, coluna, cont+1))
				return true;
				g.inserirCasa(linha, coluna, cont);
		}
		
		return false;
	}
	
	/**
	 * Metodo para iniciar a contagem de vizinhos 
	 * @param linha posicao inicial
	 * @param coluna posicao inicial
	 * @return List de vizinhos
	 */
	private static List<int[]> vizinhos(int linha, int coluna) {
		List<int[]> vznhos = new ArrayList<>();
		// Baseia se nos movimentos dos vizinhos para seguir a frente 
		for(int[]mov:movimentos){
			int x = mov[0];
			int y = mov[1];
			if(!g.verificarAresta(linha+y,coluna+x)){
				int num = contarVizinhos(linha+y,coluna+x);
				vznhos.add(new int[]{linha+y,coluna+x,num});
			}
		}
		
		return vznhos;
	}
	
	/**
	 * Fun��o para contar os vizinhos de um v�rtice
	 * @param linha posicao
	 * @param coluna posicao
	 * @return num de vizinhos do v�rtice
	 */
	private static int contarVizinhos(int linha, int coluna) {
		int num = 0;
		for(int[]m:movimentos){
			if(!g.verificarAresta(linha+m[1], coluna+m[0]))
				num++;
		}
		return num;
	}
	
	/**
	 * Testar se o vizinho n�o contem liga��o com o v�rtice
	 * @param cont contador
	 * @param linha posicao do v�rtice
	 * @param coluna coluna do v�rtice
	 * @return true se cont�m vizinho vazio
	 */
	private static boolean orfaoDetectado(int cont, int linha, int coluna) {
			if(cont < total-1){
				List<int[]>vzinhos = vizinhos(linha,coluna);
				for(int[]vz:vzinhos)
					if(contarVizinhos(vz[0],vz[1])==0)
						return true;
			}
		return false;
	}

	/**
	 * Fun��o para iniciar o preenchimento do tabuleiro
	 * @param linha posicao inicial
	 * @param coluna posicao inicial
	 * @param cont contador
	 * @throws Exception
	 */

	public static void TourCavalo(int linha,int coluna,int cont) throws Exception{
		g = new Grafo(base, false);
		total = (base - 4) * (base - 4);
		//Gera as bordas do tabuleiro
		for(int i = 0; i < base;i++){
			for(int j = 0; j < base;j++){
				if(i < 2|| i > base - 3|| j < 2 || j > base -3){
					g.inserirCasa(i, j, -1);
				}
			}
		}
		
		//Seta a posi��o inicial no tabuleiro
			g.inserirCasa(linha, coluna, 1);
			//percorre todo tabuleiro e retorna se com a posi��o dada pode ocorrer o passeio e imprimi o passeio
			if(temSolucao(linha, coluna, cont)){
				g.printResult(); 	
			}else{
				System.out.println("c");
			}		
	}
}
