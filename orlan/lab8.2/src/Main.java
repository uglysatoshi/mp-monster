import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void Base() {
        LinkedList <Jazz> list = new LinkedList<>();
        writeBinJazz();
        createJazzList(list);
        findJazz(list);
        System.out.print("\n\n");
    }
    // Функция записи в бинарный файл
    private static void writeBinJazz() {
        try {
            FileOutputStream fos = new FileOutputStream("jazz.bin");
            DataOutputStream dos = new DataOutputStream(fos);
            // создаем массивы записей для переноса в бинарный файл
            String[] lastnames = {"Армстронг", "Гудмен", "Эллингтон", "Дэвис", "Паркер"};
            String[] albumName = {"What a Wonderful World", "Sometimes I'm Happy", "Piano in the Background", "Kind of Blue", "The Essential Charlie Parker"};
            int[] circulation = {100000, 5000, 600, 54000, 90};
            int[] yearOfPublish = {2023, 1990, 2023, 2004, 1978};
            int[] price = {70, 40, 11, 600, 10};
            // заносим в бинарный файл
            for (int i = 0; i < lastnames.length; i++) {
                dos.writeUTF(lastnames[i]);
                dos.writeUTF(albumName[i]);
                dos.writeInt(circulation[i]);
                dos.writeInt(yearOfPublish[i]);
                dos.writeInt(price[i]);
            }
            dos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // Заполнение списка из бинарного файла
    private static void createJazzList(LinkedList<Jazz> list) {
        try {
            FileInputStream fis = new FileInputStream("jazz.bin");
            DataInputStream dis = new DataInputStream(fis);
            // пока в бинарном файле есть значения
            while(dis.available() > 0) {
                // выделяем память на переменной
                Jazz j = new Jazz();
                // заносим данные из бинарного файла в поля
                j.lastname = dis.readUTF();
                j.albumName = dis.readUTF();
                j.circulation = dis.readInt();
                j.yearOfPublish = dis.readInt();
                j.price = dis.readInt();
                // заносим заполненную переменную в список
                list.add(j);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void findJazz(LinkedList <Jazz> list) {
        System.out.print("Альбомы вышедшие в этом году тиражом более 1000 и стоимостью более 50 грн:\n");
        for(Jazz j : list) {
            if(j.yearOfPublish == 2023 && j.circulation > 1000 && j.price > 50) {
                j.show();
            }
        }
    }
    public static void Medium() {
        // Объявляем матрицу для вноса в файл
        double[][] arr = {
                {7.9, 34.9, 67.1, 11.0, 89.6},
                {99.8, 11.8, 33.9, 77.2, 0.83},
                {71.9, 92.98, 84.9, 0.1, 88.1},
                {34.11, 43.22, 73.9, 34.22, 91.1},
                {523.0, 23.9, 1.0, 45.3, 11.3}
        };
        // Вносим матрицу в файл
        writeStrGrid(arr);
        // Считываем из бинарного файла
        double[][] nArr = readStrGrid();
        // Выводим матрицу до обработки
        System.out.print("Матрица до обработки:\n");
        printArr(nArr);
        // Умножаем каждый элемент на 1.5
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                nArr[i][j] *= 1.5;
            }
        }
        // Вносим в бинарный файл
        writeStrGrid(nArr);
        // Считываем бинарный файл
        double[][] last = readStrGrid();
        // Выводим бинарный файл после обработки
        System.out.print("Матрица после обработки:\n");
        printArr(last);
        System.out.print("\n\n");
    }
    private static void writeStrGrid(double[][] arr) {
        try {
            FileOutputStream fos = new FileOutputStream("strGrid.bin");
            DataOutputStream dos = new DataOutputStream(fos);
            for (double[] doubles : arr) {
                for (double aDouble : doubles) {
                    dos.writeDouble(aDouble);
                }
            }
            dos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static double[][] readStrGrid() {
        double[][] arr = new double[5][5];
        try {
            FileInputStream fis = new FileInputStream("strGrid.bin");
            DataInputStream dis = new DataInputStream(fis);
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    arr[i][j] = dis.readDouble();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return arr;
    }
    private static void printArr(double[][] arr) {
        for (double[] doubles : arr) {
            for (double aDouble : doubles) {
                System.out.printf("%.2f ", aDouble);
            }
            System.out.print("\n");
        }
    }
    public static void Hard() {
        LinkedList<Book> list = new LinkedList<>();
        writeBinBook();
        createBookList(list);
        System.out.print("Элементы до обработки: \n");
        for(Book b: list) {
            b.show();
        }
        reWriteBinBook(list);
        LinkedList<Book> nList = new LinkedList<>();
        createBookList(nList);
        System.out.print("Элементы после обработки: \n");
        for(Book b: nList) {
            b.show();
        }
    }
    // Заполнение списка из бинарного файла
    private static void createBookList(LinkedList<Book> list) {
        try {
            FileInputStream fis = new FileInputStream("book.bin");
            DataInputStream dis = new DataInputStream(fis);
            // пока в бинарном файле есть значения
            while(dis.available() > 0) {
                // выделяем память на переменной
                Book b = new Book();
                // заносим данные из бинарного файла в поля
                b.authorName = dis.readUTF();
                b.bookName = dis.readUTF();
                b.price = dis.readDouble();
                b.amount = dis.readInt();
                // заносим заполненную переменную в список
                list.add(b);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // Функция записи в бинарный файл
    private static void writeBinBook() {
        try {
            FileOutputStream fos = new FileOutputStream("book.bin");
            DataOutputStream dos = new DataOutputStream(fos);
            // создаем массивы записей для переноса в бинарный файл
            String[] authorNames = {"Пелевин В.О.", "Достоевский Ф.М.", "Замятин Е.И.", "Пастернак Б.Л.", "Булгаков М.А."};
            String[] bookNames = {"KGBT+", "Бесы", "Мы", "Доктор Живаго", "Мастер и Маргарита"};
            int[] amounts = {10, 40, 6, 400, 2};
            double[] prices = {70.6, 40.11, 11.7, 600.9, 10.0};
            // заносим в бинарный файл
            for (int i = 0; i < authorNames.length; i++) {
                dos.writeUTF(authorNames[i]);
                dos.writeUTF(bookNames[i]);
                dos.writeDouble(prices[i]);
                dos.writeInt(amounts[i]);
            }
            dos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // Функция перезаписи в бинарный файл
    private static void reWriteBinBook(LinkedList<Book> list) {
        try {
            FileOutputStream fos = new FileOutputStream("book.bin");
            DataOutputStream dos = new DataOutputStream(fos);
            for(Book b : list) {
                if(b.amount > 20) b.price *= 0.95;
                dos.writeUTF(b.authorName);
                dos.writeUTF(b.bookName);
                dos.writeDouble(b.price);
                dos.writeInt(b.amount);
            }
            dos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}