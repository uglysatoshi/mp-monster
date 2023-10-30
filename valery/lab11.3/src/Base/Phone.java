package Base;

import java.util.Scanner;
// класс предок
public class Phone {
    // поля класса
    String brand;
    int price;
    int memory;
    double Q;
    // функция нахождения значения Q
    private double calculateQ() {

        return (double) memory / price;
    }
    // конструктор
    public Phone() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите марку телефона: "); this.brand = in.nextLine();
        System.out.print("Введите цену (в долларах): "); this.price = in.nextInt();
        System.out.print("Введите количество памяти: "); this.memory = in.nextInt();
        this.Q = calculateQ();
    }
    // вывод конструкции
    public void show() {
        System.out.println("Марка: " + brand);
        System.out.println("Цена: " + price + "$");
        System.out.println("Объем памяти: " + memory);
        System.out.println("Q: " + String.format("%3.2f", Q));
    }
}
