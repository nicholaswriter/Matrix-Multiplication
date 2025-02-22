import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;

public class App {
    public static int input = 0;
    public static void main(String[] args) {
        if (args.length == 2) {
            try {
                int[][] matrix1 = readMatrixFromFile(args[0]);
                int[][] matrix2 = readMatrixFromFile(args[1]);
                input = matrix1.length;
                int[][] matrix3 = MatrixMultiplication(matrix1,matrix2);

                saveMatrixToFile(matrix3, "m3test.txt");

            } catch (Exception e) {
                System.out.println("Invalid input: please input an integer or two valid file names.");
            }
        } else if (args.length == 1) {
            try {
                input = Integer.parseInt(args[0]);
                int [][] matrix1 = new int[input][input];
                int [][] matrix2 = new int[input][input];
                Random rand = new Random();

                for (int i = 0; i < input; i++) {
                    for (int j = 0; j < input; j++) {
                        matrix1[i][j] = rand.nextInt(10);
                        matrix2[i][j] = rand.nextInt(10);
                    }
                }
                saveMatrixToFile(matrix1, "matrix1.txt");
                saveMatrixToFile(matrix2, "matrix2.txt");
                System.out.println("matrix1.txt saved");
                System.out.println("matrix2.txt saved");

                int[][] matrix3 = MatrixMultiplication(matrix1, matrix2);
                saveMatrixToFile(matrix3, "matrix3.txt");
                System.out.println("matrix3.txt saved: Matrix Multiplication");

            } catch (Exception e) {
                System.out.println("Invalid input: please input an integer or two valid file names.");
            }
        } else {
            System.out.println("Invalid input: please input an integer or two valid file names.");
        }
    }

    public static int[][] readMatrixFromFile(String file) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(file));
        int[][] matrix = new int[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            String[] values = lines.get(i).trim().split("\\s+");
            matrix[i] = new int[values.length];
            for (int j = 0; j < values.length; j++) {
                matrix[i][j] = Integer.parseInt(values[j]);
            }
        }
        return matrix;
    }

    public static int[][] MatrixMultiplication(int[][] matrix1, int[][] matrix2) {
        int[][] matrix_mult = new int[input][input];
        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input; j++) {
                for (int k = 0; k < input; k++) {
                    matrix_mult[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return matrix_mult;
    }

    public static void saveMatrixToFile(int[][] matrix, String name) throws IOException{
        try (BufferedWriter filesave = new BufferedWriter(new FileWriter(name))) {
            for (int[] row : matrix) {
                for (int value : row) {
                    filesave.write(value + " ");
                }
                filesave.newLine();
            }
        }
    }
}