public class Main {
    private static int factorial(int x) { // функция нахождения факториала
        if (x <= 0) {
            return -1;
        }
        for (int i = 1; i <= x; i++) {
            x *= i;
        }
        return x;
    }

    public static void Base() {
        // область исследования и шаг
        double start = 1.0;
        double end = 3.0;
        double step = 0.2;

        System.out.println("График функции y = x^3 + 4x^2 - 2");
        for (double y = 8.0; y >= 0.0; y --) { // Область исследования и шаг по y

            System.out.print(String.format("%5.2f", y) + "|");
            for (double x = start; x <= end; x += step) { //  исследование по x
                double f = Math.pow(x, 3) + 4 * Math.pow(x, 2) - 2; // функция
                int yScaled = (int) (f / 2);
                if (yScaled == y) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Тубуляция функции y = x^3 + 4x^2 - 2");
        double x = 1;
        double y;
        while (x <= 3) {
            y = Math.pow(x, 3) + 4 * Math.pow(x, 2) - 2;
            System.out.println("x= " + String.format("%5.2f", x) + " y= " + String.format("%5.2f", y));
            x += 0.2;
        }
        System.out.println();
    }

    public static void Medium() {
        System.out.println("\nПостроение графика системы линейных алгебраических уравнений \n    { ln|1 + x| \ny = { e^-x\n    { cos(x)\n");

        // Область исследования и шаг
        double start = -1;
        double end = 15;
        double step = 0.2;

        // Рисуем график
        for (double y = 3; y >= -1; y -= 0.08) { // Область исследования и шаг по y
            System.out.print(String.format("%5.2f", y) + "|");

            for (double x = start; x <= end; x += step) { // исследование по x
                double y1 = (x > 3.8) ? Math.log(Math.abs(1 + x)) : Double.NaN;
                double y2 = (x >= 2.8 && x <= 3.8) ? Math.pow(Math.E, -x) : Double.NaN;
                double y3 = (x < 2.8) ? Math.cos(x) : Double.NaN;
                if (Math.abs(y - y1) < 0.03) { // калибровка точности
                    System.out.print("*");
                } else if (Math.abs(y - y2) < 0.03) { // калибровка точности
                    System.out.print("+");
                } else if (Math.abs(y - y3) < 0.03) { // калибровка точности
                    System.out.print("@");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }

        // вывод значений СЛАУ в консол
        System.out.println("\nТабуляция системы линейных алгебраических уравнений \n    { ln|1 + x| \ny = { e^-x\n    { cos(x)\n");
        double x = -1;
        while (x <= 8) {
            if (x >= 2.8 && x <= 3.8) {
                double y = Math.pow(Math.E, -x);
                System.out.println("x= " + String.format("%5.2f", x) + " y= " + String.format("%5.2f", y));
            }
            else {
                double y;
                if (x > 3.8) {
                    y = Math.log(Math.abs(1 + x));
                }
                else {
                    y = Math.cos(x);
                }
                System.out.println("x= " + String.format("%5.2f", x) + " y= " + String.format("%5.2f", y));
            }
            x += 0.5;
        }
        System.out.println();
    }

    public static void Hard() {
        System.out.println("\nПостроение графика системы линейных алгебраических уравнений \nf(x) = { Σ (-1)^k * x^k / k! \n       {tg(π^x)\n");
        // Область исследования и шаг
        double start = -3.0;
        double end = 2.5;
        double step = 0.05;

        for (double y = 1.5; y >= -0.5; y -= 0.05  ) { // Область исследования и шаг по y
            System.out.print(String.format("%5.2f", y) + "|");

            for (double x = start; x <= end; x += step) { // исследование по x
                // вычисление алгебраической суммы
                double sumFunc = 0;
                for(int k = 1; k <= 8; k++) {
                    sumFunc += Math.pow(-1, k) * Math.pow(x, k) / factorial(k);
                }
                double y1 = (x > 0) ? sumFunc : Double.NaN;
                double y2 = (x <= 0) ? Math.tan((Math.pow(Math.PI, x))) : Double.NaN;
                if (Math.abs(y - y1) < 0.04) { // калибровка точности
                    System.out.print("*");
                } else if (Math.abs(y - y2) < 0.04) { // калибровка точности
                    System.out.print("@");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        // вывод значений СЛАУ в консоль
        System.out.println("\nТабуляция системы линейных алгебраических уравнений \nf(x) = { Σ (-1)^k * x^k / k! \n       {tg(π^x)\n");
        double x = -3;
        while (x <= 2.5) {
            if (x > 0) {
                double sumFunc = 0;
                for(int k = 1; k <= 8; k++) {
                    sumFunc += Math.pow(-1, k) * Math.pow(x, k) / factorial(k);
                }
                double y = sumFunc;
                System.out.println("x= " + String.format("%5.2f", x) + " y= " + String.format("%5.2f", y));
            }
            else {
                double y = Math.tan((Math.pow(Math.PI, x)));
                System.out.println("x= " + String.format("%5.2f", x) + " y= " + String.format("%5.2f", y));
            }
            x += 1.1;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}