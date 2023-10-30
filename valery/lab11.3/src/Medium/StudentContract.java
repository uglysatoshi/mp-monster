package Medium;

import java.util.Scanner;
// класс наследник (студент-контрактник)
public class StudentContract extends Student{
    // дополнительное поле
    boolean payment;
    // конструктор
    public StudentContract() {
        Scanner in = new Scanner(System.in);
        System.out.print("Оплата за обучение была произведена?(Y/N): ");
        char answer = in.next().charAt(0);
        payment = answer == 'Y' || answer == 'y';
        System.out.println();
    }
    // степендия всегда равна нулю
    public int stipendCalculation() {
        return 0;
    }
    // перевод на следующий курс
    public void courseIncrease() {
        System.out.println("Проверка студента...");
        if(minGrade >= 3 && payment) {
            if(course + 1 > 4) {
                System.out.println("Студент " + name + " выпушен!");
            }
            else {
                course++;
                System.out.println("Студент " + name + " переведен на следующий курс!");
            }
        }
        else {
            System.out.println("У " + name + " имеются оценки ниже чем 3 или не оплачен контракт, студент не переведен");
        }
        System.out.println();
    }
}
