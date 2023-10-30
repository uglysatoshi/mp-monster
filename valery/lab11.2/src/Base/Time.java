package Base;

import java.util.Scanner;
// класс предок с полями для хранения времени
public class Time {
    int hours;
    int minutes;
    int seconds;
    Time() {
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Введите количество часов: ");
            this.hours = in.nextInt();
        } while (this.hours < 0);
        do {
            System.out.print("Введите количество минут: ");
            this.minutes = in.nextInt();
        } while (this.minutes < 0);
        do {
            System.out.print("Введите количество секунд: ");
            this.seconds = in.nextInt();
        } while (this.seconds < 0);
    }
    void show() {
        System.out.println(hours + ":" + minutes + ":" + seconds);
    }
}
