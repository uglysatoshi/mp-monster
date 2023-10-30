import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        int[][] matrix = new int[5][8];
        System.out.print("Заполните матрицу: \n");
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 8; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        // Находим индекс минимального элемента
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 8; j++) {
                if(min > matrix[i][j]) {
                    minIndex = j;
                    min = matrix[i][j];
                }
            }
        }
        // Объявляем новый массив и вносим в него значения столбца с минимальным элементом
        int[] result = new int[5];
        for(int i = 0; i < 5; i++) {
            result[i] = matrix[i][minIndex];
        }
        // Выводим результат
        System.out.printf("Столбец матрицы с минимальным элементом: %s\n\n", Arrays.toString(result));
    }
    public static void Medium() {
        // Объявляем матрицу
        double[][] matrix = new double[4][6];
        // Заполняем матрицу по формуле из задания
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 6; j++) {
                matrix[i][j] = Math.pow((Math.pow(Math.sin(i), 3) - Math.cos(j)), 3) + 7.4 * Math.log(Math.abs(((i - 5)/ (3 + j)) + 1));
            }
        }
        // Находим минимальную сумму и индекс столбца с минимальной суммой
        double min = Double.MAX_VALUE;
        int minIndex = 0;
        for(int j = 0; j < 6; j++) {
            double sum = 0;
            for(int i = 0; i < 4; i++) {
                sum += Math.abs(matrix[i][j]);
            }
            if(min > sum) {
                min = sum;
                minIndex = j;
            }
        }
        // Заносим столбец в массив result и находим сумму квадратов отрицательных чисел
        double[] result = new double[4];
        double sum = 0;
        for(int i = 0; i < 4; i++) {
            result[i] = matrix[i][minIndex];
            if(result[i] < 0) {
                sum += Math.pow(result[i], 2);
            }
        }
        // Выводим результаты
        System.out.printf("Вектор: %s\nСумма квадратов отрицательных чисел вектора: %.4f\n", Arrays.toString(result), sum);

    }
    public static void main(String[] args) {
//        Base();
        Medium();
    }
}