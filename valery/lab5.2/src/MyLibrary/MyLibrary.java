package MyLibrary;

import java.util.Vector;

public class MyLibrary {
    public static int sumMainDiagonal(int n, int[][] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) { // условие попадения в главную диагональ
                    if (arr[i][j] < min) { // нахождение минимального
                        min = arr[i][j];
                    }
                    if(arr[i][j] > max) { // нахождение максимального
                        max = arr[i][j];
                    }
                }
            }
        }
        return max + min; // возвращаем сумму
    }

    public static Vector<Double> toMinMaxVector(int n, double[][] arr) {
        Vector<Double> vector = new Vector<>(2); // Объявляем вектор на 2 элемента
        double minMain = Double.MAX_VALUE;
        double minSide = Double.MAX_VALUE;
        // проход по главной диагонали
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) {
                    if(arr[i][j] < minMain) {
                        minMain = arr[i][j];
                    }
                }
            }
        }
        // проход по побочной диагонали
        for(int i = n-1; i >= 0; i-- ) {
            for (int j = n-1; j >= 0; j--) {
                if(i == j && arr[i][j] < minSide) {
                    minSide = arr[i][j];
                }
            }
        }
        // заносим значения в вектор
        vector.add(0, minMain);
        vector.add(1, minSide);
        return vector;
    }

    public static double vectorMultiply(Vector<Double> vector) {
        // если 1ый больше 2го, то возвращаем 1ый умноженный на его индекс, иначе возвращаем второй умноженный на его индекс
        return (vector.get(0) > vector.get(1)) ? vector.get(0) * 0 : vector.get(1) * 1;
    }
}
