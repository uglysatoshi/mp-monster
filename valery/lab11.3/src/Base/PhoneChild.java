package Base;

import java.util.Scanner;

public class PhoneChild extends Phone {
    // дополнительные поля в наследнике
    int sim;
    double Qp;
    // нахождение новой Q
    private double calculateQ() {
        return Q * sim;
    }
    // конструктор
    public PhoneChild() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество Sim-карт: "); this.sim = in.nextInt();
        this.Qp = calculateQ();
    }
    // наследованная функция вывода
    public void show() {
        System.out.println("Марка: " + brand);
        System.out.println("Цена: " + price + "$");
        System.out.println("Объем памяти: " + memory);
        System.out.println("Количество Sim-карт: " + sim);
        System.out.println("Q: " + String.format("%3.3f", Q));
        System.out.println("Qp: " + String.format("%3.3f", Qp));
    }
}
