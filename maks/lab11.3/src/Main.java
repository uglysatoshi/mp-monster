import Base.ProgrammerL2;
import Medium.*;
import Hard.*;

import java.util.ArrayList;

public class Main {
    public static void Base() {
        ArrayList<ProgrammerL2> list = new ArrayList<>();
        // Добавляем в список 6 элементов
        list.add(new ProgrammerL2("Иргит", 10, 3, 4));
        list.add(new ProgrammerL2("Ложкин", 16, 3, 7));
        list.add(new ProgrammerL2("Мельников", 7, 3, 2));
        list.add(new ProgrammerL2("Кубкин", 3, 1, 3));
        list.add(new ProgrammerL2("Бубкин", 4, 3, 4));
        list.add(new ProgrammerL2("Дудкин", 8, 3, 6));
        // Выводим все элементы
        for(ProgrammerL2 p : list) {
            System.out.print(p);
        }
    }
    public static void Medium() {
        // Создаем объекты разных типов самолетов и инициализируем их параметры
        Plane plane = new Plane("Boeing", "747", 900, 13000);
        Bomber bomber = new Bomber("B-2 Spirit", "Stealth Bomber", 1000, 15000);
        Fighter fighter = new Fighter("F-22 Raptor", "Stealth Fighter", 2400, 20000);
        // Выводим информацию о каждом из самолетов
        System.out.println("Информация о Plane:");
        System.out.println(plane);
        System.out.println("Информация о Bomber:");
        System.out.println(bomber);
        System.out.println("Информация о Fighter:");
        System.out.println(fighter);
    }
    public static void HelloRecursion(ArrayList<Person> arr, int index) {
        if(arr.size() <= index+1) { // первый приветствует последнего
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
        //вызов рекурсивной функции для приветствия
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