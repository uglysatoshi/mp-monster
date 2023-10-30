import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static class TV {
        // поля класс
        String tvFirm;
        int tvDiagonal;
        String tvPrice;
        // функция вывода полей в консоль
        void show() {
            System.out.println("Фирма: " + tvFirm);
            System.out.println("Диагональ: " + tvDiagonal);
            System.out.println("Цена: " + tvPrice);
            System.out.println();
        }
    }
    static class Credit {
        // поля класа
        String fio;
        String date;
        int costFirst;
        int costLast;
        int costPercent;
        // функция вывода полей в консоль
        void show() {
            System.out.println("ФИО: " + fio);
            System.out.println("Дата: " + date);
            System.out.println("Общая стоимость за первое полугодие: " + costFirst);
            System.out.println("Общая стоимость за второе полугодие: " + costLast);
            System.out.println("Процент скидки: " + costPercent);
            System.out.println();
        }
    }
    // функция записи в бинарный файл
    private static void writeBinTV() {
        try {
            FileOutputStream fos = new FileOutputStream("tv.bin");
            DataOutputStream dos = new DataOutputStream(fos);
            // создаем массивы записей для переноса в бинарный файл
            String[] firms = {"Samsung", "HP", "Samsung", "Apple"};
            int[] diagonals = {40, 20, 25, 65};
            String[] costs = {"700$", "500$", "800$", "1200$"};
            // заносим  в бинарный файл
            for (int i = 0; i < firms.length; i++) {
                dos.writeUTF(firms[i]);
                dos.writeInt(diagonals[i]);
                dos.writeUTF(costs[i]);
            }
            dos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // заполенение списка из бинарного файла
    private static void createTVList(LinkedList<TV> list) {
        try {
            FileInputStream fis = new FileInputStream("tv.bin");
            DataInputStream dis = new DataInputStream(fis);
            // пока в бинарном файл есть значения
            while(dis.available() > 0) {
                // выделяем память на переменной
                TV tv = new TV();
                // заносим данные из бинарного файла в поля
                tv.tvFirm = dis.readUTF();
                tv.tvDiagonal = dis.readInt();
                tv.tvPrice = dis.readUTF();
                // заносим заполненную переменную в список
                list.add(tv);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // поиск элемента в списке
    private static void findTV(LinkedList<TV> list) {
        System.out.println("Поиск телевизоров Samsung больше 34 дюймов: ");
        // переменная для проверки надена ли была запись
        boolean found = false;
        for (TV tv : list) {
            // Если телевизор от фирмы samsung и диагональю строго больше 34
            if(tv.tvFirm.equals("Samsung") && tv.tvDiagonal > 34) {
                // выводим в консоль
                tv.show();
                // обозначаем что запись была найдена
                found = true;
            }
        }
        // если запись не найдена
        if(!found) {
            System.out.println("Не найдено ни одной записи с подходящим условием");
        }
    }
    // запись в бинарный файл массив символов
    private static void writeBinMemo(String str) {
        try {
            FileOutputStream fos = new FileOutputStream("memo.bin");
            DataOutputStream dos = new DataOutputStream(fos);
            // переводим строку в массив символов
            char[] arr = str.toCharArray();
            for (char c : arr) {
                // заносим каждый символ в бинарный файл
                dos.writeChar(c);
            }
            dos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // чтение из бинарного файла массива символов
    private static void readBinMemo(ArrayList<Character> arr) {
        try {
            FileInputStream fis = new FileInputStream("memo.bin");
            DataInputStream dis = new DataInputStream(fis);
            // пока в бинарном файле имеются записи
            while(dis.available() > 0) {
                // заносим символ в массив
                arr.add(dis.readChar());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // запись в бинарный файл
    private static void writeBinCredit() {
        try {
            FileOutputStream fos = new FileOutputStream("credit.bin");
            DataOutputStream dos = new DataOutputStream(fos);
            // записи для записи в бинарный файл
            String[] fio = {"Шадрин Е.М.", "Лубышев К.И.", "Ложкин И.А.", "Куцоконь Я.Р."};
            String[] date = {"22.11.2002", "23.05.2009", "28.08.2009", "11.05.2012"};
            int[] costsFirst = {1200, 7000, 800, 3500};
            int[] costsLast = {3000, 12000, 5000, 8000};
            int[] costsPercents = {3, 4, 12, 5, 2};
            // заносим записи в бинарный файл
            for (int i = 0; i < fio.length; i++) {
                dos.writeUTF(fio[i]);
                dos.writeUTF(date[i]);
                dos.writeInt(costsFirst[i]);
                dos.writeInt(costsLast[i]);
                dos.writeInt(costsPercents[i]);
            }
            dos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // заполнение списка из бинарного файла
    private static void createCRList(LinkedList<Credit> list) {
        try {
            FileInputStream fis = new FileInputStream("credit.bin");
            DataInputStream dis = new DataInputStream(fis);
            // пока в бинарном файле имеются записи
            while(dis.available() > 0) {
                // выделяем память под переменную
                Credit cr = new Credit();
                // заносим в поля данные из бинарного файла
                cr.fio = dis.readUTF();
                cr.date = dis.readUTF();
                cr.costFirst = dis.readInt();
                cr.costLast = dis.readInt();
                cr.costPercent = dis.readInt();
                // вносим заполненную переменную в список
                list.add(cr);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // перезапись бинарного файла
    private static void reWriteCRBin(LinkedList<Credit> list) {
        try {
            FileOutputStream fos = new FileOutputStream("credit.bin");
            DataOutputStream dos = new DataOutputStream(fos);
            for (Credit cr : list) {
                // условие индивидуального задания
                if (cr.costFirst + cr.costLast >= 10000) {
                    cr.costPercent += 7;
                }
                // перезапись файла
                dos.writeUTF(cr.fio);
                dos.writeUTF(cr.date);
                dos.writeInt(cr.costFirst);
                dos.writeInt(cr.costLast);
                dos.writeInt(cr.costPercent);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void Base() {
        // выделение памяти для списка
        LinkedList<TV> list = new LinkedList<>();
        // записываем в бинарный файл
        writeBinTV();
        // заполенение списка из бинарного файла
        createTVList(list);
        // вывод списка
        for (TV tv : list) {
            tv.show();
        }
        // поиск по значению
        findTV(list);
    }
    public static void Medium() {
        // выделяем память под динамический массив
        ArrayList<Character> arr = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку из русских символов: "); String str = in.nextLine();
        // записываем сроку как симольный масив и вносим в бинарный файл
        writeBinMemo(str);
        // читаем из бинарного файла и заносим в динамический массив
        readBinMemo(arr);
        // выводим массив в консоль
        for (Character c : arr) {
            System.out.print(c);
        }
        System.out.println();
        // переводим в верний регистр и вносим в бинарный файл
        writeBinMemo(str.toUpperCase());
        // меняем ссылку на новый массив
        arr = new ArrayList<>();
        // перезаполняем массив
        readBinMemo(arr);
        // выводим в консоль
        for (Character c : arr) {
            System.out.print(c);
        }
        System.out.println();
    }
    public static void Hard() {
        // выделяем память для списка
        LinkedList<Credit> list = new LinkedList<>();
        // заполняем бинарный файл
        writeBinCredit();
        // заполняем список из бинарного файла
        createCRList(list);
        // выводим список в консоль
        System.out.println("Вывод бинарного файла до обработки: ");
        for(Credit cr : list) {
            cr.show();
        }
        // переписываем бинарный файл
        reWriteCRBin(list);
        // меняем ссылку на новый список
        list = new LinkedList<>();
        // перезаполняем список
        createCRList(list);
        // выводим в консоль
        System.out.println("Вывод бинарного файла после обработки: ");
        for(Credit cr : list) {
            cr.show();
        }
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}