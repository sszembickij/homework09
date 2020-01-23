/*Написать метод который повернет матрицу
на 90 градусов. Например:
1,2,3
4,5,6
результат:
4,1
5,2
6,3
*/

public class HomeWork0905 {
    public static void main(String[] args) {
        int row = 3;
        int column = 4;
        int[][] matrix = new int[row][column];
        HomeWork0901.setMatrixRandom(matrix);
        HomeWork0901.printMatrix(matrix);

        int[][] transMatrix = transpositionMatrix(matrix);
        HomeWork0901.printMatrix(transMatrix);

    }

    private static int[][] transpositionMatrix(int[][] matrix) {
        int[][] resultMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                resultMatrix[matrix[i].length - j - 1][i] = matrix[i][j];
            }
        }
        return resultMatrix;
    }
}
