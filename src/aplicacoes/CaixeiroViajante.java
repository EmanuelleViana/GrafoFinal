/**
 * @author Emanuelle
 *
 * 21 de nov de 2016
 */
package aplicacoes;

/**
 * @author Luciano
 *
 */
import graph.Grafo;

public class CaixeiroViajante {
	private static int[]caminho;
	private static int VerticeAtual;
	private static int VerticeProximo;
	
	public static void VizinhoProximo(Grafo g,int VerticeInicial){	
		int matriz[][] = g.toMatriz();
		caminho = new int[matriz[0].length];
		
		for(int i = 0; i < caminho.length;i++){
			caminho[i] = Integer.MAX_VALUE;
		}
		caminho[0] = VerticeInicial;
		
		VerticeAtual = VerticeInicial;
		
		int i = 1;
		
		while(i < caminho.length){
			VerticeProximo = MenorCaminho(matriz[VerticeAtual]);
			
			if(VerticeProximo != -1){
				caminho[i] = VerticeProximo;
				VerticeAtual = VerticeProximo;
				i++;
			}//fim if
		}//fim while
	}//fim vizinhoProximo()

	private static int MenorCaminho(int[]rows) {
		int ProximoVertice = -1;
		int i = 0;
		int minimo = Integer.MAX_VALUE;
		while(i < rows.length){
			if(!ECaminho(caminho,i) && rows[i]<minimo){
				minimo = rows[i];
				ProximoVertice = i;
			}//fim if
			i++;
		}//fim while
		return ProximoVertice;
	}//fim menorCaminho()
	

	private static boolean ECaminho(int[] caminho, int vertice) {
		for (int i = 0; i < caminho.length; i++) {
            if (caminho[i] == vertice) {
                return true;
            }//fim if
        }//fim for
		return false;
	}//fim e caminho()
	
	//retorna o array com o caminho
    public int[] getCaminho() {
        return caminho;
    }//fim getCaminho()
	
    public static void PrintCaminho(){
        for(int i = 0;i< caminho.length;i++){
        	if(i == caminho.length-1){
        		System.out.print(caminho[i]+"\n");
        	}else{
        		System.out.print(caminho[i]+" -> ");	
        	}
            
        }
    }//fim PrintCaminho()
}


