import java.util.Scanner;

public class Medium {
    int hours;
    int minutes;
    int seconds;
    Medium() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество часов: ");
        this.hours = in.nextInt();
        System.out.print("Введите количество минут: ");
        this.minutes = in.nextInt();
        System.out.print("Введите количество секунд: ");
        this.seconds = in.nextInt();
    }
    void show() {
        System.out.println(hours + ":" + minutes + ":" + seconds);
    }
}
