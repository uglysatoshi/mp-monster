import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void Base() {
        // Объявляем список
        LinkedList<Book> list = new LinkedList<>();
        // Вписываем значения в бинарный файл
        writeBinTV();
        // Считываем бинарный файл
        createBookList(list);
        // Выводим книги содержащие в названии 'убийство'
        findKillerString(list);
    }
    // функция записи в бинарный файл
    private static void writeBinTV() {
        try {
            FileOutputStream fos = new FileOutputStream("book.bin");
            DataOutputStream dos = new DataOutputStream(fos);
            // создаем массивы записей для переноса в бинарный файл
            String[] authors = new String[]{"Агата Кристи", "Виктор Пелевин", "Трумен Капоте"};
            String[] bookNames = new String[]{"Убийство в доме викария", "KGBT+", "Хладнокровное убийство"};
            String[] circulations = new String[]{"1000 экземпляров", "500.000 экземпляров", "300 экземпляров"};
            String[] price = new String[]{"460 рублей", "1070 рублей", "352 рубля"};
            String[] yearOfPublish = new String[]{"1930 г.", "2021 г.", "1965 г."};
            // заносим в бинарный файл
            for (int i = 0; i < authors.length; i++) {
                dos.writeUTF(authors[i]);
                dos.writeUTF(bookNames[i]);
                dos.writeUTF(circulations[i]);
                dos.writeUTF(price[i]);
                dos.writeUTF(yearOfPublish[i]);
            }
            dos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void createBookList(LinkedList<Book> list) {
        try {
            FileInputStream fis = new FileInputStream("book.bin");
            DataInputStream dis = new DataInputStream(fis);
            // пока в бинарном файле есть значения
            while(dis.available() > 0) {
                // выделяем память на переменной
                Book b = new Book();
                // заносим данные из бинарного файла в поля
                b.author = dis.readUTF();
                b.nameOfBook = dis.readUTF();
                b.circulation = dis.readUTF();
                b.price = dis.readUTF();
                b.yearOfPublish = dis.readUTF();
                // заносим заполненную переменную в список
                list.add(b);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void findKillerString(LinkedList<Book> list) {
        // Проходим по списку и выводим книги содержащие в названии 'убийство'
        System.out.print("Книги содержащие в названии слово 'убийство':\n");
        for(Book b : list) {
            if(b.nameOfBook.contains("Убийство") || b.nameOfBook.contains("убийство")) b.show();
        }
    }
    public static void Medium() {
        LinkedList<Double> numbers = new LinkedList<>();
        // Генерируем некоторое количество вещественных чисел
        for (int i = 0; i < 10; i++) {
            double number = Math.random() * 100; // Генерируем числа от 0 до 100
            numbers.add(number);
        }
        String fileName = "numbers.bin";
        // Записываем числа в бинарный файл
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            for (double number : numbers) {
                dos.writeDouble(number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Читаем и изменяем бинарный файл
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            while (raf.getFilePointer() < raf.length()) {
                double originalNumber = raf.readDouble();
                raf.seek(raf.getFilePointer() - 8); // Перемещаем указатель обратно
                double modifiedNumber = originalNumber * 1.5;
                raf.writeDouble(modifiedNumber);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Выводим исходные и измененные значения
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("Исходные значения:");
            for (double number : numbers) {
                System.out.printf("%.3f\n", number);
            }
            System.out.println("Измененные значения:");
            while (dis.available() > 0) {
                double modifiedNumber = dis.readDouble();
                System.out.printf("%.3f\n", modifiedNumber);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void Hard() {
        // Объявляем список
        LinkedList<Clients> list = new LinkedList<>();
        // Прописываем путь до файла
        String fileName = "clients.bin";
        // Вводим значения для записи в файл
        list.add(new Clients("Лубышев Кирилл", 50.0, 1, 3));
        list.add(new Clients("Львов Максим", 70.0, 2, 4));
        list.add(new Clients("Ложкин Иван", 30.0, 6, 1));
        list.add(new Clients("Колтыга Валерий", 110.0, 2, 8));
        // Записываем клиентов в бинарный файл
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for (Clients client : list) {
                oos.writeObject(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Читаем и изменяем бинарный файл
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName)) {
            // Наследуем объект для упрощения взаимодействия с чтением
            @Override
            protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
                if (desc.getName().equals(Clients.class.getName())) {
                    return Clients.class;
                }
                return super.resolveClass(desc);
            }
        }) {
            LinkedList<Clients> updatedClients = new LinkedList<>();
            // Считываем объекты из файла
            while (true) {
                try {
                    Clients client = (Clients) ois.readObject();
                    client.reducePayment();
                    updatedClients.add(client);
                } catch (EOFException e) {
                    break;
                }
            }
            // Печатаем исходные и измененные значения
            System.out.println("Исходные значения:");
            for (Clients client : list) {
                System.out.println(client);
            }
            System.out.println("Измененные значения:");
            for (Clients client : updatedClients) {
                System.out.println(client);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
        public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}