import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class Train {
    // поля класса
    String number;
    LocalTime fTime;
    LocalTime lTime;
    String destination;
    double distance;

    // функция вывода
    void show() {
        System.out.println("Номер поезда: " + number);
        System.out.println("Время отправления: " + fTime.toString());
        System.out.println("Время прибытия: " + lTime.toString());
        System.out.println("Направление: " + destination);
        System.out.println("Расстояние: " + distance);
        System.out.println("Средняя скорость поезда: " + speedAverage() + " км/ч");
        System.out.println();
    }
    // конструктор класса
    public Train() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите номер поезда: "); this.number = in.next();
        System.out.print("Введите время отправления(чч:мм:cc): "); this.fTime = LocalTime.parse(in.next());
        System.out.print("Введите время прибытия: "); this.lTime = LocalTime.parse(in.next());
        System.out.print("Введите направление: "); this.destination = in.next();
        System.out.print("Введите расстояние (в км): "); this.distance = in.nextDouble();
        System.out.println();
    }

    // функция нахождения средней скорости поезда
    double speedAverage() {
        // находим разницу между временем отправки и временем прибытия
        Duration tripDuration = Duration.between(fTime, lTime);
        // переводим значение в часы
        double hours = tripDuration.toHours();
        // выводим значение в км/ч
        return distance / hours;
    }

}
