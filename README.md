# HellTriangleChallengeSolver

This project is the implementation of the technical challenge called "Hell Triangle's Challenge".
I decided to implement it in Java 8 because it is the language I'm most familiar with 
so I may implement it quicker. Depending on the size of the triangles to be read, 
it may be necessary to use a more efficient language when dealing with arrays.

If you want to compile the class as a jar library to be imported on any other project, you may use the following command lines (from the project's root folder): 

	# javac -d bin src/com/b2wdigital/helltrianglechallenge/HellTriangleChallengeSolver.java

	# jar cf bin/HellTriangleChallengeSolver.jar .

The project is composed by a few files:

- README.md 
  This file;

- HellTriangleChallengeSolver.java
  Is the class that implmenets the logic to solve the challenge;

- HellTriangleChallengeSolverTestCase.java
  Is the test caste which tests the sum and the path used to solve the challenge.
 
 In order to use the HellTriangleChallengeSolver, you have to instantiate a HellTriangleChallengeSolver object, 
 passing the triangle to be evaluated as a multidimensional array as in the example below:
 
		# long[][] triangle = {{6}, {3,5}, {9,7,1}, {4,6,8,4}}; 
		# HellTriangleChallengeSolver solver = new HellTriangleChallengeSolver(triangle);
 	
 And then call the solveTriangle() method as in the example below:
 
		# long result = solver.solveTriangle();
 	
 