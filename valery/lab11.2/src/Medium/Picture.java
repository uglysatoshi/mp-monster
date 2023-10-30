package Medium;

import java.util.Scanner;

public class Picture extends Coordinate{
    String lineColour;
    public Picture() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите цвет: ");
        lineColour = in.nextLine();
    }
    // функция отрисовки конверта
    public void write() {
        // исходя из координат находим длинну и ширину
        int length = x2 - x1;
        int height = y3 - y1;
        int padding = 0;
        for(int i = 0; i < height; i++) {
            // если мы в первой или последней строке
            if(i == 0 || i + 1 == height) {
                for (int k = 0; k < length; k++) {
                    System.out.print("*");
                }

                System.out.println();
            }
            else {
                // исходя из увеличивающейся переменной padding
                // вписываем треугольник
                System.out.print("*");
                if(i + 2 == height) {
                    for (int j = 0; j < padding + 1; j++) {
                        System.out.print(" ");
                    }
                    System.out.print("*");
                    for (int j = 0; j < padding + 1; j++) {
                        System.out.print(" ");
                    }
                }
                else {
                    for (int j = 0; j < padding; j++) {
                        System.out.print(" ");
                    }
                    System.out.print("*");
                    for (int j = padding; j < Math.abs(length - padding - 4); j++) {
                        System.out.print(" ");
                    }
                    System.out.print("*");
                    for (int j = 0; j < padding; j++) {
                        System.out.print(" ");
                    }
                }
                System.out.print("*");
                System.out.println();
                padding++;
            }
        }
    }
    // нахождение размера вписанного треугольника
    public void areaOfTriangle() {
        int length = x2 - x1;
        int height = y3 - y1;
        System.out.println("Площадь вписанного треугольника: " + (int) (0.5 * length * height));
    }
}
