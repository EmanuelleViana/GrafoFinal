/**
 * @author Emanuelle
 *
 * 21 de nov de 2016
 */
package utils;

import java.util.Scanner;

import aplicacoes.PasseioDoCavalo;

/**
 * @author Emanuelle
 *
 */
public class PasseioCavalo {

	/**
	 * @throws Exception 
	 * 
	 */
	public static void tourCavalo() throws Exception {
		Scanner ler = new Scanner(System.in);
		int v1,v2;
		System.out.println("Posicao Inicial - Linha: ");
		ler = new Scanner(System.in);
		v1 = ler.nextInt();
		System.out.println("Posicao Inicial - Coluna: ");
		ler = new Scanner(System.in);
		v2 = ler.nextInt();
		PasseioDoCavalo.TourCavalo(v1+2, v2+2, 2);
		}//fim PasseioCavalo()

}
