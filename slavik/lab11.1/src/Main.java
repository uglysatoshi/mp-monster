public class Main {
    public static void Base() {
        System.out.print(new Numbers(56.0, 782.39));
    }
    public static void Medium() {
        System.out.print(new Book("Программирование для дебилов", 405, 6000));
    }
    public static void main(String[] args) {
        Base();
        Medium();
    }
}