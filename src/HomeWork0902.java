/*Написать метод который принимает 2 матрицы одного
размера и вернет сумму 2 матриц - каждый элемент будет
суммой соотв. элементов матриц параметров.
Написать 2 метода, которым передают матрицу и индексы a, b
    Первый метод должен поменять 2 строки матрицы местами
    второй 2 столбца
*/

public class HomeWork0902 {

    public static void main(String[] args) {

        int row = 3;
        int column = 4;
        int a = 0;
        int b = 2;

        int[][] matrix1 = new int[row][column];
        int[][] matrix2 = new int[row][column];

        HomeWork0901.setMatrixRandom(matrix1);
        HomeWork0901.setMatrixRandom(matrix2);
        HomeWork0901.printMatrix(matrix1);
        System.out.println("---------------");
        HomeWork0901.printMatrix(matrix2);
        System.out.println("---------------");

        int[][] matrix3 = summingElementsMatrix(matrix1, matrix2);
        HomeWork0901.printMatrix(matrix3);
        System.out.println("===============");

        HomeWork0901.printMatrix(matrix1);
        System.out.println("---------------");
        exchangeColumn(matrix1, a, b);
        HomeWork0901.printMatrix(matrix1);
        System.out.println("===============");
        exchangeRow(matrix1, a, b);
        HomeWork0901.printMatrix(matrix1);
    }

    /**
     * @sum the elements of two matrices into a
     * single matrix matrix according to indices
     */
    private static int[][] summingElementsMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] matrixResult = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                matrixResult[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return matrixResult;
    }

    private static void exchangeColumn(int[][] matrix, int param1, int param2) {
        int tmp;
        for (int i = 0; i < matrix.length; i++) {
            tmp = matrix[i][param1];
            matrix[i][param1] = matrix[i][param2];
            matrix[i][param2] = tmp;
        }
    }
    private static void exchangeRow(int[][] matrix, int param1, int param2) {
        int tmp;
        for (int i = 0; i < matrix[0].length; i++) {
            tmp = matrix[param1][i];
            matrix[param1][i] = matrix[param2][i];
            matrix[param2][i] = tmp;
        }
    }
}