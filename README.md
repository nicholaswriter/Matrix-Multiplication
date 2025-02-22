This program reads command line arguments, and chooses what to do based on that. 

If there is two arguments (meaning there are two text files added), it will read both files and convert them to 2D matrices. It will then perform matrix multiplication, and save that new matrix as a text file. 

If there is one command line argument, it will first check to see if it's a integer. If yes, it will create a random matrix with the row and column length of whatever value the integer is. From there it will perform matrix multiplication with these random numbers. 

Lower down are multiple functions I called in the main function in order to help reduce repetitive lines of code. This includes changing a matrix to a text file, changing a text file to a matrix, and performing matrix multiplication. 

If there are any problems, such as no inputs, more than 2 inputs, one input but it's not an integer, etc it will print an error message to the user. 