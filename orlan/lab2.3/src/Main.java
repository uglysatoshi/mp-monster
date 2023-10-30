import java.util.Scanner;

public class Main {
    public static void Base(int a, int b, int c) {
        //  Объявляем массив и передаем в него значения a, b, c
        int[] arr = new int[3];
        int min = Integer.MAX_VALUE;
        arr[0] = a; arr[1] = b; arr[2] = c;
        // Находим минимальный элемент
        for (int j : arr) {
            if (j < min) {
                min = j;
            }
        }
        // Выводим минимальное число
        System.out.printf("Минимальное число: %d\n\n", min);
    }
    public static void Medium(double k, double m, double n) {

        double[] solutions = solveSystem(k, m, n);

        System.out.printf("Решенная система линейных уравнений:\ny1 = %.4f\ny2 = %.4f\ny3 = %.4f\n\n", solutions[0], solutions[1], solutions[2]);
    }

    static double[] solveSystem(double k, double m, double n) {
        double[][] coefficients = {
                {Math.log10(Math.abs(Math.log(Math.abs(k * 1 + m * n)))), 0, 0},
                {0, Math.sin(k * m * 1), Math.sqrt(Math.abs(n * 1))},
                {0, Math.pow(Math.E, Math.cos(1)), Math.pow(Math.E, m + n)}
        };

        double[] constants = {Math.abs(m +n), Math.abs(m + n), Math.abs(m +n)};


        // Прямой ход метода Гаусса
        for (int pivot = 0; pivot < constants.length; pivot++) {
            double pivotValue = coefficients[pivot][pivot];

            // Деление строки на ведущий элемент
            for (int col = pivot; col < constants.length; col++) {
                coefficients[pivot][col] /= pivotValue;
            }
            constants[pivot] /= pivotValue;

            // Вычитание текущей строки из остальных строк
            for (int row = 0; row < constants.length; row++) {
                if (row != pivot) {
                    double factor = coefficients[row][pivot];
                    for (int col = pivot; col < constants.length; col++) {
                        coefficients[row][col] -= factor * coefficients[pivot][col];
                    }
                    constants[row] -= factor * constants[pivot];
                }
            }
        }

        return constants;
    }
    public static void Hard() {
        Scanner scan = new Scanner(System.in);
        // Вводим код города
        System.out.print("Введите код нужного города\nОдесса - 048\nКиев - 044\nХарьков - 046\nВинница - 045\nВвод: ");
        int code = scan.nextInt();
        // Проверяем значение
        while(code > 48 || code < 44 || code == 47) {
            System.out.print("Введите значение из списка указанного выше: ");
            code = scan.nextInt();
        }
        //  Вводим длительность разговора
        System.out.print("Введите длительность разговора в минутах: ");
        int t = scan.nextInt();
        // Оператор выбора
        switch(code) {
            case 48 -> System.out.printf("Сумма: %d UAH", 15*Math.abs(t));
            case 44 -> System.out.printf("Сумма: %d UAH", 18*Math.abs(t));
            case 46 -> System.out.printf("Сумма: %d UAH", 13*Math.abs(t));
            case 45 -> System.out.printf("Сумма: %d UAH", 11*Math.abs(t));
        }
    }
    public static void main(String[] args) {
        System.out.print("Базовый уровень\nПервый вариант значений\n");
        Base(45, 13, -23);
        System.out.print("Второй вариант значений\n");
        Base(-31, 65, 12);
        System.out.print("Третий вариант значений\n");
        Base(52, -1, -33);
        System.out.print("Средний уровень\nПервый вариант значений");
        Medium(4, -14.7, -0.6);
        System.out.print("Второй вариант значений\n");
        Medium(3, 6.5, 3.15);
        System.out.print("Третий вариант значений\n");
        Medium(5, -12, -0.45);
        Hard();
    }
}