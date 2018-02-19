package com.b2wdigital.helltrianglechallenge;

import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Test;

public class HellTriangleChallengeSolverTestCase {
	
	private long[] TEST_SUM_RESULT = {26,18,1064};
	private long[][] TEST_SEQUENCE_RESULT = {{6,5,7,8}, 
										   {6,-3,9,6}, 
										   {75,95,47,87,82,75,73,28,83,47,43,73,91,67,98}};
	private long[][][] INPUT = {
							   //first triangle
							   {{6},
							    {3,5}, 
							    {9,7,1}, 
							    {4,6,8,4}}, 
							   //second triangle
							   {{6},{-3,-5}, 
							    	{9,-7,1}, 
							    	{4,6,8,4}},
							   //third triangle
							   {{75}, 
							     {95,64}, 
							     {17,47,82}, 
							     {18,35,87,10}, 
							     {20,4,82,47,65},
							     {19,1,23,75,3,34},
							     {88,2,77,73,7,63,67},
							     {99,65,4,28,6,16,70,92},
							     {41,41,26,56,83,40,80,70,33},
							     {41,48,72,33,47,32,37,16,94,29},
							     {53,71,44,65,25,43,91,52,97,51,14},
							     {70,11,33,28,77,73,17,78,39,68,17,57},
							     {91,71,52,38,17,14,91,43,58,50,27,29,48},
							     {63,66,4,68,89,53,67,30,73,16,69,87,40,31},
							     {04,62,98,27,23,9,70,98,73,93,38,53,60,04,23}}
							    };

	@Test
	public void testSequence() {
		HellTriangleChallengeSolver triangleSolver;
		long[] result = null;
		
		for (int i = 0; i < INPUT.length; i++) { 
			triangleSolver = new HellTriangleChallengeSolver(INPUT[i]);
			result = triangleSolver.getSequenceToAdd();
			
			if (result == null) {
				fail("Error while calculating triangle. sorry");
			} else if (!Arrays.equals(result, TEST_SEQUENCE_RESULT[i])) {
				fail("The result " + Arrays.toString(result) +  " is not correct. It should be " + Arrays.toString(TEST_SEQUENCE_RESULT[i]) + ".");
			}
		}
	}
	
	@Test
	public void testSum() {
		HellTriangleChallengeSolver triangleSolver;
		long result;
		
		for (int i = 0; i < INPUT.length; i++) {
			triangleSolver = new HellTriangleChallengeSolver(INPUT[i]);
			result = triangleSolver.solveTriangle();
			
			if (result == -1) {
				fail("Error while calculating triangle. sorry");
			} else if (result != TEST_SUM_RESULT[i]) {
				fail("The result " + result +  " is not correct. It should be " + TEST_SUM_RESULT[i] + ".");
			}
		}
	}

}
