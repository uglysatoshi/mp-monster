package Medium;

import java.util.Scanner;

public class Coordinate {
    int x1, x2, x3, x4;
    int y1, y2, y3, y4;

    public Coordinate() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите значение x1: "); x1 = in.nextInt();
        System.out.print("Введите значение y1: "); y1 = in.nextInt();
        System.out.print("Введите значение x2: "); x2 = in.nextInt();
        System.out.print("Введите значение y2: "); y2 = in.nextInt();
        System.out.print("Введите значение x3: "); x3 = in.nextInt();
        System.out.print("Введите значение y3: "); y3 = in.nextInt();
        System.out.print("Введите значение x4: "); x4 = in.nextInt();
        System.out.print("Введите значение y4: "); y4 = in.nextInt();
    }
}
