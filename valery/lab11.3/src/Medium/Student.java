package Medium;

import java.util.Scanner;

public class Student {
    // поля класса
    String name;
    String faculty;
    int course;
    int minGrade;
    int stipend;
    // конструктор
    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите ФИО: "); this.name = in.nextLine();
        System.out.print("Введите факультет: "); this.faculty = in.nextLine();
        System.out.print("Введите курс: "); this.course = in.nextInt();
        System.out.print("Введите минимальную оценку: "); this.minGrade = in.nextInt();
        this.stipend = stipendCalculation();
    }
    // функция перевода студента на другой курс
    public void courseIncrease() {
        System.out.println("Проверка студента...");
        if(minGrade >= 3) {
            if(course + 1 > 4) {
                System.out.println("Студент " + name + " выпущен!");
            }
            else {
                course++;
                System.out.println("Студент " + name + " переведен на следующий курс!");
            }
        }
        else {
            System.out.println("У " + name + " имеются оценки ниже чем 3, студент не переведен");
        }
        System.out.println();
    }
    // функция нахождения степендии
    public int stipendCalculation() {
        if(minGrade >= 3) {
            if(minGrade == 5) {
                return 300;
            }
            else {
                return 200;
            }
        }
        else {
            return 0;
        }
    }
    // вывод информации о студенте
    public void info() {
        System.out.println("ФИО: " + name);
        System.out.println("Факультет: " + faculty);
        System.out.println("Курс: " + course);
        System.out.println("Минимальная оценка: " + minGrade);
        System.out.println("Стипендия: " + stipend);
        System.out.println();
    }
}
