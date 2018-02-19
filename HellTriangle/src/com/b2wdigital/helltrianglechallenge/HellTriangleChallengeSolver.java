package com.b2wdigital.helltrianglechallenge;

import java.util.logging.Logger;
import java.util.stream.LongStream;


/**
 * This class implements the Hell Triangle's Challenge solver.
 * I receives a multidimensional array of integers and finds the maximum total from top to bottom,
 * where an element can only be summed with one of the two nearest elements in the next row.
 * 
 * @author Tiago Gondim
 * @since 2.19.2018
 * @version 1.0
 *
 */
public class HellTriangleChallengeSolver {

	Logger logger;
	private long[][] triangle;
	
	public HellTriangleChallengeSolver() {
	}
	
	public HellTriangleChallengeSolver(long[][] triangle) {
		this.setTriangle(triangle);
	}
	
	/**
	 * Sums the pathway found by getSequenceToAdd().
	 * 
	 * @return the sum for the pathway found by getSequenceToAdd(). Returns -1 if not possible to evaluate.
	 */
	public long solveTriangle() {
		getLogger().info("Calling HellTriangleChallengeSolver.solveTriangle()");
		
		long[] result = getSequenceToAdd();
		
		if (result == null) {
			return -1;
		}
		
		return LongStream.of(result).sum();
	}

	/**
	 * Find the correct pathway from top to bottom, 
	 * where the next element is the greater of the two nearest 
	 * elements in the next row.
	 * 
	 * @return the pathway to be used in the sum. Returns null if not possible to evaluate.
	 */
	protected long[] getSequenceToAdd() {
		getLogger().info("Calling HellTriangleChallengeSolver.getNumbersToAdd()");

		if (getTriangle() == null) {
			return null;
		}
		
		long[] result = null;
		
		try {
			result = new long[getTriangle().length];
			int col = 0;
			long[] numbersToCompare = new long[2];
			
			for (int row = 0; row < getTriangle().length; row++) {
					numbersToCompare[0] = getTriangle()[row][col];
					numbersToCompare[1] = (row == 0 ? 0 : getTriangle()[row][col+1]);
					
					if (numbersToCompare[0] >= numbersToCompare[1]) {
						result[row] = numbersToCompare[0];
					} else {
						result[row] = numbersToCompare[1];
						col++;
					}
			}
		} catch (Exception e) {
			getLogger().severe(e.getMessage());
			return null;
		}
		
		return result;
	}

	public long[][] getTriangle() {
		return triangle;
	}

	public void setTriangle(long[][] triangle) {
		this.triangle = triangle;
	}
	
	public Logger getLogger() {
		if (this.logger == null) {
			this.logger = Logger.getLogger(Class.class.getName());
		}
		
		return this.logger;
	}
	
	
}
