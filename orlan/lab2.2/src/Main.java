import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Вводим координаты точки
        System.out.print("Введите координаты точки: ");
        double x = scan.nextDouble();
        double y = scan.nextDouble();
        // III
        if(x < 0 && y < 0) {
            System.out.print("Точка попадает в III четверть\n\n");
        }
        // I
        if(x > 0 && y > 0){
            System.out.print("Точка попадает в I четверть\n\n");
        }
        // IV
        if (x > 0 && y < 0) {
            System.out.print("Точка попадает в IV четверть\n\n");
        }
        // II
        if (x < 0 && y > 0) {
            System.out.print("Точка попадает во II четверть\n\n");
        }
    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        // Объявляем и вводим координаты точек
        System.out.print("Введите координаты первой точки: ");
        double x1 = scan.nextDouble();
        double y1 = scan.nextDouble();
        System.out.print("Введите координаты второй точки: ");
        double x2 = scan.nextDouble();
        double y2 = scan.nextDouble();
        System.out.print("Введите координаты третьей точки: ");
        double x3 = scan.nextDouble();
        double y3 = scan.nextDouble();
        // По формуле проверяем лежат ли точки на одной прямой
        if((x3 - x1) / (x2 - x1) == (y3 - y1) / (y2 - y1)) {
            System.out.print("Точки лежат на одной прямой\n\n");
        } else {
            System.out.print("Точки не лежат на одной прямой\n\n");
        }
    }
    public static void Hard() {
        Scanner scan = new Scanner(System.in);
        // Вводим координаты точки
        System.out.print("Введите координаты точки: ");
        double x = scan.nextDouble();
        double y = scan.nextDouble();
        // Проверяем попадает ли точка в область из задания
        if(y <= 2 - Math.pow(x, 2) && y >= -2) {
            System.out.print("Точка попадает в область");
        } else {
            System.out.print("Точка не попадает в область");
        }
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}