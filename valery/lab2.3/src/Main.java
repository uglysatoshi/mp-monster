import java.util.Scanner;

public class Main {
    public static void Base(double A, double B, double C) {
        // если выполянется условие A + B + C > 0, иначе обнуляем
        if (A + B + C > 0) {
            A = A*2;
            B = B*2;
            C = C*2;
        }
        else {
            A = 0;
            B = 0;
            C = 0;
        }
        System.out.println("A = " + A);
        System.out.println("B = " + B);
        System.out.println("C = " + C);
    }
    public static void Medium(double x, double a, double b, double z) {

        // Задаем систему уравнений
        double[][] matrix = {{2.8 * Math.pow(Math.sin(Math.toDegrees(a * x)), 2), -b * Math.pow(x, 3), 0},
                             {0, z * Math.pow(Math.cos(Math.toDegrees(a * x + b)), 2) + 1, z},
                             {2.5 * a * Math.exp(2.5 * a * x), z * b * x, 1}};

        // задаем константы системы уравнений
        // вариацию того, что z может быть меньне нуля мы не рассматриваем, так как
        // все вариации z это натуральный логарифм от значения под модулем
        double[] constants = {0, Math.log(z), 0};

        // функция вычисления системы уравнений методом Гаусса -
        // - передаем в нее нашу матрицу и константы
        double[] results = solveLinearSystem(matrix, constants);

        // выводим получивышиеся значения
        double scale = Math.pow(10, 3);
        System.out.println("y1 = " + Math.ceil(results[0] * scale) / scale);
        System.out.println("y2 = " + Math.ceil(results[1] * scale) / scale);
        System.out.println("y3 = " + Math.ceil(results[2] * scale) / scale);
    }

    public static double[] solveLinearSystem(double[][] matrix, double[] constants) {
        int n = matrix.length; // n равен размерности матрицы
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) { // если счетчики не попадают в одно и тоже значение
                    // коэффициент будет равен элементу от [j][i] деленному на элемент от [i][i]
                    double coef = matrix[j][i] / matrix[i][i];
                    for (int k = 0; k < n; k++) {
                        // отнимаем значение коэффициента умноженного на значение столбца по всей строке
                        matrix[j][k] -= coef * matrix[i][k];
                    }
                    // отнимаем от констант по j коэффициент умноженный на константы по i
                    constants[j] -= coef * constants[i];
                }
            }
        }

        double[] results = new double[n]; // создаем массив размером n
        for (int i = 0; i < n; i++) {
            results[i] = constants[i] / matrix[i][i]; // делим константы на элементы главной диагонали
        }

        return results;
    }
    public static void Hard() {
        Scanner in = new Scanner(System.in);

        // варианты значений для игры
        int[] var1 = {6, 7, 8};
        int[] var2 = {7,8,9};
        int[] var3 = {6, 9, 10};
        int[] var4 = {6, 9, 8};
        int[] var5 = {7, 6, 10};
        // объявление массива игрока
        int[] playerValues = new int[3];

        // меню для пользователя
        System.out.println("Варианты значений");
        System.out.println("1. '6', '7', '8'");
        System.out.println("2. '7', '8', '9'");
        System.out.println("3. '6', '9', '10'");
        System.out.println("4. '6', '9', '8'");
        System.out.println("5. '7', '6', '10'");
        System.out.print("Введите цифру варианта, который ходите выбрать: "); int variable = in.nextInt();

        // исходя из выбранного пользователем варианты присваиваем значения
        if (variable == 1) playerValues = var1;
        if (variable == 2) playerValues = var2;
        if (variable == 3) playerValues = var3;
        if (variable == 4) playerValues = var4;
        if (variable == 5) playerValues = var5;

        // псевдослучаный ввод значений для компьютера
        int[] computerValues = new int[3];
        for(int i = 0; i < 3; i++) {
            computerValues[i] = (int) (Math.random() * (10 - 6 + 1) + 6);

        }

        // суммирование очков игрока и компьютера
        int playerResult = 0;
        int computerResult = 0;
        for (int i = 0; i < 3; i++) {
            playerResult = playerValues[i] + playerResult;
            computerResult = computerValues[i] + computerResult;
        }

        // условия для обозначения победителя и проигравшего
        if (playerResult > computerResult) {
            System.out.println("Вы выиграли");
        }
        else {
            if (playerResult == computerResult) {
                System.out.println("Ничья");
            }
            else {
                System.out.println("Вы проиграли");
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Базовыый уровень");
        System.out.println("Вариация 1");
        Base(3.0, 3.5,0.1);
        System.out.println("Вариация 2");
        Base(58.0, 27.0, -87.0);
        System.out.println("Вариация 3");
        Base(-8.0, -35.0, 42.0);
        System.out.println("Средний уровень");
        System.out.println("Вариация 1");

        System.out.print("Введите значение x: "); double x = in.nextDouble();
        double a = -5.0;
        double b = 2.5;
        double z = Math.log(Math.abs(b * Math.pow(x, 3)));
        Medium(x, a, b, z);
        System.out.println("Вариация 2");
        System.out.print("Введите значение x: "); x = in.nextDouble();
        a = 3.0;
        b = 5.0;
        z = Math.log(Math.abs(b * x));
        Medium(x, a, b, z);
        System.out.println("Вариация 3");
        System.out.print("Введите значение x: "); x = in.nextDouble();
        a = -10;
        b = 3.0;
        z = Math.log(Math.abs(b * Math.pow(x, 2)));
        Medium(x, a, b, z);

        Hard();
    }
}