public class Main {
    public static double sum(double x) {
        double sum = 0.0;
        for(int i = 3; i <= 9; i++) {
            sum += Math.pow(x, -i);
        }
        return sum;
    }
    public static void Base() {
        System.out.println("\nПостроение графика уравнения y = x^2 +2π*cos(πx)\n");
        // Область исследования и шаг
        double start = -5;
        double end = 3;
        double step = 0.07;

        // Рисуем график
        for (double y = 3; y >= 1.80; y -= 0.04) { // Область исследования и шаг по y
            System.out.print(String.format("%5.2f", y) + "|");
            for (double x = start; x <= end; x += step) { // исследование по x
                double y1 = Math.pow(x, 2) + 2 * Math.PI * Math.cos(Math.toDegrees(Math.PI * x));
                if (Math.abs(y - y1) < 0.03) { // калибровка точности
                    System.out.print("@");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
        // вывод значений в консоль
        System.out.println("\nТабуляция уравнения y = x^2 +2π*cos(πx)\n");
        double x = -2;
        while (x <= 1) {
            System.out.println("x= " + String.format("%5.2f", x) + " y= " + String.format("%5.2f", Math.pow(x, 2) + 2 * Math.PI * Math.cos(Math.PI * x)));
            x += 0.5;
        }
        System.out.println();
    }
    public static void Medium() {
        System.out.println("\nПостроение графика системы линейных уравнений \n    { 2x \ny = { 1-ln(|1+x^2|) \n    { e^-x\n");

        // Область исследования и шаг
        double start = -2;
        double end = 3;
        double step = 0.06;

        // Рисуем график
        for (double y = 5; y >= 0; y -= 0.05) { // Область исследования и шаг по y
            System.out.print(String.format("%5.2f", y) + "|");

            for (double x = start; x <= end; x += step) { // исследование по x
                double y1 = (x > 2) ? 2*x : Double.NaN;
                double y2 = (x >= 0 && x <= 2) ? 1-Math.log10(Math.abs(1+Math.pow(x,2))) : Double.NaN;
                double y3 = (x < 0) ? Math.pow(Math.E, -1*x) : Double.NaN;
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

        // вывод значений СЛУ в консоль
        System.out.println("\nТабуляция системы линейных уравнений \n    { 2x \ny = { 1-ln(|1+x^2|) \n    { e^-x\n");
        double x = -1 * Math.PI/2;
        while (x <= Math.PI) {
            if (x >= 0 && x <= 2) {
                double y = 1-Math.log10(Math.abs(1+Math.pow(x,2)));
                System.out.println("x= " + String.format("%5.2f", x) + " y= " + String.format("%5.2f", y));
            }
            else {
                double y;
                if (x > 2) {
                    y = 2*x;
                }
                else {
                    y = Math.pow(Math.E, -1*x);
                }
                System.out.println("x= " + String.format("%5.2f", x) + " y= " + String.format("%5.2f", y));
            }
            x += 0.2;
        }
        System.out.println();
    }
    public static void Hard() {
        System.out.println("\nПостроение графика системы линейных уравнений \n    { Σ x^-k \nf(x) = { (2-x)^2-x\n");

        // Область исследования и шаг по x
        double start = -2;
        double end = 3;
        double step = 0.04;

        // Рисуем график
        for (double y = 6; y >= 0; y -=0.08) { // Область исследования и шаг по y
            System.out.print(String.format("%5.2f", y) + "|");

            for (double x = start; x <= end; x += step) { // исследование по x
                double y1 = (x > 0) ? sum(x) : Double.NaN;
                double y2 = (x <= 0) ? Math.pow(2-x, 2-x) : Double.NaN;
                if (Math.abs(y - y1) < 0.05) { // калибровка точности
                    System.out.print("*");
                } else if (Math.abs(y - y2) < 0.05) { // калибровка точности
                    System.out.print("+");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
        // вывод значений СЛУ в консоль
        System.out.println("\nТабуляция системы линейных уравнений \n    { Σ x^-k \nf(x) = { (2-x)^2-x\n");
        double x = -2;
        while (x <= 3) {
            if (x > 0) {
                System.out.println("x= " + String.format("%5.2f", x) + " y= " + String.format("%5.2f", sum(x)));
            }
            else {
                double y = Math.pow(2-x, 2-x);
                System.out.println("x= " + String.format("%5.2f", x) + " y= " + String.format("%5.2f", y));
            }
            x += 0.5;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}
