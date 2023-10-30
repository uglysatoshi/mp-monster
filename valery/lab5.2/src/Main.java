import MyLibrary.*;
public class Main {
    public static void Base() {
        int n = 6;
        int[][] arr = new int[n][n];

        // заполняем матрицу псевдослучайными значениями
        for (int i = 0; i < n; i++) {
            for (int  j = 0; j < n; j++) {
                arr[i][j] = (int) (Math.random() * (100 - 1) + 1);
            }
        }

        // выводим матрицу
        for (int i = 0; i < n; i++) {
            for (int  j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Сумма максимальных и минимальных элементов главной диагонали: " + MyLibrary.sumMainDiagonal(n, arr));
    }

    public static void Medium() {
        int n = 6;
        double[][] arr = new double[n][n];

        // заполняем массив значениями функции от i, j
        for (int i = 0; i < n; i++) {
            for (int  j = 0; j < n; j++) {
                arr[i][j] = Math.pow(Math.pow((2 + Math.E), i) / Math.pow(Math.E, 3+j), j) - Math.cos(Math.toDegrees(Math.pow(Math.E, Math.cos(Math.toDegrees(j)))));
            }
        }

        // выводим массив, сокращая до тысячных
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(String.format("%4.3f", arr[i][j]) + " ");
            }
            System.out.println();
        }

        System.out.println("Произведение максимального элемента вектора на его индекс: " + MyLibrary.vectorMultiply(MyLibrary.toMinMaxVector(n, arr)));
    }
    public static void main(String[] args) {
        Base();
        Medium();
    }
}