/*Написать метод который найдет минимальный элемент матрицы.
 */

public class HomeWork0903 {
    public static void main(String[] args) {
        int row = 3;
        int column = 4;
        int[][] matrix = new int[row][column];
        HomeWork0901.setMatrixRandom(matrix);
        HomeWork0901.printMatrix(matrix);
        System.out.printf("Минимальный элемент массива - %s", minElementMatrix(matrix));


    }

    private static int minElementMatrix(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] aMatrix : matrix) {
            for (int value : aMatrix) {
                if (value < min) {
                    min = value;
                }
            }
        }
        return min;
    }
}



