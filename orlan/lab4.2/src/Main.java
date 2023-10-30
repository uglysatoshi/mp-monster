import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Объявляем и заполняем n, m
        System.out.print("Введите числа n, m: ");
        int n = scan.nextInt();
        int m = scan.nextInt();
        // Объявляем массив разером n на m
        int[][] arr = new int[n][m];
        // Заполняем матрицу
        System.out.print("Заполните матрицу: \n");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = scan.nextInt();
            }
        }
        // Проходим по массиву и считаем количество семерок
        int counter = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
               if(arr[i][j] == 7) counter++;
            }
        }
        // Выводим результат
        System.out.printf("Число 7 встречается в массиве %d раз\n\n", counter);
    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        // Объявляем матрицу
        double[][] A = new double[5][10];
        // Заполняем матрицу
        System.out.print("Заполните матрицу: \n");
        for(int i = 0; i < 5; i++) {
            for(int j =0; j < 10; j++) {
                A[i][j] = scan.nextDouble();
            }
        }
        // Находим максимальный элемент
        double max = Integer.MIN_VALUE;
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 10; j++) {
                if(Math.abs(A[i][j]) > max) {
                    max = A[i][j];
                }
            }
        }
        // Объявляем массив и заполняем его
        double[][] B = new double[5][10];
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 10; j++) {
                B[i][j] = A[i][j] / max;
            }
        }
        // Выводим массив после обработки
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 10; j++) {
                System.out.printf("%.2f ", B[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("\n\n");
    }
    public static void Hard() {
        Scanner scan = new Scanner(System.in);
        // Объявляем и заполняем n, m
        System.out.print("Введите числа n, m: ");
        int n = scan.nextInt();
        int m = scan.nextInt();
        // Объявляем матрицу
        int[][] matrix = new int[m][n];
        // Заполняем матрицу
        System.out.print("Заполните матрицу: \n");
        for(int i = 0; i < n; i++) {
            for(int j =0; j < m; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxElement = 0;
        boolean ascending = false;
        boolean descending = false;

        for (int j = 0; j < cols; j++) {
            boolean isAscending = true;
            boolean isDescending = true;

            for (int i = 1; i < rows; i++) {
                // Проверка возрастает колонна или убывает
                if (matrix[i][j] > matrix[i - 1][j]) {
                    isDescending = false;
                } else if (matrix[i][j] < matrix[i - 1][j]) {
                    isAscending = false;
                }
            }
            // Если возрастает
            if (isAscending) {
                if (!ascending && !descending) {
                    maxElement = matrix[0][j];
                }
                ascending = true;
                descending = false;
                maxElement = Math.max(maxElement, matrix[rows - 1][j]);
            // Если убывает
            } else if (isDescending) {
                if (!ascending && !descending) {
                    maxElement = matrix[rows - 1][j];
                }
                ascending = false;
                descending = true;
                maxElement = Math.max(maxElement, matrix[0][j]);
            // Если не возрастает и не убывает
            } else {
                ascending = false;
                descending = false;
                maxElement = 0;
                break;
            }
        }

        System.out.printf("Максимальный элемент среди упорядоченных столбцов: %d", maxElement);
    }
    public static void main(String[] args) {
        Base();
        Medium();
//        Hard();
    }
}