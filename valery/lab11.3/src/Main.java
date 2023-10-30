import Base.*;
import Hard.*;
import Medium.*;

import java.util.ArrayList;

public class Main {
    public static void Base() {
        Phone phone = new Phone();
        phone.show();
        PhoneChild phoneChild = new PhoneChild();
        phoneChild.show();
    }
    public static void Medium() {
        Student student = new Student();
        student.info();
        StudentContract studentContract1 = new StudentContract();
        studentContract1.info();
        StudentContract studentContract2 = new StudentContract();
        studentContract2.info();
        student.courseIncrease();
        studentContract1.courseIncrease();
        studentContract2.courseIncrease();
        student.info();
        studentContract1.info();
        studentContract2.info();
    }
    public static void HelloRecursion(ArrayList<Person> arr, int index) {
        if(arr.size() <= index+1) { // первый преветствует последнего
            arr.get(index).Hello(arr.get(0));
            return;
        }
        arr.get(index).Hello(arr.get(index+1));
        HelloRecursion(arr, index+1);
    }
    public static void Hard() {
        ArrayList<Person> arr = new ArrayList<>();
        // ввод псевдослучайных элементов
        for(int i = 0; i < 5; i++) {
            int answer = (int) (Math.random() * (4 - 1) + 1);
            if(answer == 1) arr.add(new Formal());
            if(answer == 2) arr.add(new Informal());
            if(answer == 3) arr.add(new Real());
        }
        //вызов рекурсивной функции для преветствия
        HelloRecursion(arr, 0);
        System.out.println();
        // вывод информации о всех людях
        for(Person person : arr) {
            person.About();
        }
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}