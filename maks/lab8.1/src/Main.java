import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void Base() {
        // Объявляем список
        LinkedList<Matriculant> list = new LinkedList<>();
        // Заполняем список из файла
        createAbiList(list);
        // Выводим список
        printAbiList(list);
        // Поиск абитуриентов с проходным баллом <= 4
        findAfter4(list);
    }
    private static void createAbiList(LinkedList<Matriculant> list) {
        File file = new File("abi.txt");
        try(Scanner fl = new Scanner(file)) {
            while(fl.hasNextLine()) {
                // выделяем память под новый элемент[
                Matriculant abi = new Matriculant();
                // заполняем все поля abi из файла
                abi.lastname = fl.nextLine();
                abi.firstname = fl.nextLine();
                abi.surname = fl.nextLine();
                abi.gender = fl.nextLine();
                abi.nationality = fl.nextLine();
                abi.birth = fl.nextLine();
                abi.address = fl.nextLine();
                abi.GPA = fl.nextDouble(); fl.nextLine();
                abi.passingScore = fl.nextDouble(); fl.nextLine();
                fl.nextLine();
                // заносим car в список
                list.add(abi);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private static void printAbiList(LinkedList<Matriculant> list) {
        System.out.print("Вся информация о абитуриентах: \n");
        for(Matriculant m : list) {
            m.show();
        }
    }
    private static void findAfter4(LinkedList<Matriculant> list) {
        System.out.print("Абитуриенты с проходным баллом <= 4: \n");
        for(Matriculant m : list) {
            if(m.passingScore > 4) m.show();
        }
    }
    public static void Medium() {
        // Объявляем список
        LinkedList<Character> list = new LinkedList<>();
        // Считываем данные из f2
        readCharFile("f2.txt", list);
        // Считываем данные из f1
        readCharFile("f1.txt", list);
        // Переносим получившийся список в f2
        printToFile(list);
    }
    private static void readCharFile(String path, LinkedList<Character> list) {
        File file = new File(path);
        try(Scanner fl = new Scanner(file)) {
            while(fl.hasNextLine()) {
                // заносим файл в список
                list.add(fl.nextLine().charAt(0));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private static void printToFile(LinkedList<Character> list) {
        try (FileWriter writer = new FileWriter("f2.txt")) {
            // Посимвольно вносим список в файл
            for (Character c : list) {
                writer.write(c + "\n");
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void Hard() {
        String inputFileName = "matrices.txt";
        String symmetricFileName = "symmetric_matrices.txt";
        String asymmetricFileName = "asymmetric_matrices.txt";
        // Чтение матриц из файла и их разделение на симметричные и асимметричные
        LinkedList<double[][]> matrices = readMatricesFromFile(inputFileName);
        LinkedList<double[][]> symmetricMatrices = new LinkedList<>();
        LinkedList<double[][]> asymmetricMatrices = new LinkedList<>();
        for (double[][] matrix : matrices) {
            if (isSymmetric(matrix)) {
                symmetricMatrices.add(matrix);
            } else {
                asymmetricMatrices.add(matrix);
            }
        }
        // Запись симметричных и асимметричных матриц в файлы
        writeMatricesToFile(symmetricFileName, symmetricMatrices);
        writeMatricesToFile(asymmetricFileName, asymmetricMatrices);
        // Вывод результатов на экран
        System.out.println("Симметричные матрицы:");
        displayMatrices(symmetricMatrices);
        System.out.println("\nАсимметричные матрицы:");
        displayMatrices(asymmetricMatrices);
    }
    // Чтение матриц из файла
    private static LinkedList<double[][]> readMatricesFromFile(String fileName) {
        LinkedList<double[][]> matrices = new LinkedList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                int n = scanner.nextInt(); // Чтение размерности матрицы
                double[][] matrix = new double[n][n]; // Создание матрицы заданной размерности
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = scanner.nextDouble(); // Заполнение элементами матрицы
                    }
                }
                matrices.add(matrix);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return matrices;
    }
    // Проверка матрицы на симметрию
    private static boolean isSymmetric(double[][] matrix) {
        int n = matrix.length;
        if (n != matrix[0].length) {
            return false; // Несимметричные матрицы имеют разное количество строк и столбцов
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false; // Матрица не симметрична
                }
            }
        }
        return true;
    }

    // Запись матриц в файл
    private static void writeMatricesToFile(String fileName, LinkedList<double[][]> matrices) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (double[][] matrix : matrices) {
                int n = matrix.length;
                writer.write(Integer.toString(n)); // Запись размерности матрицы в файл
                writer.newLine();
                for (double[] doubles : matrix) {
                    for (int j = 0; j < n; j++) {
                        writer.write(Double.toString(doubles[j])); // Запись элементов матрицы в файл
                        if (j < n - 1) {
                            writer.write(" ");
                        }
                    }
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Вывод матриц на экран
    private static void displayMatrices(LinkedList<double[][]> matrices) {
        for (double[][] matrix : matrices) {
            for (double[] doubles : matrix) {
                for (double aDouble : doubles) {
                    System.out.print(aDouble + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}