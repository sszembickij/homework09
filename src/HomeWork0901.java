import java.util.Arrays;
import java.util.Random;

/*написать 3 метода:
a) метод который печатает переданную в него матрицу
b) метод который заполняет случайными числами переданную
в него матрицу
c) метод в который передается матрица и число. Метод должен
умножить каждый элемент матрицы на число*/

public class HomeWork0901 {
    public static void main(String[] args) {

        Random random = new Random();
        int[][] matrix = new int[4][4];
        int multiplier = 10;

        setMatrixRandom(random, matrix);
        printMatrix(matrix);
        multiplicationMatrixNumber(matrix, multiplier);
        printMatrix(matrix);


    }

    private static void setMatrixRandom(Random random, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(100);
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] line : matrix) {
            System.out.println(Arrays.toString(line));
        }
    }

    private static void multiplicationMatrixNumber(int[][] matrix, int param) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] *= param;
            }
        }
    }
}
