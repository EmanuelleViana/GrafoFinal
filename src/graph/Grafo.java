/**
 * @author Emanuelle
 *
 * 19 de nov de 2016
 */
package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Emanuelle
 *
 */
public class Grafo {
	public class Aresta < T extends Comparable < Integer >  >  implements Comparable < Aresta < Integer > >  {
		private int v1,v2;
		private Integer peso;
		public Aresta(){}
		public Aresta(int v1,int v2,int peso){
			this.v1 = v1;
			this.v2 = v2;
			this.peso = peso;
		}
		public int getPeso() { return peso; }
		public int getV1(){return v1;}
		public int getV2(){return v2;}
		public int compareTo (Aresta < Integer >  obj) {
			return peso.compareTo (obj.getPeso());
		}
			public String toString() {
			return "(" + v1 + "," + v2 + ")   P."+ peso;
		}
	}
	
	private int[][] mGrafo;
	private int num_vertices;
	private boolean direcionado;
	private List<Aresta> arestas;
	
	/**
	 * Contrutor Padrao.
	 */
	public Grafo() {
		num_vertices = 0;
		direcionado = false;
		arestas = new ArrayList<Aresta>();

	}
	/**
	 * Contrutor Alternativo. Cria um grafo nulo sem arestas.
	 * @param v numero de vertices do grafo
	 * @param direcionado o grafo e orientado ou nao.
	 * @throws Exception quantidade de vertices negativa.
	 */
	public Grafo(int v, boolean direcionado) throws Exception{
		if (v < 0) {
			throw new Exception("Erro!O numero de vertices do grafo deve ser positivo!");
		}
		num_vertices = v;	
		mGrafo = new int[v][v];
		this.direcionado = direcionado;
		arestas = new ArrayList<Aresta>();

		//cria o grafo nulo
		for (int i = 0; i < num_vertices; i++) {
			for (int j = 0; j < num_vertices; j++) {
				mGrafo[i][j] = 0;
			}//fim for
		}//fim for
	}
	
	/**
	 * Inserir aresta ponderada entre dois vertices.
	 * @param v1 primeiro vertice.
	 * @param v2 segundo vertice.
	 * @param peso
	 * @return true se a insercao foi bem sucedida.
	 * @throws Exception 
	 */
	public boolean inserirAresta(int v1, int v2, int peso) throws Exception {
		boolean insert = true;
		//verifica se existem os vertices no grafo.
		if (v1 >= num_vertices || v2 >= num_vertices) {
			insert = false;
			throw new Exception("ERRO! Não é possível remover a Aresta.Alguns dos vértices não existem no grafo.");
		} else {
			if (!direcionado) {
				mGrafo[v1][v2] = peso;
				mGrafo[v2][v1] = peso;
				arestas.add(new Aresta<>(v1,v2,peso));
			} else {
				mGrafo[v1][v2] = peso;
				mGrafo[v2][v1] = -peso;
				arestas.add(new Aresta<>(v1,v2,peso));
			}
		}
		return insert;
	}//fim inserirAresta()

	/**
	 * Inserir aresta ponderada no grafo.
	 * @param a Aresta a ser inserida.
	 * @param peso
	 * @return true se a insercao foi bem sucedida.
	 * @throws Exception 
	 */
	public boolean inserirAresta(Aresta a) throws Exception{
		return inserirAresta(a.v1,a.v2,a.peso);
	}//fim inserirAresta()

	/**
	 * Remover Aresta entre dois vertices.
	 * @param v1 primeiro vertice da aresta.
	 * @param v2 segundo vertice da aresta.
	 * @return true se a remocao for bem sucedida.
	 * @throws Exception caso nao existam os vertices/aresta no grafo.
	 */
	public boolean removerAresta(int v1, int v2) throws Exception {
		boolean remove = true;
		if (v1 >= num_vertices || v2 >= num_vertices || mGrafo[v1][v2] == 0) {
			remove = false;
			throw new Exception("ERRO! Não é possível remover a Aresta pois ela não existe no grafo.");
		} else {
				mGrafo[v1][v2] = 0;
				mGrafo[v2][v1] = 0;
				//TODO remover aresta removida da lista 
				//if(arestas.contains(new Aresta<>(v1,v2,3)));

		}//fim if
		return remove;
	}//fim retirarAresta()
	
	/**
	 * Verificar a existencia de uma aresta entre dois vertices.
	 * @param v1 primeiro vertice.
	 * @param v2 segundo vertice.
	 * @return true se existe uma aresta entre os vertices.
	 */
	public boolean verificarAresta(int v1, int v2) {
		return mGrafo[v1][v2] != 0;
	}//fim verificarAresta()
	
	/**
	 * Contar quantidade de arestas no grafo.
	 * @return int quantidade de arestas.
	 */
	public int contArestas() {
		int count = 0;

			for (int i = 0; i < num_vertices; i++) {
				for (int j = i; j < num_vertices; j++) {
					if (mGrafo[i][j] != 0 && mGrafo[i][j] != -1) {
						count++;
					}
				}//fim for
			}
		return count;
	}//fim contArestas()
	
	/**
	 * Contar quantidade de vertices no grafo.
	 * @return int quantidade de vertices.
	 */
	public int contVertices() {
		return num_vertices;
	}//fim contArestas()
	
	/**
	 * Verificar se o grafo e completo.
	 * Sera completo se todos os vertices tiverem graus iguais e estes forem (num_vertices-1)
	 * @return
	 */
	public boolean isCompleto(){
		boolean resp = true;
		for (int i = 0; i < num_vertices; i++) {
			if (getGrau(i) != (num_vertices - 1)) {
				resp = false;
				break;
			}//fim if
		}//
		return resp;
	}//fim isCompleto()
	

	/**
	 * Obter o grau do vertice.
	 * Caso seja direcionado o grau sera a soma dos antecessores e sucessores do vertice.
	 * @param v vertice.
	 * @return int grau do vertice.
	 */
	public int getGrau(int v) {
		int resp = 0;
		if (!direcionado) {
			resp = getAdjacentes(v).size();
		} else {
			resp = getAntecessores(v).size() + getSucessores(v).size();
		}//fim if
		return resp;
	}//fim getGrau()
	
	/**
	 * Obter lista com vetices adjacentes de um vertice.
	 * @param v vetice u.
	 * @return ArrayList com todos adjacentes do vertice.
	 */
	public ArrayList<Integer> getAdjacentes(int v) {
			ArrayList<Integer> adj = new ArrayList<>();
			for (int j = 0; j < num_vertices; j++) {
				if (mGrafo[v][j] > 0) {
					adj.add(j);
				}//fim if
			}//fim for
			return adj;
	}//fim adjacentes()
	
	/**
	 * Obter antecessores de um vertice caso o grafo seja direcionado.
	 * @param v vertice.
	 * @return ArrayList com todos sucessores do vertice.
	 */
	private ArrayList<Integer> getAntecessores(int v) {
		ArrayList<Integer> ant = new ArrayList<>();
		for (int i = 0; i < num_vertices; i++) {
			if (mGrafo[v][i] < 0) {
				ant.add(i);
			}//fim if
		}//fim for
		return ant;
	}//fim getAntecessores()
	
	/**
	 * Obter sucessores de um vertice caso o grafo seja direcionado.
	 * @param v vertice.
	 * @return ArrayList com todos sucessores do vertice.
	 */
	private ArrayList<Integer> getSucessores(int v) {
		return getAdjacentes(v);
	}//fim getAntecessores()
	
	/**
	 * Obter grafo complementar.
	 * @return Grafo complementar.
	 * @throws Exception
	 */
	public Grafo getComplementar() throws Exception{
		Grafo compl = new Grafo(num_vertices,this.direcionado);
		for (int i = 0; i < num_vertices; i++) {
			for (int j = 0; j < num_vertices; j++) {

				if (verificarAresta(i, j) != true && i != j) {
					compl.inserirAresta(i, j,1);
				}//fim if
			}//fim for
		}//fim for
		return compl;
	}//fim getComplementar()
	
	/**
	 * Obter peso da aresta entre dois vertices.
	 * @param v primeiro vertice da aresta.
	 * @param v2 segundo vertice da aresta.
	 * @return peso
	 */
	public int getPeso(int v, int v2){
		return mGrafo[v][v2];
	}//fim getPeso()
	
	
	/**
	 * Verificar se um grafo e complementar.
	 * @param graph
	 * @return
	 * @throws Exception 
	 */
	public boolean isComplementar(Grafo graph) throws Exception {
		boolean resp = true;
		for (int i = 0; i < num_vertices; i++) {
			for (int j = 0; j < num_vertices; j++) {
				if (getComplementar().toMatriz()[i][j] != graph.toMatriz()[i][j]) {
					resp = false;
					break;
				}//fim if
			}//fim for
		}//fim for
		return resp;
	}
	/**
	 * Verificar se o grafo e direcionado.
	 * @return true se direcionado.
	 */
	public boolean isDirecionado() {
		return direcionado;
	}
	/**
	 * Obter objeto Grafo em Matriz.
	 * @return matriz com vertices e arestas.
	 */
	public int[][] toMatriz() {
		return mGrafo;
	}

	/**
	 * Imprimir matriz.
	 */
	public void imprimir() {
		System.out.print("\t");
		for (int i = 0; i < this.num_vertices; i++)
			System.out.print(i + "\t");
		System.out.println();
		for (int i = 0; i < this.num_vertices; i++) {
			System.out.print(i + "\t");
			for (int j = 0; j < this.num_vertices; j++)
				System.out.print(this.mGrafo[i][j] + "\t");
			System.out.println();
		}//fim for
	}//fim imprimir

	/**
	 * Obter todas as arestas do grafo.
	 * @return
	 */
	public List<Aresta> getAllArestas(){
		return arestas;
	}
	
	/**
	 * Mostrar caminho cavalo.
	 */
	public void printResult(){
		for (int[] row : mGrafo) {
            for (int i : row) {
                if (i == -1) continue;
                System.out.print("\t"+ i);
            }//fim for
            System.out.println();
        }//fim for
	}//fim printResult()
	
	/**
	 * Definir um subgrafo em uma floreta.
	 * @author Emanuelle
	 */
	public class subconjunto{ public int pais;
	public int rank; };
	
	/**
	 * Encontrar raiz de um subgrafo.
	 * @param subconjunto
	 * @param v vertice participante do subgrafo.
	 * @return
	 */
	public int encontrarRaiz(subconjunto subconjunto[], int v){
		if(subconjunto[v].pais != v)
			subconjunto[v].pais = encontrarRaiz(subconjunto,subconjunto[v].pais);
		return subconjunto[v].pais;
	}//fim encontrarRaiz()
	
	/**
	 * Unir dois subgrafos.
	 * @param sub conjunto de subgrafos.
	 * @param u primeiro vertice.
	 * @param v segundo vertice.
	 */
	public void uniao(subconjunto sub[], int u, int v){
		int uraiz = encontrarRaiz(sub,u);
		int vraiz = encontrarRaiz(sub,v);
		if(sub[uraiz].rank < sub[vraiz].rank)
			sub[uraiz].pais = vraiz;
		else if(sub[uraiz].rank > sub[vraiz].rank)
			sub[vraiz].pais = uraiz;
		else {
			sub[vraiz].pais = uraiz;
			sub[uraiz].rank++;
		}//fim if
	}//fim uniao()
	public boolean inserirCasa(int v1, int v2, int peso) throws Exception {
		boolean insert = true;
		//verifica se existem os vertices no grafo.
		if (v1 >= num_vertices || v2 >= num_vertices) {
			insert = false;
			throw new Exception("ERRO! Não é possível remover a Aresta.Alguns dos vértices não existem no grafo.");
		} else {
			if (!direcionado) {
				mGrafo[v1][v2] = peso;
				} else {
				mGrafo[v1][v2] = peso;
				mGrafo[v2][v1] = -peso;
			}
		}
		return insert;
	}//fim inserirAresta()
	
	public int maiorPeso(){
		int maior = Integer.MIN_VALUE;
		for(int i = 0; i < num_vertices;i++){
			for(int j = 0; j < num_vertices;j++){
				if(mGrafo[i][j] > maior){
					maior = mGrafo[i][j];
				}
			}
		}
		return maior;
	}
}
	

