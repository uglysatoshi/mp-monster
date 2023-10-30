import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void Base() {
        // Объявляем список
        LinkedList<Auto> list = new LinkedList<>();
        // Заполняем список значениями из файла
        CreateAutoList(list);
        // Выводим все элементы списка
        showAllAuto(list);
        // Выводим машины старше двух лет
        show2years(list);
    }
    private static void CreateAutoList(LinkedList<Auto> list) {
        File file = new File("Auto.txt");
        try(Scanner fl = new Scanner(file)) {
            while(fl.hasNextLine()) {
                // выделяем память под новый элемент car
                Auto car = new Auto();
                // заполняем все поля car из файла
                car.label = fl.nextLine();
                car.color = fl.nextLine();
                car.WIN = fl.nextLine();
                car.regNum = fl.nextLine();
                car.yearRelease = fl.nextInt();fl.nextLine();
                car.yearTO = fl.nextInt();fl.nextLine();
                car.price = fl.nextInt();fl.nextLine();
                fl.nextLine();
                // заносим car в список
                list.add(car);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    // Выводим все элементы списка
    private static void showAllAuto(LinkedList<Auto> list) {
        System.out.print("Все элементы Auto: \n");
        for(Auto a : list) {
            a.show();
        }
        System.out.print("\n");
    }
    private static void show2years(LinkedList<Auto> list) {
        System.out.print("Машины старше двух лет: \n");
        // Проходим по списку и ищем машины старше 2х лет
        for(Auto a : list) {
            if(2023 - a.yearRelease > 2) a.show();
        }
        System.out.print("\n");
    }
    public static void Medium() {
        LinkedList<Character> list = new LinkedList<>();
        createCharList(list);
        firstTwoLetters(list);
    }
    private static void createCharList(LinkedList<Character> list) {
        File file = new File("charFile.txt");
        try(Scanner fl = new Scanner(file)) {
            while(fl.hasNextLine()) {
                // Берем строку, забираем из нее символ и передаем его в список
                list.add(fl.nextLine().charAt(0));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private static void firstTwoLetters(LinkedList<Character> list) {
        if(list.size() > 2) {
            if(Character.isDigit(list.get(0)) && Character.isDigit(list.get(1))) {
                if(((int) list.get(0) + (int) list.get(1) - 96) % 2 == 0) {
                    System.out.print("Два первых символа являются цифрами и их сумма четна\n\n");
                } else {
                    System.out.print("Два первых символа являются цифрами и их сумма нечетна\n\n");
                }
            } else {
                System.out.print("Первые два символа не цифры\n\n");
            }
        } else {
            System.out.print("В файле меньше двух символов\n\n");
        }
    }
    public static void Hard() {
        try {
            // Заполняем списки значениями двух файлов
            LinkedList<String> matrix1Data = readFile("matrix1.txt");
            LinkedList<String> matrix2Data = readFile("matrix2.txt");
            // Объявляем конченый список
            LinkedList<String> matrixFinalData = new LinkedList<>();
            // Заполняем конченый список по заданию
            int matrixCount = Math.min(matrix1Data.size(), matrix2Data.size());
            for (int i = 0; i < matrixCount; i++) {
                if (i % 2 == 0) {
                    matrixFinalData.add(matrix2Data.get(i));
                } else {
                    matrixFinalData.add(matrix1Data.get(i));
                }
            }
            // Запись оставшихся матриц в matrixFinalData
            if (matrix1Data.size() > matrixCount) {
                matrixFinalData.addAll(matrix1Data.subList(matrixCount, matrix1Data.size()));
            }
            if (matrix2Data.size() > matrixCount) {
                matrixFinalData.addAll(matrix2Data.subList(matrixCount, matrix2Data.size()));
            }
            // Вносим список в файл
            writeToFile("matrixFinal.txt", matrixFinalData);
            // Выводим содержимое файлов
            System.out.println("Содержимое matrix1.txt:");
            printFileContents("matrix1.txt");
            System.out.println("Содержимое matrix2.txt:");
            printFileContents("matrix2.txt");
            System.out.println("Содержимое matrixFinal.txt:");
            printFileContents("matrixFinal.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Функция чтения из файла
    private static LinkedList<String> readFile(String fileName) throws IOException {
        LinkedList<String> lines = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }
    // Функция ввода в файл
    private static void writeToFile(String fileName, LinkedList<String> data) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (String line : data) {
            writer.write(line);
            writer.newLine();
        }
        writer.close();
    }
    // Функция вывода значений файла
    private static void printFileContents(String fileName) throws IOException {
        LinkedList<String> lines = readFile(fileName);
        for (String line : lines) {
            System.out.println(line);
        }
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}