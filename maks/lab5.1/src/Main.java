import java.util.*;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите значение верхнего основания, нижнего основания, и высоты первой трапеции: ");
        // Вводим необходимые значения и выводим результат
        System.out.printf("P = %.1f\n", trapecPerim(Math.abs(scan.nextDouble()), Math.abs(scan.nextDouble()), Math.abs(scan.nextDouble())));
        System.out.print("Введите значение верхнего основания, нижнего основания, и высоты второй трапеции: ");
        System.out.printf("P = %.1f\n\n", trapecPerim(Math.abs(scan.nextDouble()), Math.abs(scan.nextDouble()), Math.abs(scan.nextDouble())));
    }
    private static double trapecPerim(double osn1, double osn2, double vis) {
        // Возвращаем значение по формуле
        return osn1 + osn2 + 2*(Math.sqrt(Math.pow(vis, 2) + Math.pow(osn2 - osn1, 2)));
    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        // Объявляем массив
        ArrayList <Integer> arr = new ArrayList<>();
        // Заполняем массив
        System.out.print("Введите 10 элементов массива: ");
        for(int i = 0; i < 10; i++) {
            arr.add(scan.nextInt());
        }
        // Сортируем массив
        arr.sort(Comparator.reverseOrder());
        // Выводим массив
        System.out.printf("Массив после сортировки: %s\n\n", arr);
    }
    public static void Hard() {
        Scanner scan = new Scanner(System.in);
        // Вводим количество элементов массива
        // PS. Чем больше число тем нагляднее результат
        // PSS. Сложность nlog(n)
        System.out.print("Введите количество элементов массива: ");
        int N = scan.nextInt();
        // Объявляем массив размером N, обходя возможные отрицательные значения
        int[] arr = new int[Math.abs(N)];
        // Заполняем массив псевдослучайными элементами
        for(int i = 0;i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 2000) - 1;
        }
        // Выводим не отсортированный массив
        System.out.printf("Не отсортированный массив: %s\n", Arrays.toString(arr));
        // Вызываем алгоритм сортировки Неймана
        mergeSort(arr, 0, arr.length-1);
        // Выводим отсортированный массив
        System.out.printf("Массив после сортировки алгоритмом Неймана: %s", Arrays.toString(arr));
    }
    // Функция для слияния двух подмассивов arr[l..m] и arr[m+1..r]
    static void merge(int[] arr, int l, int m, int r) {
        // Находим размеры двух подмассивов, которые нужно слить
        int n1 = m - l + 1;
        int n2 = r - m;
        // Создаем временные массивы
        int[] L = new int[n1];
        int[] R = new int[n2];
        // Копируем данные во временные массивы L[] и R[]
        System.arraycopy(arr, l, L, 0, n1);
        for (int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];
        // Инициализируем индексы подмассивов L[] и R[]
        int i = 0, j = 0;
        // Инициализируем индекс подмассива arr[]
        int k = l;
        // Сливаем временные массивы L[] и R[] обратно в arr[l..r]
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        // Копируем оставшиеся элементы L[], если они есть
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        // Копируем оставшиеся элементы R[], если они есть
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Главная функция, которая выполняет сортировку слиянием для всего массива
    static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            // Находим средний элемент массива
            int m = l + (r - l) / 2;
            // Сортируем первую и вторую половины
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            // Сливаем отсортированные половины
            merge(arr, l, m, r);
        }
    }

    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}