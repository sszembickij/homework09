/*написать метод который преобразует матрицу в одномерный массив.
Например если матрица была 3x4 то массив будет на 12 элементов.*/

import java.util.Arrays;

public class HomeWork0904 {
    public static void main(String[] args) {
        int row = 3;
        int column = 4;
        int[][] matrix = new int[row][column];
        HomeWork0901.setMatrixRandom(matrix);
        HomeWork0901.printMatrix(matrix);

        int[] array = toArray(matrix);
        System.out.println(Arrays.toString(array));


    }

    private static int[] toArray(int[][] matrix) {
        int[] array = new int[matrix.length * matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, array, i * matrix[i].length, matrix[i].length);
        }
        return array;
    }
}
