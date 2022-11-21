# Gauss-Jordan elimination method

Java written program that find the inverse matrix using Gauss-Jordan elimination (works for matricies of at least degree 6).

## Input specification
In the first line of standard input user enters the degree $n$ of the matrix we're going to invert.
Then, in the next $n$ rows we insert $n$ values forming a square matrix.

## Output specification
The program simulates the inverse matrix by Gauss-Jordan elimination and returns the inverse (if possible).

## Example

$$\begin{bmatrix} 
	3 & 0 & 2 \\
	2 & 0 & -2 \\
	0 & 1 & 1 \\
	\end{bmatrix}$$
  
  ### Input
  3 </br>
  3 0 2 </br>
  2 0 -2 </br>
  0 1 1 </br>
  
  ### Output
  [0,2 0,2 0,0] </br>
  [-0,2 0,3 1] </br>
  [0,2 -0,3 0,0] </br>
