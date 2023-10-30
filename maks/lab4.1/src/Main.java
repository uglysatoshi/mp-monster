import java.util.*;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Объявляем массив
        int[] arr = new int[17];
        // Заполняем массив
        System.out.print("Введите 17 целочисленных элементов массива: ");
        for(int i = 0; i < 17; i++) {
            arr[i] = scan.nextInt();
        }
        int negSum = 0;
        int cnt = 0;
        // Находим среднее арифметическое отрицательных чисел по модулю
        for(int i : arr) {
            if(i < 0) {
                cnt++;
                negSum += Math.abs(i);
            }
        }
        negSum /= cnt;
        // Находим абсолютную сумму
        int absSum = 0;
        for(int i : arr) {
            if(i > negSum) absSum += i;
        }
        // Выводим итоговое значение
        System.out.printf("Абсолютная сумма: %d\n\n", absSum);
    }
    private static void arrPrint(Double[] arr) {
        System.out.print("[ ");
        for(Double d : arr) {
            System.out.printf("%.2f ", d);
        }
        System.out.print("]\n");
    }
    private static void dPrint(ArrayList<Double> arr) {
        System.out.print("[ ");
        for(Double d : arr) {
            System.out.printf("%.2f ", d);
        }
        System.out.print("]\n");
    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        // Объявляем массивы
        Double[] X = new Double[17];
        Double[] Y = new Double[17];
        // Заполняем массив X
        System.out.print("Введите 17 вещественных чисел: ");
        for (int i = 0; i < 17; i++) {
            X[i] = scan.nextDouble();
        }
        // Исходя из задания заполняем массив Y
        for (int i = 0; i < 17; i++) {
            if (Math.cos(X[i]) > 0) {
                Y[i] = Math.pow(X[i], 3) - 7.5;
            } else {
                Y[i] = Math.pow(X[i], 2) - Math.pow(5 * Math.E, Math.sin(X[i]));
            }
        }
        // Проводим сортировку исходя из задания
        Arrays.sort(Y);
        Arrays.sort(X, Collections.reverseOrder());
        // Объявляем массив и заполняем его исходя из задания
        ArrayList<Double> R = new ArrayList<>();
        for (int i = 0; i < 17; i++) {
            if(i % 2 == 0) {
                R.add(X[i]);
                R.add(Y[i]);
            }
        }
        // Выводим в консоль
        System.out.print("Массив X: ");
        arrPrint(X);
        System.out.print("Массив Y: ");
        arrPrint(Y);
        System.out.print("Массив R: ");
        dPrint(R);
        System.out.print("\n\n");
    }
    public static void Hard() {
        Scanner scan = new Scanner(System.in);
        // Объявляем массивы
        Double[] A = new Double[7];
        Double[] B = new Double[9];
        // Заполняем массивы
        System.out.print("Введите 7 вещественных чисел: ");
        for(int i = 0; i < 7; i++) {
            A[i] = scan.nextDouble();
        }
        System.out.print("Введите 9 вещественных чисел: ");
        for(int i = 0; i < 9; i++) {
            B[i] = scan.nextDouble();
        }
        // Объявляем динамический массив
        ArrayList<Double> C = new ArrayList<>();
        // Переносим в С все значения из двух массивов
        C.addAll(Arrays.asList(A));
        C.addAll(Arrays.asList(B));
        // Сортируем массив по убыванию
        C.sort(Comparator.reverseOrder());
        // Выводим массив
        System.out.printf("Итоговый массив: %s", C);
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}