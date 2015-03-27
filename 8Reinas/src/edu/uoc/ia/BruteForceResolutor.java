package edu.uoc.ia;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BruteForceResolutor {

	/**
	 * Cada posición de la lista representa una fila del tablero
	 * Cada valor de la lista, representa una columna
	 */
	private static List<Integer> generator = Arrays.asList(4,3,7,6,5,2,1,0);
	private static int numTestedCombinations = 0;
	private static long elapsedMiliseconds = 0;
	
	private static boolean correctPositions(List<Integer> positions){
		
		for(int i=positions.size()-1; i>=1; i--) {
			
			for(int j=i-1; j>=0; j--){
				
				if(positions.get(i)-positions.get(j) == i-j ||
				   positions.get(j)-positions.get(i) == i-j){
					
					return false;
				}
			}
		}

		return true;
	}
	
	private static void printSolution(List<Integer> positions){
	
		System.out.println("   1   2   3   4   5   6   7   8 ");
		System.out.println(" +---+---+---+---+---+---+---+---+");
		
		for(int i=0; i<positions.size(); i++){
			
			System.out.print((i+1)+"|");
			
			for(int j=0; j<positions.size(); j++){
				
				System.out.print(positions.get(i) == j ? " x |" : "   |");
			}
			System.out.println("");
			System.out.println(" +---+---+---+---+---+---+---+---+");
		}
		
		System.out.println("Number of tested combinations: "+numTestedCombinations);
		System.out.println("Elapsed time : "+elapsedMiliseconds);
	}
	
	public static void findNSolutions(int numSolutions){
		
		List<Integer> solution = null;
		long t1 = System.currentTimeMillis();
		
		do {
			
			Collections.shuffle(generator);
			solution = generator;
			numTestedCombinations++;
			
			if (correctPositions(solution)) {
				
				numSolutions--;
			}
			
		} while(numSolutions>0);
		
		elapsedMiliseconds = System.currentTimeMillis() - t1;
		
		//Print last found solution
		printSolution(solution);
	}

	
	public static void main(String[] args) {
		
		BruteForceResolutor.findNSolutions(10000);
	}
}
