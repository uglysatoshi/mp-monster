import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static class CarOwner {
        // поля класса
        String ownerFio;
        String ownerPhone;
        String ownerAddress;
        String carBrand;
        String carNumber;
        String carTechpass;
        //функция вывода в консоль
        void show() {
            System.out.println("ФИО владельца: " + ownerFio);
            System.out.println("Номер телефона владельца: " + ownerPhone);
            System.out.println("Адресс владельца: " + ownerAddress);
            System.out.println("Марка машины: " + carBrand);
            System.out.println("Номер машины: " + carNumber);
            System.out.println("Номер техпаспорта машины: " + carTechpass);
            System.out.println();
        }
    }
    // функция создания списка элементов CarOwner из файла
    private static void createCOList(LinkedList<CarOwner> list) {
        File file = new File("carowner.txt");
        try(Scanner fl = new Scanner(file)) {
            while(fl.hasNextLine()) {
                // выделяем память под новый элемент car
                CarOwner car = new CarOwner();
                // заполняем все поля car из файла
                car.ownerFio = fl.nextLine();
                car.ownerPhone = fl.nextLine();
                car.ownerAddress = fl.nextLine();
                car.carBrand = fl.nextLine();
                car.carNumber = fl.nextLine();
                car.carTechpass = fl.nextLine();
                fl.nextLine();
                // заносим car в список
                list.add(car);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    // поиск по списку
    private static void findCO(LinkedList<CarOwner> list) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите марку для поиска: "); String str = in.next();
        boolean found = false;
        // прохходим по элементам списка
        for (CarOwner carOwner : list) {
            // если марка машины равна введеному значению
            if(carOwner.carBrand.equals(str)) {
                carOwner.show();
                found = true;
            }
        }
        // если элемент не найден
        if(!found) {
            System.out.println("Ни одной записи с данной маркой машины не найдено");
        }
    }
    // создание динамического массива из файла
    private static void createArr(ArrayList<Double> arr) {
        File file = new File("components.txt");
        try(Scanner fl = new Scanner(file)) {
            // пока есть следующий элемент
            while(fl.hasNextDouble()) {
                // заносим элемент в массив
                arr.add(fl.nextDouble());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    // создание списка матриц из файла
    private static void createListOfArr(LinkedList<int[][]> list) {
        File file = new File("matrix.txt");
        try(Scanner fl = new Scanner(file)) {
            // пока возможно считать следующую строку
            while(fl.hasNextLine()) {
                // берем строку и переводим в int
                int n = Integer.parseInt(fl.nextLine());
                int[][] arr = new int[n][n];
                // заполняем матрицу значениями из файла
                for (int i = 0; i < n; i++) {
                    for(int j = 0; j < n; j++) {
                        arr[i][j] = fl.nextInt();
                    }
                    fl.nextLine();
                }
                // добавляем матрицу в файл
                list.add(arr);
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    // вывод матрицы в консоль
    private static void arrShow(int[][] arr) {
        for (int[] ints : arr) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
    // функция нахождения суммы положительных четных элементов матрицы
    private static int arrSum(int[][] arr) {
        int sum = 0;
        for(int[] ints : arr) {
            for (int j = 0; j < arr.length; j++) {
                if(ints[j] % 2 == 0 && ints[j] > 0) {
                    // суммируем все элементы
                    sum += ints[j];
                }
            }
        }
        return sum;
    }
    // функция вноса четных матриц в новый файл
    private static void writeArr(LinkedList<int[][]> list) {
        try (FileWriter writer = new FileWriter("matrixNew.txt")) {
            for (int[][] arr : list) {
                // если сумма четная, перезаписываем в носвый файл
                if(arrSum(arr) % 2 == 0) {
                    for (int[] ints : arr) {
                        for (int j = 0; j < arr.length; j++) {
                            writer.write(ints[j] + " ");
                        }
                        writer.write("\n");
                    }
                }
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // функция перезаписи старого файла
    private static void reWrite(LinkedList<int[][]> list) {
        try (FileWriter writer = new FileWriter("matrix.txt")) {
            for(int [][] arr : list) {
                // если сумма четная перезаписываем как единичную матрицу, иначе оставляемк как есть
                if(arrSum(arr) % 2 == 0) {
                    writer.write(arr.length + "\n");
                    for (int i = 0; i < arr.length; i++) {
                        for (int j = 0; j < arr.length; j++) {
                            writer.write("1 ");
                        }
                        writer.write("\n");
                    }
                }
                else {
                    writer.write(arr.length + "\n");
                    for (int[] ints : arr) {
                        for (int j = 0; j < arr.length; j++) {
                            writer.write(ints[j] + " ");
                        }
                        writer.write("\n");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // функция вывода обоих файлов
    private static void Print() {
        System.out.println("Файл matrix.txt после обработки: ");
        File file = new File("matrix.txt");
        try(Scanner fl = new Scanner(file)) {
            while(fl.hasNextLine()) {
                System.out.println(fl.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Файл matrixNew.txt после обработки: ");
        file = new File("smatrixNew.txt");
        try (Scanner fl = new Scanner(file)) {
            while(fl.hasNextLine()) {
                System.out.println(fl.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void Base() {
        // выделение памяти под список
        LinkedList<CarOwner> list = new LinkedList<>();
        // занесение в список значений из файла
        createCOList(list);
        // вывод файла в консоль
        for (CarOwner carOwner : list) {
            carOwner.show();
        }
        // функция поиск элемента
        findCO(list);
    }
    public static void Medium() {
        // выделение памяти под массив
        ArrayList<Double> arr = new ArrayList<>();
        // занесение в массив элементов из файла
        createArr(arr);
        // вывод массива в консоль
        for (Double aDouble : arr) {
            System.out.print(aDouble + " ");
        }
        System.out.println();
        double multiply = 1.0;
        double sum = 0.0;
        // нахождение суммы и произведения
        for (Double aDouble : arr) {
            multiply *= aDouble;
            sum += aDouble;
        }
        // вывод модуля суммы и квадрата произведения в консоль
        System.out.println("Модуль суммы компонентов файла: " + Math.abs(sum));
        System.out.println("Квадрат произведения компонентов файла: " + String.format("%3.5f", Math.pow(multiply, 2)));
        System.out.println();
    }
    public static void Hard() {
        // выделяем память для списка
        LinkedList<int[][]> list = new LinkedList<>();
        // заполняем список
        createListOfArr(list);
        // выводим матрицу, и ее сумму
        for(int[][] arr : list) {
            arrShow(arr);
            System.out.println("Сумма четных положиетльных элементов матрицы: " + arrSum(arr));
            System.out.println();
        }
        // записываем новую матриу
        writeArr(list);
        // перезаписываем старую матрицу
        reWrite(list);
        // вывовдим оба файла
        Print();
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}