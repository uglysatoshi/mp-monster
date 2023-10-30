public class Main {
    public static void Base() {
        Triangle t = new Triangle();
        System.out.print(t);
    }
    public static void Medium() {
        ComplexNumber a = new ComplexNumber(67, 12);
        System.out.print(a);
    }
    public static void main(String[] args) {
        Base();
        Medium();
    }
}